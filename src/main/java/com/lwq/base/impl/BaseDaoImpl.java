package com.lwq.base.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.lwq.base.BaseDao;
import com.lwq.base.BaseEntity;
import com.lwq.entity.TbItem;
import com.lwq.utils.JSONUtils;
/**
 * 
 * All rights Reserved, Designed By lwq
 * @Title:  BaseDaoImpl.java   
 * @Package com.lwq.base.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 上海易往     
 * @date:   2017年4月26日 上午11:36:50   
 * @version V1.0 
 * @Copyright: 2017 lwq. All rights reserved. 
 *
 */
@SuppressWarnings("unused")
@Service("baseDaoImpl")
public class BaseDaoImpl implements BaseDao{
	
	
	private org.slf4j.Logger logger=org.slf4j.LoggerFactory.getLogger(BaseDaoImpl.class);
	@Resource JdbcTemplate jdbcTemplate;
	/**
	 * 
	 * @Title: addEntity   
	 * @Description: TODO 插入对象 into db  
	 * @param: @param t
	 * @param: @return      
	 * @return: Integer      
	 * @throws Exception
	 */
	public <T extends BaseEntity> Integer addEntity(Class<? extends BaseEntity> claszz,String tableName, T t)  throws Exception{
			
		Class<? extends BaseEntity> clazz = t.getClass();
		String sql ="INSERT INTO "+tableName+"(";
		 Field[] declaredFields = clazz.getDeclaredFields(); //get all file
		 String fields="";
		 List<String> fieldsList=new ArrayList<String>();
		 for (Field field : declaredFields) {
			 fields +=field.getName()  +" ,";
			 fieldsList.add(field.getName());
		}
		 fields=fields.substring(0, fields.length()-1);  //field 
		 sql+=fields+" ) VALUES ( ";
		 String values="";
		 
		 Method[] declaredMethods = clazz.getDeclaredMethods();
			 //属性名称
		 Object  [] args= new Object[fieldsList.size()]; //属性值
		
		for (int i = 0; i < fieldsList.size(); i++) {
			 String getMethodName="get";
			 getMethodName= getMethodName+fieldsList.get(i).substring(0,1).toUpperCase()+fieldsList.get(i).substring(1);
			 Method method = clazz.getMethod(getMethodName);
			 Object invoke = method.invoke(t);
//			 sql+=invoke+" ,";
			 sql+=" ? "+" ,";
			 args[i]=invoke;
		 }
		 sql=sql.substring(0, sql.length()-1);
		 sql=sql+" ) ";
		 logger.debug(" add  sql : >>> "+sql);
		 int add =0;
		  add = jdbcTemplate.update(sql, args);
		 
		 return add;
		
	}
	

	public <T extends BaseEntity> Integer addEntity(String tableName, T t)
			throws Exception {
		
		
		
		Class<? extends BaseEntity> clazz = t.getClass();
		String sql ="INSERT INTO "+tableName+"(";
		 Field[] declaredFields = clazz.getDeclaredFields(); //get all file
		 String fields="";
		 List<String> fieldsList=new ArrayList<String>();
		 for (Field field : declaredFields) {
			 fields +=field.getName()  +" ,";
			 fieldsList.add(field.getName());
		}
		 fields=fields.substring(0, fields.length()-1);  //field 
		 sql+=fields+" ) VALUES ( ";
		 String values="";
		 
		 Method[] declaredMethods = clazz.getDeclaredMethods();
			 //属性名称
		 Object  [] args= new Object[fieldsList.size()]; //属性值
		
		for (int i = 0; i < fieldsList.size(); i++) {
			 String getMethodName="get";
			 getMethodName= getMethodName+fieldsList.get(i).substring(0,1).toUpperCase()+fieldsList.get(i).substring(1);
			 Method method = clazz.getMethod(getMethodName);
			 Object invoke = method.invoke(t);
//			 sql+=invoke+" ,";
			 sql+=" ? "+" ,";
			 args[i]=invoke;
		 }
		 sql=sql.substring(0, sql.length()-1);
		 sql=sql+" ) ";
		 logger.debug(" add  sql : >>> "+sql);
		 
		 
		 int add=0;
		  add = jdbcTemplate.update(sql, args);
		 
		 return add;
	}


	/**
	 * 
	 * @Title: selectOne   
	 * @Description: TODO( 查询 单个 实体)   
	 * @param: @param claszz
	 * @param: @param tableName
	 * @param: @param t
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	public <T extends BaseEntity>  T   selectOneById(final String tableName,String id,Class<T> clazz){
		String sql="SELECT  * FROM  "+tableName +" WHERE ID= 2";
		logger.debug(" selecet  : >>>  "+sql);
		List<Map<String, Object>> reslut= jdbcTemplate.queryForList(sql);
		return com.lwq.utils.JSONUtils.toBean(reslut.get(0), clazz);
	}



	/**
	 * 
	 * @Title: selectList 
	 * @Description: TODO( 查询 单个 实体)   
	 * @param: @param claszz
	 * @param: @param tableName
	 * @param: @param t
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<? extends BaseEntity> selectList(String tableName,
			Class<? extends BaseEntity> clazz, Object... objects) {
		String sql="SELECT  * FROM  "+tableName;
		List<Map<String, Object>> reslut= jdbcTemplate.queryForList(sql);
		return JSONUtils.toList(reslut, clazz);
	}

	

	/**
	 * 
	 * @Title: deleteEntity 
	 * @Description: TODO( 删除)   
	 * @param: @param claszz
	 * @param: @param tableName
	 * @param: @param t
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	@Override
	public int deleteEntity(String tableName, Map<String, Object> map) {
		//DELETE FROM 表名称 WHERE 列名称 = 值
		if(map!=null){
			String sql ="DELETE FROM "+tableName +" WHERE ";
			//所有的key 对应字段值
			Set<Entry<String, Object>> entrySet = map.entrySet();
			Object [] args =new Object [map.size()];
			Iterator<Entry<String, Object>> iterator = entrySet.iterator();
			int i=0;
			while(iterator.hasNext()){
				Entry<String, Object> next = iterator.next();
				if(next.getValue().toString().contains("%")){
					
					sql+=next.getKey() +" LIKE  "+next.getValue()+" AND  ";
				}else{
					sql+=next.getKey() +"= "+next.getValue()+" AND  ";
					
				}
				
//				sql+=next.getKey() +"= "+" ? "+" AND  ";
				args[i]=next.getValue();
						i++;
			}
			sql=sql.substring(0,sql.length()-5);
			
//			jdbcTemplate.execute(sql);
			int update = jdbcTemplate.update(sql);
			
			return update;
		}else{
			return -1;
		}
		
		
		
	}

	
	
	
	
	
	
}
