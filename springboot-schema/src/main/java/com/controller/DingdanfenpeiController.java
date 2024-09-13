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

import com.entity.DingdanfenpeiEntity;
import com.entity.view.DingdanfenpeiView;

import com.service.DingdanfenpeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;


/**
 * 订单分配
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 22:35:10
 */
@RestController
@RequestMapping("/dingdanfenpei")
public class DingdanfenpeiController {
    @Autowired
    private DingdanfenpeiService dingdanfenpeiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanfenpeiEntity dingdanfenpei, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dingdanfenpei.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			dingdanfenpei.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanfenpeiEntity> ew = new EntityWrapper<DingdanfenpeiEntity>();

		PageUtils page = dingdanfenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanfenpei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanfenpeiEntity dingdanfenpei, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dingdanfenpei.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			dingdanfenpei.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanfenpeiEntity> ew = new EntityWrapper<DingdanfenpeiEntity>();

		PageUtils page = dingdanfenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanfenpei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanfenpeiEntity dingdanfenpei){
       	EntityWrapper<DingdanfenpeiEntity> ew = new EntityWrapper<DingdanfenpeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanfenpei, "dingdanfenpei")); 
        return R.ok().put("data", dingdanfenpeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanfenpeiEntity dingdanfenpei){
        EntityWrapper< DingdanfenpeiEntity> ew = new EntityWrapper< DingdanfenpeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanfenpei, "dingdanfenpei")); 
		DingdanfenpeiView dingdanfenpeiView =  dingdanfenpeiService.selectView(ew);
		return R.ok("查询订单分配成功").put("data", dingdanfenpeiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanfenpeiEntity dingdanfenpei = dingdanfenpeiService.selectById(id);
        return R.ok().put("data", dingdanfenpei);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanfenpeiEntity dingdanfenpei = dingdanfenpeiService.selectById(id);
        return R.ok().put("data", dingdanfenpei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanfenpeiEntity dingdanfenpei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdanfenpei);
        dingdanfenpeiService.insert(dingdanfenpei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanfenpeiEntity dingdanfenpei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdanfenpei);
    	dingdanfenpei.setUserid((Long)request.getSession().getAttribute("userId"));
        dingdanfenpeiService.insert(dingdanfenpei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanfenpeiEntity dingdanfenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanfenpei);
        dingdanfenpeiService.updateById(dingdanfenpei);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<DingdanfenpeiEntity> list = new ArrayList<DingdanfenpeiEntity>();
        for(Long id : ids) {
            DingdanfenpeiEntity dingdanfenpei = dingdanfenpeiService.selectById(id);
            dingdanfenpei.setSfsh(sfsh);
            dingdanfenpei.setShhf(shhf);
            list.add(dingdanfenpei);
        }
        dingdanfenpeiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanfenpeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
