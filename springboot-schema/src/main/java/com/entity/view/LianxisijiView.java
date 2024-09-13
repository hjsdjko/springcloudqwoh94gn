package com.entity.view;

import com.entity.LianxisijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 联系司机
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
@TableName("lianxisiji")
public class LianxisijiView  extends LianxisijiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LianxisijiView(){
	}
 
 	public LianxisijiView(LianxisijiEntity lianxisijiEntity){
 	try {
			BeanUtils.copyProperties(this, lianxisijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
