<template>
  <div>
    <el-button type="primary" icon="el-icon-edit"></el-button>
    <el-button type="primary" icon="el-icon-share"></el-button>
    <el-button type="primary" icon="el-icon-delete"></el-button>
    <el-button type="primary" icon="el-icon-search">搜索</el-button>
    <el-button type="primary">上传<i class="el-icon-upload el-icon--right"></i></el-button>

    <div>
      <!-- 用于触发文件夹选择的按钮 -->
      <el-button @click="openFolderPicker">选择文件夹2</el-button>
      <!-- 隐藏的文件选择器 -->
      <input ref="folderInput" type="file" style="display: none" @change="handleFolderChange" directory />
      <div>{{data}}</div>
    </div>
  </div>
</template>

<script>
import {queryLocalHostFile} from "../request/api"
export default {
  name: "File",
  path: "",

  data(){
    return{
      data: {},
    }
  },
  methods: {
    openFolderPicker() {
      // 触发隐藏的文件夹选择器点击事件
      this.$refs.folderInput.click();
    },
    handleFolderChange(event) {
      // 获取用户选择的文件夹路径
      const selectedPath = event.target.files[0].path;
      // 在这里可以处理用户选择的路径，例如将其保存到 Vue 的 data 中
      // 或者发送给服务器端进行后续处理等等
    },
    queryLocalHostFile(){
      queryLocalHostFile({
        path : ""
      }).then(res =>{
        this.data = res
        console.log(this.data)
      })
    }
  },
  created() {
    // 在组件被创建时调用接口
    this.queryLocalHostFile();
  },
}
</script>

<style scoped>

</style>
