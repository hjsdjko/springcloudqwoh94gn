package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.SijiEntity;
import com.entity.view.SijiView;

import com.service.SijiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;


/**
 * 司机
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 22:35:10
 */
@RestController
@RequestMapping("/siji")
public class SijiController {
    @Autowired
    private SijiService sijiService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", username));
        if(u==null || !u.getMima().equals(EncryptUtil.md5(password))) {
			return R.error("账号或密码不正确");
		}
                if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"siji",  "司机" );
		return R.ok().put("token", token);
	}



	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody SijiEntity siji){
    	//ValidatorUtils.validateEntity(siji);
    	SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		siji.setId(uId);
        siji.setMima(EncryptUtil.md5(siji.getMima()));
        sijiService.insert(siji);
        return R.ok();
    }


	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        SijiEntity u = sijiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima(EncryptUtil.md5("123456"));
        sijiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SijiEntity siji, 
		HttpServletRequest request){
        EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();

		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SijiEntity siji, 
		HttpServletRequest request){
        EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();

		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SijiEntity siji){
       	EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( siji, "siji")); 
        return R.ok().put("data", sijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SijiEntity siji){
        EntityWrapper< SijiEntity> ew = new EntityWrapper< SijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( siji, "siji")); 
		SijiView sijiView =  sijiService.selectView(ew);
		return R.ok("查询司机成功").put("data", sijiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SijiEntity siji = sijiService.selectById(id);
        return R.ok().put("data", siji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SijiEntity siji = sijiService.selectById(id);
        return R.ok().put("data", siji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SijiEntity siji, HttpServletRequest request){
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("chepaihao", siji.getChepaihao()))>0) {
            return R.error("车牌号已存在");
        }
    	siji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(siji);
    	SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		siji.setId(new Date().getTime());
        siji.setMima(EncryptUtil.md5(siji.getMima()));
        sijiService.insert(siji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SijiEntity siji, HttpServletRequest request){
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("chepaihao", siji.getChepaihao()))>0) {
            return R.error("车牌号已存在");
        }
    	siji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(siji);
    	SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		siji.setId(new Date().getTime());
        siji.setMima(EncryptUtil.md5(siji.getMima()));
        sijiService.insert(siji);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SijiEntity siji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(siji);
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().ne("id", siji.getId()).eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().ne("id", siji.getId()).eq("chepaihao", siji.getChepaihao()))>0) {
            return R.error("车牌号已存在");
        }
	SijiEntity sijiEntity = sijiService.selectById(siji.getId());
        if(StringUtils.isNotBlank(siji.getMima()) && !siji.getMima().equals(sijiEntity.getMima())) {
            siji.setMima(EncryptUtil.md5(siji.getMima()));
        }
        sijiService.updateById(siji);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<SijiEntity> list = new ArrayList<SijiEntity>();
        for(Long id : ids) {
            SijiEntity siji = sijiService.selectById(id);
            siji.setSfsh(sfsh);
            siji.setShhf(shhf);
            list.add(siji);
        }
        sijiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sijiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
