package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XingchengxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XingchengxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XingchengxinxiView;


/**
 * 行程信息
 *
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
public interface XingchengxinxiService extends IService<XingchengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XingchengxinxiVO> selectListVO(Wrapper<XingchengxinxiEntity> wrapper);
   	
   	XingchengxinxiVO selectVO(@Param("ew") Wrapper<XingchengxinxiEntity> wrapper);
   	
   	List<XingchengxinxiView> selectListView(Wrapper<XingchengxinxiEntity> wrapper);
   	
   	XingchengxinxiView selectView(@Param("ew") Wrapper<XingchengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XingchengxinxiEntity> wrapper);

   	

}

