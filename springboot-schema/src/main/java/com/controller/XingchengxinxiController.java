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

import com.entity.XingchengxinxiEntity;
import com.entity.view.XingchengxinxiView;

import com.service.XingchengxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;


/**
 * 行程信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
@RestController
@RequestMapping("/xingchengxinxi")
public class XingchengxinxiController {
    @Autowired
    private XingchengxinxiService xingchengxinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XingchengxinxiEntity xingchengxinxi, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xingchengxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			xingchengxinxi.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XingchengxinxiEntity> ew = new EntityWrapper<XingchengxinxiEntity>();

		PageUtils page = xingchengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xingchengxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XingchengxinxiEntity xingchengxinxi, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xingchengxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			xingchengxinxi.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XingchengxinxiEntity> ew = new EntityWrapper<XingchengxinxiEntity>();

		PageUtils page = xingchengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xingchengxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XingchengxinxiEntity xingchengxinxi){
       	EntityWrapper<XingchengxinxiEntity> ew = new EntityWrapper<XingchengxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xingchengxinxi, "xingchengxinxi")); 
        return R.ok().put("data", xingchengxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XingchengxinxiEntity xingchengxinxi){
        EntityWrapper< XingchengxinxiEntity> ew = new EntityWrapper< XingchengxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xingchengxinxi, "xingchengxinxi")); 
		XingchengxinxiView xingchengxinxiView =  xingchengxinxiService.selectView(ew);
		return R.ok("查询行程信息成功").put("data", xingchengxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XingchengxinxiEntity xingchengxinxi = xingchengxinxiService.selectById(id);
        return R.ok().put("data", xingchengxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XingchengxinxiEntity xingchengxinxi = xingchengxinxiService.selectById(id);
        return R.ok().put("data", xingchengxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XingchengxinxiEntity xingchengxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xingchengxinxi);
        xingchengxinxiService.insert(xingchengxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XingchengxinxiEntity xingchengxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xingchengxinxi);
    	xingchengxinxi.setUserid((Long)request.getSession().getAttribute("userId"));
        xingchengxinxiService.insert(xingchengxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XingchengxinxiEntity xingchengxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xingchengxinxi);
        xingchengxinxiService.updateById(xingchengxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XingchengxinxiEntity> list = new ArrayList<XingchengxinxiEntity>();
        for(Long id : ids) {
            XingchengxinxiEntity xingchengxinxi = xingchengxinxiService.selectById(id);
            xingchengxinxi.setSfsh(sfsh);
            xingchengxinxi.setShhf(shhf);
            list.add(xingchengxinxi);
        }
        xingchengxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xingchengxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
