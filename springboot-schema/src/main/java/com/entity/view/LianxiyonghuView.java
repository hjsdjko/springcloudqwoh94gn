package com.entity.view;

import com.entity.LianxiyonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 联系用户
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-22 22:35:11
 */
@TableName("lianxiyonghu")
public class LianxiyonghuView  extends LianxiyonghuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LianxiyonghuView(){
	}
 
 	public LianxiyonghuView(LianxiyonghuEntity lianxiyonghuEntity){
 	try {
			BeanUtils.copyProperties(this, lianxiyonghuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
