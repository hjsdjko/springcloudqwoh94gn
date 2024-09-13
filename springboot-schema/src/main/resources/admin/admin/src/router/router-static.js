import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import siji from '@/views/modules/siji/list'
    import zaixianxiadan from '@/views/modules/zaixianxiadan/list'
    import sijipingjia from '@/views/modules/sijipingjia/list'
    import xingchengxinxi from '@/views/modules/xingchengxinxi/list'
    import dingdanfenpei from '@/views/modules/dingdanfenpei/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yonghupingjia from '@/views/modules/yonghupingjia/list'
    import chat from '@/views/modules/chat/list'
    import lianxiyonghu from '@/views/modules/lianxiyonghu/list'
    import luxianguihua from '@/views/modules/luxianguihua/list'
    import gonggaoxinxi from '@/views/modules/gonggaoxinxi/list'
    import config from '@/views/modules/config/list'
    import lianxisiji from '@/views/modules/lianxisiji/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/siji',
        name: '司机',
        component: siji
      }
      ,{
	path: '/zaixianxiadan',
        name: '在线下单',
        component: zaixianxiadan
      }
      ,{
	path: '/sijipingjia',
        name: '司机评价',
        component: sijipingjia
      }
      ,{
	path: '/xingchengxinxi',
        name: '行程信息',
        component: xingchengxinxi
      }
      ,{
	path: '/dingdanfenpei',
        name: '订单分配',
        component: dingdanfenpei
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/yonghupingjia',
        name: '用户评价',
        component: yonghupingjia
      }
      ,{
	path: '/chat',
        name: '在线客服',
        component: chat
      }
      ,{
	path: '/lianxiyonghu',
        name: '联系用户',
        component: lianxiyonghu
      }
      ,{
	path: '/luxianguihua',
        name: '路线规划',
        component: luxianguihua
      }
      ,{
	path: '/gonggaoxinxi',
        name: '公告信息',
        component: gonggaoxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/lianxisiji',
        name: '联系司机',
        component: lianxisiji
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
