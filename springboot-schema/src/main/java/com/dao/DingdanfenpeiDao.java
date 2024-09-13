package com.dao;

import com.entity.DingdanfenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanfenpeiVO;
import com.entity.view.DingdanfenpeiView;


/**
 * 订单分配
 * 
 * @author 
 * @email 
 * @date 2024-03-22 22:35:10
 */
public interface DingdanfenpeiDao extends BaseMapper<DingdanfenpeiEntity> {
	
	List<DingdanfenpeiVO> selectListVO(@Param("ew") Wrapper<DingdanfenpeiEntity> wrapper);
	
	DingdanfenpeiVO selectVO(@Param("ew") Wrapper<DingdanfenpeiEntity> wrapper);
	
	List<DingdanfenpeiView> selectListView(@Param("ew") Wrapper<DingdanfenpeiEntity> wrapper);

	List<DingdanfenpeiView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanfenpeiEntity> wrapper);

	
	DingdanfenpeiView selectView(@Param("ew") Wrapper<DingdanfenpeiEntity> wrapper);
	

}
