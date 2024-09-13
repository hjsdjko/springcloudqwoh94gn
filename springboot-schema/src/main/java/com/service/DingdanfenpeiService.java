package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanfenpeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanfenpeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanfenpeiView;


/**
 * 订单分配
 *
 * @author 
 * @email 
 * @date 2024-03-22 22:35:10
 */
public interface DingdanfenpeiService extends IService<DingdanfenpeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanfenpeiVO> selectListVO(Wrapper<DingdanfenpeiEntity> wrapper);
   	
   	DingdanfenpeiVO selectVO(@Param("ew") Wrapper<DingdanfenpeiEntity> wrapper);
   	
   	List<DingdanfenpeiView> selectListView(Wrapper<DingdanfenpeiEntity> wrapper);
   	
   	DingdanfenpeiView selectView(@Param("ew") Wrapper<DingdanfenpeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanfenpeiEntity> wrapper);

   	

}

