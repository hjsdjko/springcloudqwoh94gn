package com.dao;

import com.entity.SijipingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SijipingjiaVO;
import com.entity.view.SijipingjiaView;


/**
 * 司机评价
 * 
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
public interface SijipingjiaDao extends BaseMapper<SijipingjiaEntity> {
	
	List<SijipingjiaVO> selectListVO(@Param("ew") Wrapper<SijipingjiaEntity> wrapper);
	
	SijipingjiaVO selectVO(@Param("ew") Wrapper<SijipingjiaEntity> wrapper);
	
	List<SijipingjiaView> selectListView(@Param("ew") Wrapper<SijipingjiaEntity> wrapper);

	List<SijipingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<SijipingjiaEntity> wrapper);

	
	SijipingjiaView selectView(@Param("ew") Wrapper<SijipingjiaEntity> wrapper);
	

}
