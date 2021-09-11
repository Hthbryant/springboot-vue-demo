<template>
  <div style="width: 100%;height: 100vh;background-color: darkslateblue;overflow: hidden">
    <div style="width: 400px;margin: 150px auto">
      <div style="color: #cccccc;font-size: 30px;text-align: center;padding: 30px">欢迎登录</div>
      <el-form ref="form" :model="form" size="normal">
        <el-form-item>
          <el-input prefix-icon="el-icon-user" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input prefix-icon="el-icon-key" type="password" v-model="form.password" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-input prefix-icon="el-icon-key" type="password" v-model="form.confirm" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;text-align: center;" type="primary" @click="register">登 录</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>

</template>

<script>
import request from "../utils/request";

export default {
  name: "Register",
  data() {
    return {
      form: {}
    }
  }, methods: {
    register() {
      request.post("api/user/register", this.form).then(res => {
        if (res.code === '0') {
          this.$message({
            type: "success",
            message: "注册成功"
          })
          this.$router.push("/login")   //登录成功后跳转到登录页面
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>