<template>
  <div >
    <el-menu
        style="width: 200px;height: calc(100vh - 50px)"
        default-active="2"
        class="el-menu-vertical-demo">
        <el-submenu index="1">
          <template #title>选项一</template>
          <el-menu-item index="1-1">选项1-1</el-menu-item>
          <el-menu-item index="1-2">选项1-2</el-menu-item>
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