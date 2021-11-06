<template>
  <div >
    <el-menu
        style="width: 200px;height: calc(100vh - 50px)"
        default-active="book"
        router
        :default-openeds="[1]"
        class="el-menu-vertical-demo">
        <el-submenu index="1">
          <template #title>系统管理</template>
          <el-menu-item index="user">用户管理</el-menu-item>
          <el-menu-item index="book">书籍管理</el-menu-item>
        </el-submenu>
      <el-submenu index="2">
        <template #title>校园信息</template>
        <el-menu-item index="2-1">建校历史</el-menu-item>
        <el-menu-item index="2-2">师资信息</el-menu-item>
        <el-menu-item index="2-3">校园风光</el-menu-item>
      </el-submenu>
      <el-submenu index="3">
        <template #title>学校历史数据</template>
        <el-menu-item index="3-1">历年录取分数线</el-menu-item>
        <el-menu-item index="3-2">课程信息</el-menu-item>
      </el-submenu>
      <el-submenu index="4">
        <template #title>校纪校规</template>
        <el-menu-item index="4-1">学生守则</el-menu-item>
        <el-menu-item index="4-2">教师守则</el-menu-item>
      </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <template #title>导航二</template>
        </el-menu-item>
        <el-menu-item index="3" disabled>
          <i class="el-icon-document"></i>
          <template #title>导航三</template>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-setting"></i>
          <template #title>导航四</template>
        </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>