<template>
  <div>
    <el-row>
      <el-menu :router="true">
        {{productType}}
      </el-menu>
    </el-row>
    <div>
      <!-- 视频播放器 -->
      <video ref="videoPlayer" width="640" height="360" controls>
        <source src="http://localhost:8083/vedio.mp4" type="video/mp4">
        <!-- 支持多种视频格式，根据需求添加 source 元素 -->
      </video>

      <!-- 播放按钮 -->
      <button @click="playVideo">播放</button>
      <button @click="pauseVideo">暂停</button>
    </div>
  </div>

</template>

<script>
export default {
  name: "VideoPlayback",
  props: ['productType'],
  data() {
    return {
      videoSource: '/path/to/your/video.mp4', // 视频文件路径
    };
  },
  methods: {
    playVideo() {
      // 播放视频
      this.$refs.videoPlayer.play();
    },
    pauseVideo() {
      // 暂停视频
      this.$refs.videoPlayer.pause();
    },
  },
}
</script>

<style scoped>

</style>
