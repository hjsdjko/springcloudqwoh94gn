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


import com.dao.LianxiyonghuDao;
import com.entity.LianxiyonghuEntity;
import com.service.LianxiyonghuService;
import com.entity.vo.LianxiyonghuVO;
import com.entity.view.LianxiyonghuView;

@Service("lianxiyonghuService")
public class LianxiyonghuServiceImpl extends ServiceImpl<LianxiyonghuDao, LianxiyonghuEntity> implements LianxiyonghuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LianxiyonghuEntity> page = this.selectPage(
                new Query<LianxiyonghuEntity>(params).getPage(),
                new EntityWrapper<LianxiyonghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LianxiyonghuEntity> wrapper) {
		  Page<LianxiyonghuView> page =new Query<LianxiyonghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LianxiyonghuVO> selectListVO(Wrapper<LianxiyonghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LianxiyonghuVO selectVO(Wrapper<LianxiyonghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LianxiyonghuView> selectListView(Wrapper<LianxiyonghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LianxiyonghuView selectView(Wrapper<LianxiyonghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
