<template>
  <div class="content-index">
    <el-row>
      <el-col :span="24">
        <div class="grid-content bg-purple-dark common-text-yahei">热门视频</div>
      </el-col>
      <el-col  :span="4.5" v-for="(o, index) in 10" :key="o" style="margin-left: 40px;margin-top: 20px;  " >
        <el-card shadow="hover" class="vedio-card " :body-style="{ padding: '5px' }">
          <el-image
            class="image"
            @click="goToVedioPage"
            src="http://localhost:8083/img.png"
            :fit="fir"></el-image>
          <div style="padding: 14px;" >
            <span>好吃的汉堡2</span>
            <div class="bottom clearfix">
              <div class="time">{{ currentDate }}</div>
              <div class="father-tag" style="margin-top: 5px">
                <el-tag style="margin-top: 5px" size="mini">标签一</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
              </div>
<!--              <el-button type="text" class="button">操作按钮</el-button>-->
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <div style="margin-top: 10px" class="grid-content bg-purple-dark common-text-yahei">热门图片</div>
      </el-col>
      <el-col :span="4.5" v-for="(o, index) in 10" :key="o" style="margin-left: 40px;margin-top: 20px">
        <el-card shadow="hover" class="vedio-card " :body-style="{ padding: '5px' }">
          <el-image
            class="image"
            @click="goToPhotoPage"
            src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
            :fit="fir"></el-image>
          <div style="padding: 14px;">
            <span>好吃的汉堡</span>
            <div class="bottom clearfix">
              <div class="time">{{ currentDate }}</div>
              <div class="father-tag" style="margin-top: 5px">
                <el-tag style="margin-top: 5px" size="mini">标签一</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
                <el-tag size="mini" type="success">标签二</el-tag>
              </div>
              <!--              <el-button type="text" class="button">操作按钮</el-button>-->
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<script>
export default {
  name: "index",
  data(){
    return{
      currentDate: new Date(),
      fir:"cover"
    }
  },
  methods: {
    goToVedioPage() {
      console.log("Button clicked!");
      this.$router.push({ name: 'vedio' }).then(() => {
        // After navigating to the Products page, go to the specific product detail page
        this.$router.push({ name: 'VideoPlayback', params: { productType: 'list' } });
      });
    },
    goToPhotoPage() {
      console.log("Button clicked!");
      this.$router.push({ name: 'photo' }).then(() => {
        // After navigating to the Products page, go to the specific product detail page
        this.$router.push({ name: 'PhotoList', params: { productType: 'list' } });
      });
    },
  },
}
</script>

<style scoped>
.content-index{
  padding: 20px;
  background-color: antiquewhite;
  height: 100%;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  cursor: pointer;
  width: 100%;
  display: block;

}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
.vedio-card{
  width: 215px;
  height: 340px;

}
</style>
