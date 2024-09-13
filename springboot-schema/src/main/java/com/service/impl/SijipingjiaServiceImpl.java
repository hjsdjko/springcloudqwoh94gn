package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SijipingjiaDao;
import com.entity.SijipingjiaEntity;
import com.service.SijipingjiaService;
import com.entity.vo.SijipingjiaVO;
import com.entity.view.SijipingjiaView;

@Service("sijipingjiaService")
public class SijipingjiaServiceImpl extends ServiceImpl<SijipingjiaDao, SijipingjiaEntity> implements SijipingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SijipingjiaEntity> page = this.selectPage(
                new Query<SijipingjiaEntity>(params).getPage(),
                new EntityWrapper<SijipingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SijipingjiaEntity> wrapper) {
		  Page<SijipingjiaView> page =new Query<SijipingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SijipingjiaVO> selectListVO(Wrapper<SijipingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SijipingjiaVO selectVO(Wrapper<SijipingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SijipingjiaView> selectListView(Wrapper<SijipingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SijipingjiaView selectView(Wrapper<SijipingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
