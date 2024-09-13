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

import com.entity.LuxianguihuaEntity;
import com.entity.view.LuxianguihuaView;

import com.service.LuxianguihuaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;


/**
 * 路线规划
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 22:35:10
 */
@RestController
@RequestMapping("/luxianguihua")
public class LuxianguihuaController {
    @Autowired
    private LuxianguihuaService luxianguihuaService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LuxianguihuaEntity luxianguihua, 
		HttpServletRequest request){
        EntityWrapper<LuxianguihuaEntity> ew = new EntityWrapper<LuxianguihuaEntity>();

		PageUtils page = luxianguihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luxianguihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LuxianguihuaEntity luxianguihua, 
		HttpServletRequest request){
        EntityWrapper<LuxianguihuaEntity> ew = new EntityWrapper<LuxianguihuaEntity>();

		PageUtils page = luxianguihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luxianguihua), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LuxianguihuaEntity luxianguihua){
       	EntityWrapper<LuxianguihuaEntity> ew = new EntityWrapper<LuxianguihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( luxianguihua, "luxianguihua")); 
        return R.ok().put("data", luxianguihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LuxianguihuaEntity luxianguihua){
        EntityWrapper< LuxianguihuaEntity> ew = new EntityWrapper< LuxianguihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( luxianguihua, "luxianguihua")); 
		LuxianguihuaView luxianguihuaView =  luxianguihuaService.selectView(ew);
		return R.ok("查询路线规划成功").put("data", luxianguihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LuxianguihuaEntity luxianguihua = luxianguihuaService.selectById(id);
		luxianguihua.setClicknum(luxianguihua.getClicknum()+1);
		luxianguihua.setClicktime(new Date());
		luxianguihuaService.updateById(luxianguihua);
        luxianguihua = luxianguihuaService.selectView(new EntityWrapper<LuxianguihuaEntity>().eq("id", id));
        return R.ok().put("data", luxianguihua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LuxianguihuaEntity luxianguihua = luxianguihuaService.selectById(id);
		luxianguihua.setClicknum(luxianguihua.getClicknum()+1);
		luxianguihua.setClicktime(new Date());
		luxianguihuaService.updateById(luxianguihua);
        luxianguihua = luxianguihuaService.selectView(new EntityWrapper<LuxianguihuaEntity>().eq("id", id));
        return R.ok().put("data", luxianguihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LuxianguihuaEntity luxianguihua, HttpServletRequest request){
        if(luxianguihuaService.selectCount(new EntityWrapper<LuxianguihuaEntity>().eq("luxianbianhao", luxianguihua.getLuxianbianhao()))>0) {
            return R.error("路线编号已存在");
        }
    	//ValidatorUtils.validateEntity(luxianguihua);
        luxianguihuaService.insert(luxianguihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody LuxianguihuaEntity luxianguihua, HttpServletRequest request){
        if(luxianguihuaService.selectCount(new EntityWrapper<LuxianguihuaEntity>().eq("luxianbianhao", luxianguihua.getLuxianbianhao()))>0) {
            return R.error("路线编号已存在");
        }
    	//ValidatorUtils.validateEntity(luxianguihua);
        luxianguihuaService.insert(luxianguihua);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LuxianguihuaEntity luxianguihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(luxianguihua);
        if(luxianguihuaService.selectCount(new EntityWrapper<LuxianguihuaEntity>().ne("id", luxianguihua.getId()).eq("luxianbianhao", luxianguihua.getLuxianbianhao()))>0) {
            return R.error("路线编号已存在");
        }
        luxianguihuaService.updateById(luxianguihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        luxianguihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,LuxianguihuaEntity luxianguihua, HttpServletRequest request,String pre){
        EntityWrapper<LuxianguihuaEntity> ew = new EntityWrapper<LuxianguihuaEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = luxianguihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luxianguihua), params), params));
        return R.ok().put("data", page);
    }









}
