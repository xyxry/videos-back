<template>
  <div style="min-width: 1000px">
    <div class="head-title" >
      <div class="logo">
        <img style="height: 60px;width: 100px" src="../assets/logo-1.png">
<!--        <img style="height: 60px;width: 100px" src="C:/vue-web/pictures-videos/vedio/src/assets/logo-1.png">-->
      </div>
      <div class="centered-nav">
        <el-menu
          :router="true"
          :default-active="$activeMenu"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b" >
          <el-menu-item index="/index">首页</el-menu-item>
          <el-menu-item index="/vedio">视频</el-menu-item>
          <el-menu-item index="/photo">图片</el-menu-item>
          <el-menu-item index="5">分类</el-menu-item>
          <el-menu-item index="/file">文件处理中心</el-menu-item>
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
import index from "../components";
import File from "../components/File";
import video_playback from "../components/video/VideoPlayback"
import Vue from "vue";
export default {
  name: 'HelloWorld',
  data() {


    return {
      current2:'/index'
    }
  },
  components: {
    index,
    video_playback,
    File
  },
  methods: {
    handleSelect(key, keyPath) {
      this.activeIndex2 = key
      console.log(key);
      console.log(keyPath);
    },
    toHomePage(){
      // console.log


      // console.log(this.$route.path)
      if (this.$route.path.length == 1){
        this.$router.push({ name: 'Index' });
      }
    }
  },
  created() {
    // Set the initial active menu item based on the current route
    console.log(Vue.prototype.$activeMenu+'xxx')
    // Vue.prototype.$activeMenu = "/index"
    // this.activeIndex2 = '/index';

  },
  mounted() {
    this.toHomePage()
    // Vue.prototype.$activeMenu = "/index"

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
