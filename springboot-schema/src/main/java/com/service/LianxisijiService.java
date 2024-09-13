package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LianxisijiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LianxisijiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LianxisijiView;


/**
 * 联系司机
 *
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
public interface LianxisijiService extends IService<LianxisijiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LianxisijiVO> selectListVO(Wrapper<LianxisijiEntity> wrapper);
   	
   	LianxisijiVO selectVO(@Param("ew") Wrapper<LianxisijiEntity> wrapper);
   	
   	List<LianxisijiView> selectListView(Wrapper<LianxisijiEntity> wrapper);
   	
   	LianxisijiView selectView(@Param("ew") Wrapper<LianxisijiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LianxisijiEntity> wrapper);

   	

}

