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


import com.dao.LianxisijiDao;
import com.entity.LianxisijiEntity;
import com.service.LianxisijiService;
import com.entity.vo.LianxisijiVO;
import com.entity.view.LianxisijiView;

@Service("lianxisijiService")
public class LianxisijiServiceImpl extends ServiceImpl<LianxisijiDao, LianxisijiEntity> implements LianxisijiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LianxisijiEntity> page = this.selectPage(
                new Query<LianxisijiEntity>(params).getPage(),
                new EntityWrapper<LianxisijiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LianxisijiEntity> wrapper) {
		  Page<LianxisijiView> page =new Query<LianxisijiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LianxisijiVO> selectListVO(Wrapper<LianxisijiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LianxisijiVO selectVO(Wrapper<LianxisijiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LianxisijiView> selectListView(Wrapper<LianxisijiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LianxisijiView selectView(Wrapper<LianxisijiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
