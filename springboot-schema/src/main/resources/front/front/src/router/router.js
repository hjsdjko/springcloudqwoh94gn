import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import sijiList from '../pages/siji/list'
import sijiDetail from '../pages/siji/detail'
import sijiAdd from '../pages/siji/add'
import luxianguihuaList from '../pages/luxianguihua/list'
import luxianguihuaDetail from '../pages/luxianguihua/detail'
import luxianguihuaAdd from '../pages/luxianguihua/add'
import zaixianxiadanList from '../pages/zaixianxiadan/list'
import zaixianxiadanDetail from '../pages/zaixianxiadan/detail'
import zaixianxiadanAdd from '../pages/zaixianxiadan/add'
import dingdanfenpeiList from '../pages/dingdanfenpei/list'
import dingdanfenpeiDetail from '../pages/dingdanfenpei/detail'
import dingdanfenpeiAdd from '../pages/dingdanfenpei/add'
import lianxisijiList from '../pages/lianxisiji/list'
import lianxisijiDetail from '../pages/lianxisiji/detail'
import lianxisijiAdd from '../pages/lianxisiji/add'
import lianxiyonghuList from '../pages/lianxiyonghu/list'
import lianxiyonghuDetail from '../pages/lianxiyonghu/detail'
import lianxiyonghuAdd from '../pages/lianxiyonghu/add'
import xingchengxinxiList from '../pages/xingchengxinxi/list'
import xingchengxinxiDetail from '../pages/xingchengxinxi/detail'
import xingchengxinxiAdd from '../pages/xingchengxinxi/add'
import yonghupingjiaList from '../pages/yonghupingjia/list'
import yonghupingjiaDetail from '../pages/yonghupingjia/detail'
import yonghupingjiaAdd from '../pages/yonghupingjia/add'
import sijipingjiaList from '../pages/sijipingjia/list'
import sijipingjiaDetail from '../pages/sijipingjia/detail'
import sijipingjiaAdd from '../pages/sijipingjia/add'
import gonggaoxinxiList from '../pages/gonggaoxinxi/list'
import gonggaoxinxiDetail from '../pages/gonggaoxinxi/detail'
import gonggaoxinxiAdd from '../pages/gonggaoxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'siji',
					component: sijiList
				},
				{
					path: 'sijiDetail',
					component: sijiDetail
				},
				{
					path: 'sijiAdd',
					component: sijiAdd
				},
				{
					path: 'luxianguihua',
					component: luxianguihuaList
				},
				{
					path: 'luxianguihuaDetail',
					component: luxianguihuaDetail
				},
				{
					path: 'luxianguihuaAdd',
					component: luxianguihuaAdd
				},
				{
					path: 'zaixianxiadan',
					component: zaixianxiadanList
				},
				{
					path: 'zaixianxiadanDetail',
					component: zaixianxiadanDetail
				},
				{
					path: 'zaixianxiadanAdd',
					component: zaixianxiadanAdd
				},
				{
					path: 'dingdanfenpei',
					component: dingdanfenpeiList
				},
				{
					path: 'dingdanfenpeiDetail',
					component: dingdanfenpeiDetail
				},
				{
					path: 'dingdanfenpeiAdd',
					component: dingdanfenpeiAdd
				},
				{
					path: 'lianxisiji',
					component: lianxisijiList
				},
				{
					path: 'lianxisijiDetail',
					component: lianxisijiDetail
				},
				{
					path: 'lianxisijiAdd',
					component: lianxisijiAdd
				},
				{
					path: 'lianxiyonghu',
					component: lianxiyonghuList
				},
				{
					path: 'lianxiyonghuDetail',
					component: lianxiyonghuDetail
				},
				{
					path: 'lianxiyonghuAdd',
					component: lianxiyonghuAdd
				},
				{
					path: 'xingchengxinxi',
					component: xingchengxinxiList
				},
				{
					path: 'xingchengxinxiDetail',
					component: xingchengxinxiDetail
				},
				{
					path: 'xingchengxinxiAdd',
					component: xingchengxinxiAdd
				},
				{
					path: 'yonghupingjia',
					component: yonghupingjiaList
				},
				{
					path: 'yonghupingjiaDetail',
					component: yonghupingjiaDetail
				},
				{
					path: 'yonghupingjiaAdd',
					component: yonghupingjiaAdd
				},
				{
					path: 'sijipingjia',
					component: sijipingjiaList
				},
				{
					path: 'sijipingjiaDetail',
					component: sijipingjiaDetail
				},
				{
					path: 'sijipingjiaAdd',
					component: sijipingjiaAdd
				},
				{
					path: 'gonggaoxinxi',
					component: gonggaoxinxiList
				},
				{
					path: 'gonggaoxinxiDetail',
					component: gonggaoxinxiDetail
				},
				{
					path: 'gonggaoxinxiAdd',
					component: gonggaoxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
