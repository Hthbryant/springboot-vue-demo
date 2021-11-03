<template>
  <div style="width: 100%;height: 100vh;background-color: darkslateblue;overflow: hidden">
    <div style="width: 400px;margin: 150px auto">
      <div style="color: #cccccc;font-size: 30px;text-align: center;padding: 30px">欢迎登录</div>
      <el-form ref="form" :model="form" size="normal" :rules="rules">
        <el-form-item prop="username">
          <el-input prefix-icon="el-icon-user" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input prefix-icon="el-icon-key" type="password" v-model="form.password" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;text-align: center;" type="primary" @click="login">登 录</el-button>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;text-align: center;/*background-color: bisque;*/" type="primary" @click="this.$router.push('/register')">没有账号？这里注册</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>

</template>

<script>
import request from "../utils/request";

export default {
  name: "Login",
  data() {
    return {
      form: {},
      rules: {
        username: [
          { required: true,message: '请输入用户名',trigger: 'blur',},
          { min: 1,max: 20,message: '用户名过长',trigger: 'blur',}],
        password: [
          { required: true,message: '请输入密码',trigger: 'blur',},
          { min: 1,max: 20,message: '密码过长',trigger: 'blur',}],
      }
    }
  }, methods: {
    login() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          request.post("/user/login", this.form).then(res => {
            if (res.code === '0') {
              this.$message({
                type: "success",
                message: "登录成功"
              })
              this.$router.push("/user")   //登录成功后跳转到主页
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>