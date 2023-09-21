<template>
  <div>
    <div>
      <!-- 隐藏的文件选择器 -->
      <el-autocomplete
        class="my-autocomplete"
        v-model="path"
        :fetch-suggestions="querySearch"
        placeholder="请输入内容"
        @select="handleSelect">
        <i
          class="el-icon-edit el-input__icon"
          slot="suffix"
          @click="handleIconClick">
        </i>
        <template slot-scope="{ item }">
          <span class="history-content">{{ item.content }}</span>
          <span class="history-createTime">{{ item.createTime }}</span>
        </template>
      </el-autocomplete>
      <!-- 用于触发文件夹选择的按钮 -->
      <el-button @click="queryLocalHostFile">搜索</el-button>
      <div class="block">
        <el-row>
          <el-col span="12">
            <el-tree
              :data="data"
              show-checkbox
              node-key="id"
              :expand-on-click-node="false">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>{{ data.fileName }}</span>
        <span>{{ data.size }}</span>
        <span>
          <el-button
            type="text"
            size="mini"
            @click="() => append(data)">
            Append
          </el-button>
          <el-button
            type="text"
            size="mini"
            @click="() => remove(node, data)">
            Delete
          </el-button>
          <el-button
            type="text"
            size="mini"
            @click="() => openFile(node, data)">
            打开
          </el-button>
        </span>
      </span>
            </el-tree>
          </el-col>
          <el-col span="12">
            123
          </el-col>
        </el-row>
        <p>使用 scoped slot</p>

      </div>
    </div>
  </div>
</template>

<script>
import {queryLocalHostFile,searchHistory} from "../request/api"
import globalConfig from '../../public/config'; // 引入配置文件
export default {
  name: "File",

  data() {
    return {
      data: {},
      path: "",
      defaultProps: {
        children: 'children',
        label: 'fileName'
      },
      restaurants: [],
      state: '',
    }
  },
  mounted() {
    // this.restaurants = this.loadAll();
  },
  methods: {
    // *******************请求********************
    //文件搜索
    queryLocalHostFile() {
      // debugger
      queryLocalHostFile({
        path: this.path
      }).then(res => {
        this.data = res.data
        //刷新搜索记录
        searchHistory()
      })
    },
    //搜索记录
    searchHistory(){
      // debugger
      searchHistory({}).then(res =>{
        this.restaurants = res.data
        console.log(this.restaurants)
      })
    },
    // ***************************************文件树处理********************************
    append(data) {
      const newChild = {id: id++, label: 'testtest', children: []};
      if (!data.children) {
        this.$set(data, 'children', []);
      }
      data.children.push(newChild);
    },
    remove(node, data) {
      const parent = node.parent;
      const children = parent.data.children || parent.data;
      const index = children.findIndex(d => d.id === data.id);
      children.splice(index, 1);
    },
    //打开文件
    openFile(node, data) {
      const customUrl =globalConfig.apiUrl+data.path;
      window.open(customUrl, '_blank');

    },
    // ***************************************搜索记录处理********************************
    querySearch(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (restaurant) => {
        return (restaurant.content.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },
    handleSelect(item) {
      this.path =item.content
    },
    handleIconClick(ev) {
      this.path = ''
    },
  },
  created() {
    // 在组件被创建时调用接口
    this.queryLocalHostFile();
    this.searchHistory();
  },
}
</script>

<style scoped>
.my-autocomplete{
  width: 400px;
  margin-left: 100px;
}
.history-content{
  font-size: 14px;
}
.history-createTime{
  font-size: 12px;
}
</style>
