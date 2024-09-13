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


import com.dao.XingchengxinxiDao;
import com.entity.XingchengxinxiEntity;
import com.service.XingchengxinxiService;
import com.entity.vo.XingchengxinxiVO;
import com.entity.view.XingchengxinxiView;

@Service("xingchengxinxiService")
public class XingchengxinxiServiceImpl extends ServiceImpl<XingchengxinxiDao, XingchengxinxiEntity> implements XingchengxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XingchengxinxiEntity> page = this.selectPage(
                new Query<XingchengxinxiEntity>(params).getPage(),
                new EntityWrapper<XingchengxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XingchengxinxiEntity> wrapper) {
		  Page<XingchengxinxiView> page =new Query<XingchengxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XingchengxinxiVO> selectListVO(Wrapper<XingchengxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XingchengxinxiVO selectVO(Wrapper<XingchengxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XingchengxinxiView> selectListView(Wrapper<XingchengxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XingchengxinxiView selectView(Wrapper<XingchengxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
