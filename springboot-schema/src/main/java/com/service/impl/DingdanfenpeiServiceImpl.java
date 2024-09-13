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


import com.dao.DingdanfenpeiDao;
import com.entity.DingdanfenpeiEntity;
import com.service.DingdanfenpeiService;
import com.entity.vo.DingdanfenpeiVO;
import com.entity.view.DingdanfenpeiView;

@Service("dingdanfenpeiService")
public class DingdanfenpeiServiceImpl extends ServiceImpl<DingdanfenpeiDao, DingdanfenpeiEntity> implements DingdanfenpeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanfenpeiEntity> page = this.selectPage(
                new Query<DingdanfenpeiEntity>(params).getPage(),
                new EntityWrapper<DingdanfenpeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanfenpeiEntity> wrapper) {
		  Page<DingdanfenpeiView> page =new Query<DingdanfenpeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DingdanfenpeiVO> selectListVO(Wrapper<DingdanfenpeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanfenpeiVO selectVO(Wrapper<DingdanfenpeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanfenpeiView> selectListView(Wrapper<DingdanfenpeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanfenpeiView selectView(Wrapper<DingdanfenpeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
