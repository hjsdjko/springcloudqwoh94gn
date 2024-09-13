package com.dao;

import com.entity.LianxisijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LianxisijiVO;
import com.entity.view.LianxisijiView;


/**
 * 联系司机
 * 
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
public interface LianxisijiDao extends BaseMapper<LianxisijiEntity> {
	
	List<LianxisijiVO> selectListVO(@Param("ew") Wrapper<LianxisijiEntity> wrapper);
	
	LianxisijiVO selectVO(@Param("ew") Wrapper<LianxisijiEntity> wrapper);
	
	List<LianxisijiView> selectListView(@Param("ew") Wrapper<LianxisijiEntity> wrapper);

	List<LianxisijiView> selectListView(Pagination page,@Param("ew") Wrapper<LianxisijiEntity> wrapper);

	
	LianxisijiView selectView(@Param("ew") Wrapper<LianxisijiEntity> wrapper);
	

}
