<template>
  <div id="app">
<!--    <el-config-provider>-->
<!--      <router-view/>-->
<!--    </el-config-provider>-->
<!--    <img src="./assets/logo.png">-->
    <HelloWorld/>
  </div>
</template>

<script>
import HelloWorld from "./view/home";

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<style>
body {
  margin: 0px;
}
#app {
  /*font-family: 'Avenir', Helvetica, Arial, sans-serif;*/
  /*-webkit-font-smoothing: antialiased;*/
  /*-moz-osx-font-smoothing: grayscale;*/
  /*text-align: center;*/
  /*color: #2c3e50;*/
  /*margin-top: 60px;*/
}
</style>
