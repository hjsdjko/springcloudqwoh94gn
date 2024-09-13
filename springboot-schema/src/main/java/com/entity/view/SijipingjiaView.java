package com.entity.view;

import com.entity.SijipingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 司机评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
@TableName("sijipingjia")
public class SijipingjiaView  extends SijipingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SijipingjiaView(){
	}
 
 	public SijipingjiaView(SijipingjiaEntity sijipingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, sijipingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
