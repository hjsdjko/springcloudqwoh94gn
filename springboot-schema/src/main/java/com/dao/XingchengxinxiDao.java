package com.dao;

import com.entity.XingchengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XingchengxinxiVO;
import com.entity.view.XingchengxinxiView;


/**
 * 行程信息
 * 
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
public interface XingchengxinxiDao extends BaseMapper<XingchengxinxiEntity> {
	
	List<XingchengxinxiVO> selectListVO(@Param("ew") Wrapper<XingchengxinxiEntity> wrapper);
	
	XingchengxinxiVO selectVO(@Param("ew") Wrapper<XingchengxinxiEntity> wrapper);
	
	List<XingchengxinxiView> selectListView(@Param("ew") Wrapper<XingchengxinxiEntity> wrapper);

	List<XingchengxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XingchengxinxiEntity> wrapper);

	
	XingchengxinxiView selectView(@Param("ew") Wrapper<XingchengxinxiEntity> wrapper);
	

}
