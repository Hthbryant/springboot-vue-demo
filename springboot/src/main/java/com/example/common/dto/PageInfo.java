package com.example.common.dto;

/**
 * @author 咕噜科
 * ClassName: PageInfo
 * date: 2021/8/25 2:04
 * Description: 分页对象
 * version 1.0
 */
public class PageInfo {

    private int currentPage = 1;
    private int pageSize = 5;
    private int totalPage;
    private int totalCount;

    public PageInfo(){

    }

    public PageInfo(int currentPage,int pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
