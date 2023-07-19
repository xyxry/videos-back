<template>
  <div style="min-width: 900px">
    <div class="head-title" >
      <div class="logo">
        <img style="height: 60px;width: 100px" src="../assets/logo-1.png">
      </div>
      <div class="centered-nav">
        <el-menu
          router
          :default-active="activeIndex2"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b" >
          <el-menu-item index="/index3" disabled=""></el-menu-item>
          <el-menu-item index="/index">首页</el-menu-item>
          <el-menu-item index="/vedio">视频</el-menu-item>
          <el-menu-item index="/photo">图片</el-menu-item>
          <el-menu-item index="5">分类</el-menu-item>
          <el-menu-item index="6">处理中心</el-menu-item>
          <el-submenu index="2">
            <template slot="title">我的工作台</template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
            <el-menu-item index="2-3">选项3</el-menu-item>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项1</el-menu-item>
              <el-menu-item index="2-4-2">选项2</el-menu-item>
              <el-menu-item index="2-4-3">选项3</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-menu-item index="3" disabled>消息中心</el-menu-item>
          <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
        </el-menu>
      </div>


    </div>


    <router-view></router-view>
  </div>

</template>

<script>
import index from "../components/index";
import video_playback from "../components/video-playback"
export default {
  name: 'HelloWorld',
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '/vedio'
    }
  },
  components: {
    index,
    video_playback
  },
  methods: {
    handleSelect(key, keyPath) {
      this.activeIndex2 = key
      console.log(key, keyPath);
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.head-title {
  display: flex;
  align-items: center;
  justify-content: space-between;
  /*height: 60px;*/
  background-color: rgb(84, 92, 100);
}
.el-menu.el-menu--horizontal{
  border-bottom:solid 0px white;
}
.centered-nav {
  flex: 1;
  display: flex;
  justify-content: center;
  margin-right: 160px;
}
.el-main {
  /*padding: 0px!important;*/
}

.el-menu {
  text-align: center !important;
}

.el-menu-item {
  display: inline-block !important;
}

.logo {
  margin-left: 60px;
  /*display: flex;*/
  /*align-items: center;*/
  /*padding: 10px;*/
  /*background-color: #f0f0f0;*/
}
</style>
