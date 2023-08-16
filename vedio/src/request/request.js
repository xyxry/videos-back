import axios from 'axios'

// 配置项
const axiosOption = {

  baseURL: `http://127.0.0.1:8083`,
  timeout: 15000
}
// ${window.serverURL.ADDRESS}
// 创建一个单例
const instance = axios.create(axiosOption);

// 添加请求拦截器
instance.interceptors.request.use(function (config) {
  let token = localStorage.getItem("token")
  if (token) {
    config.headers = {
      "token": token
    }
  }
  return config;
}, function (error) {
  return Promise.reject(error);
});

// 添加响应拦截器
instance.interceptors.response.use(function (response) {
  return response.data;
}, function (error) {
  // console.log('error', error)
  return Promise.reject(error);
});

export default instance;
