package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LianxiyonghuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LianxiyonghuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LianxiyonghuView;


/**
 * 联系用户
 *
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
public interface LianxiyonghuService extends IService<LianxiyonghuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LianxiyonghuVO> selectListVO(Wrapper<LianxiyonghuEntity> wrapper);
   	
   	LianxiyonghuVO selectVO(@Param("ew") Wrapper<LianxiyonghuEntity> wrapper);
   	
   	List<LianxiyonghuView> selectListView(Wrapper<LianxiyonghuEntity> wrapper);
   	
   	LianxiyonghuView selectView(@Param("ew") Wrapper<LianxiyonghuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LianxiyonghuEntity> wrapper);

   	

}

