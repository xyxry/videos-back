// router.js
import Vue from 'vue';
import Router from 'vue-router';
import Home from '../view/home';
import Index from '../components/Index.vue';
import Vedio from '../components/Vedio.vue';
import VideoPlayback from '../components/video/VideoPlayback';
import Photo from '../components/Photo';
import PhotoList from '../components/photo/PhotoList';
import File from '../components/File';

Vue.use(Router);

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
    },
    {
      path: '/index',
      name: 'Index',
      component: Index,
    },
    {
      path: '/vedio',
      name: 'vedio',
      component: Vedio,

    },
    {
      path: '/Vedio/VideoPlayback/:productType',
      name: 'VideoPlayback',
      component: VideoPlayback,
      props: true,
    },
    {
      path: '/photo',
      name: 'photo',
      component: Photo,
      props: true,
    },
    {
      path: '/photo/PhotoList/:productType',
      name: 'PhotoList',
      component: PhotoList,
      props: true,
    },
    {
      path: '/file',
      name: 'File',
      component: File,
      props: true,
    },
  ],
});

// 注册 beforeEach 导航守卫
router.beforeEach((to, from, next) => {
  console.log("-----1111",to)
  const firstIndex = to.path.indexOf('/'); // 获取第一个斜杠的索引
  const secondIndex = to.path.indexOf('/', firstIndex + 1); // 获取第二个斜杠的索引
  if (firstIndex !== -1 && secondIndex !== -1) {
    Vue.prototype.$activeMenu = to.path.substring(firstIndex , secondIndex).toLowerCase();
  } else {
    if (firstIndex !== -1){
      // if (to.path.length>1){
        Vue.prototype.$activeMenu =to.path.toLowerCase()
      // }

    }else {
      // console.log('No match found.');
    }
  }
  // 在此处可以执行你想要的逻辑，例如打印 URL 地址等
  // console.log('URL 地址变化了',Vue.prototype.$activeMenu);
  // console.log('From:', from.path);
  // console.log('To:', to.path);
  // 必须调用 next() 才能继续路由的跳转
  console.log(Vue.prototype.$activeMenu+'aaaaa')
  console.log(from)
  console.log(to)
  next();
});

export default router;
