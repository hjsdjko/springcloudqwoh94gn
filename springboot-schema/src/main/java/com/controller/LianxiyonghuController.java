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

import com.entity.LianxiyonghuEntity;
import com.entity.view.LianxiyonghuView;

import com.service.LianxiyonghuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;


/**
 * 联系用户
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
@RestController
@RequestMapping("/lianxiyonghu")
public class LianxiyonghuController {
    @Autowired
    private LianxiyonghuService lianxiyonghuService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LianxiyonghuEntity lianxiyonghu, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			lianxiyonghu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			lianxiyonghu.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LianxiyonghuEntity> ew = new EntityWrapper<LianxiyonghuEntity>();

		PageUtils page = lianxiyonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lianxiyonghu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LianxiyonghuEntity lianxiyonghu, 
		HttpServletRequest request){
        EntityWrapper<LianxiyonghuEntity> ew = new EntityWrapper<LianxiyonghuEntity>();

		PageUtils page = lianxiyonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lianxiyonghu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LianxiyonghuEntity lianxiyonghu){
       	EntityWrapper<LianxiyonghuEntity> ew = new EntityWrapper<LianxiyonghuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lianxiyonghu, "lianxiyonghu")); 
        return R.ok().put("data", lianxiyonghuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LianxiyonghuEntity lianxiyonghu){
        EntityWrapper< LianxiyonghuEntity> ew = new EntityWrapper< LianxiyonghuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lianxiyonghu, "lianxiyonghu")); 
		LianxiyonghuView lianxiyonghuView =  lianxiyonghuService.selectView(ew);
		return R.ok("查询联系用户成功").put("data", lianxiyonghuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LianxiyonghuEntity lianxiyonghu = lianxiyonghuService.selectById(id);
        return R.ok().put("data", lianxiyonghu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LianxiyonghuEntity lianxiyonghu = lianxiyonghuService.selectById(id);
        return R.ok().put("data", lianxiyonghu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LianxiyonghuEntity lianxiyonghu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lianxiyonghu);
        lianxiyonghuService.insert(lianxiyonghu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LianxiyonghuEntity lianxiyonghu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lianxiyonghu);
        lianxiyonghuService.insert(lianxiyonghu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LianxiyonghuEntity lianxiyonghu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lianxiyonghu);
        lianxiyonghuService.updateById(lianxiyonghu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lianxiyonghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
