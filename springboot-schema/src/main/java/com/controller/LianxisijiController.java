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

import com.entity.LianxisijiEntity;
import com.entity.view.LianxisijiView;

import com.service.LianxisijiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;


/**
 * 联系司机
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
@RestController
@RequestMapping("/lianxisiji")
public class LianxisijiController {
    @Autowired
    private LianxisijiService lianxisijiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LianxisijiEntity lianxisiji, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			lianxisiji.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			lianxisiji.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LianxisijiEntity> ew = new EntityWrapper<LianxisijiEntity>();

		PageUtils page = lianxisijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lianxisiji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LianxisijiEntity lianxisiji, 
		HttpServletRequest request){
        EntityWrapper<LianxisijiEntity> ew = new EntityWrapper<LianxisijiEntity>();

		PageUtils page = lianxisijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lianxisiji), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LianxisijiEntity lianxisiji){
       	EntityWrapper<LianxisijiEntity> ew = new EntityWrapper<LianxisijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lianxisiji, "lianxisiji")); 
        return R.ok().put("data", lianxisijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LianxisijiEntity lianxisiji){
        EntityWrapper< LianxisijiEntity> ew = new EntityWrapper< LianxisijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lianxisiji, "lianxisiji")); 
		LianxisijiView lianxisijiView =  lianxisijiService.selectView(ew);
		return R.ok("查询联系司机成功").put("data", lianxisijiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LianxisijiEntity lianxisiji = lianxisijiService.selectById(id);
        return R.ok().put("data", lianxisiji);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LianxisijiEntity lianxisiji = lianxisijiService.selectById(id);
        return R.ok().put("data", lianxisiji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LianxisijiEntity lianxisiji, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lianxisiji);
        lianxisijiService.insert(lianxisiji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LianxisijiEntity lianxisiji, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lianxisiji);
        lianxisijiService.insert(lianxisiji);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LianxisijiEntity lianxisiji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lianxisiji);
        lianxisijiService.updateById(lianxisiji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lianxisijiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
