<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color: deepskyblue">后台管理</div>
    <div style="flex: 1"></div>
    <div style="width: 100px" ref="user">
      <el-dropdown>
        <span class="el-dropdown-link">
          {{user.username}}
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="this.$router.push('/person')">个人信息</el-dropdown-item>
            <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  data(){
    return{
      user:{}
    }
  },
  created() {
    this.loadUserInfo();
  },methods:{
    loadUserInfo(){
      //获取用户信息
      let userStr = sessionStorage.getItem("user")
      if (userStr !== null) {
        this.user = JSON.parse(userStr)
      }
    },
    logout(){
      //注销登录，清除用户信息
      sessionStorage.removeItem("user")
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>