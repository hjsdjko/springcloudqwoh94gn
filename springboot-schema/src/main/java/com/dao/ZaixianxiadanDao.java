package com.dao;

import com.entity.ZaixianxiadanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianxiadanVO;
import com.entity.view.ZaixianxiadanView;


/**
 * 在线下单
 * 
 * @author 
 * @email 
 * @date 2024-03-22 22:35:10
 */
public interface ZaixianxiadanDao extends BaseMapper<ZaixianxiadanEntity> {
	
	List<ZaixianxiadanVO> selectListVO(@Param("ew") Wrapper<ZaixianxiadanEntity> wrapper);
	
	ZaixianxiadanVO selectVO(@Param("ew") Wrapper<ZaixianxiadanEntity> wrapper);
	
	List<ZaixianxiadanView> selectListView(@Param("ew") Wrapper<ZaixianxiadanEntity> wrapper);

	List<ZaixianxiadanView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianxiadanEntity> wrapper);

	
	ZaixianxiadanView selectView(@Param("ew") Wrapper<ZaixianxiadanEntity> wrapper);
	

}
