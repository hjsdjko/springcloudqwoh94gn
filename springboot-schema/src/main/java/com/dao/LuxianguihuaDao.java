package com.dao;

import com.entity.LuxianguihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LuxianguihuaVO;
import com.entity.view.LuxianguihuaView;


/**
 * 路线规划
 * 
 * @author 
 * @email 
 * @date 2024-03-22 22:35:10
 */
public interface LuxianguihuaDao extends BaseMapper<LuxianguihuaEntity> {
	
	List<LuxianguihuaVO> selectListVO(@Param("ew") Wrapper<LuxianguihuaEntity> wrapper);
	
	LuxianguihuaVO selectVO(@Param("ew") Wrapper<LuxianguihuaEntity> wrapper);
	
	List<LuxianguihuaView> selectListView(@Param("ew") Wrapper<LuxianguihuaEntity> wrapper);

	List<LuxianguihuaView> selectListView(Pagination page,@Param("ew") Wrapper<LuxianguihuaEntity> wrapper);

	
	LuxianguihuaView selectView(@Param("ew") Wrapper<LuxianguihuaEntity> wrapper);
	

}
