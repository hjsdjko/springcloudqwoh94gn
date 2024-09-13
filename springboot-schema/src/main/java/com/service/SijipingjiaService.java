package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SijipingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SijipingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SijipingjiaView;


/**
 * 司机评价
 *
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
public interface SijipingjiaService extends IService<SijipingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SijipingjiaVO> selectListVO(Wrapper<SijipingjiaEntity> wrapper);
   	
   	SijipingjiaVO selectVO(@Param("ew") Wrapper<SijipingjiaEntity> wrapper);
   	
   	List<SijipingjiaView> selectListView(Wrapper<SijipingjiaEntity> wrapper);
   	
   	SijipingjiaView selectView(@Param("ew") Wrapper<SijipingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SijipingjiaEntity> wrapper);

   	

}

