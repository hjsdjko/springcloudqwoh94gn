package com.dao;

import com.entity.LianxiyonghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LianxiyonghuVO;
import com.entity.view.LianxiyonghuView;


/**
 * 联系用户
 * 
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
public interface LianxiyonghuDao extends BaseMapper<LianxiyonghuEntity> {
	
	List<LianxiyonghuVO> selectListVO(@Param("ew") Wrapper<LianxiyonghuEntity> wrapper);
	
	LianxiyonghuVO selectVO(@Param("ew") Wrapper<LianxiyonghuEntity> wrapper);
	
	List<LianxiyonghuView> selectListView(@Param("ew") Wrapper<LianxiyonghuEntity> wrapper);

	List<LianxiyonghuView> selectListView(Pagination page,@Param("ew") Wrapper<LianxiyonghuEntity> wrapper);

	
	LianxiyonghuView selectView(@Param("ew") Wrapper<LianxiyonghuEntity> wrapper);
	

}
