package com.example.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author 咕噜科
 * ClassName: FileController
 * date: 2021-11-08 0:41
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {


    @PostMapping("/upload")
    public Result fileUpload(MultipartFile file,
                             HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse) throws IOException {
        String filename = file.getOriginalFilename();
        String uuid = IdUtil.fastSimpleUUID();
        String filePath = System.getProperty("user.dir") + "/springboot/src/main/resources/files/" + uuid + filename;
        FileUtil.writeBytes(file.getBytes(), filePath);
        return new Result();
    }


    @GetMapping("/download/{fileName}")
    public void fileDownload(@PathVariable String fileName,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        System.out.println("fileName = " + fileName);
        OutputStream os;
        String basePath = System.getProperty("user.dir") + "/springboot/src/main/resources/files/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String avatar = fileNames.stream().filter(name -> name.contains(fileName)).findAny().orElse("");
        try{
            if (StrUtil.isNotEmpty(avatar)) {
                response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(avatar,"UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + avatar);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            log.error("文件-{}下载失败",fileName);
        }
    }


}
