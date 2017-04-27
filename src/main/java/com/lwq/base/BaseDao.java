package com.lwq.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * All rights Reserved, Designed By lwq
 * @Title:  BaseDao.java   
 * @Package com.lwq.base   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 上海易往     
 * @date:   2017年4月26日 下午2:58:56   
 * @version V1.0 
 * @Copyright: 2017 lwq. All rights reserved. 
 *
 */
public interface BaseDao {
	
	/**
	 * 
	 * @Title: addEntity   
	 * @Description: TODO()   
	 * @param: @param claszz
	 * @param: @param tableName
	 * @param: @param t
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Integer      
	 * @throws
	 */
	public <T extends BaseEntity>   Integer   addEntity(Class<? extends BaseEntity> claszz  ,final String tableName,T t) throws Exception;
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
	public <T extends BaseEntity>  T   selectOneById(final String tableName,String id,Class<T> clazz);
	
	
	
	/**
	 * 
	 * @Title: selectList   
	 * @Description: TODO (查询所有根据表名称)   
	 * @param: @param tableName
	 * @param: @param clazz
	 * @param: @param objects
	 * @param: @return      
	 * @return: List<? extends BaseEntity>      
	 * @throws
	 */
	public  List<? extends BaseEntity>  selectList(final String tableName,Class<? extends BaseEntity> clazz,Object ...objects );
	
	
	
	
	
	
	
	/**
	 * 
	 * @Title: deleteEntity   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param tableName
	 * @param: @param clazz
	 * @param: @param objects
	 * @param: @return      
	 * @return: List<? extends BaseEntity>      
	 * @throws
	 */
	public  int deleteEntity(final String tableName, Map<String, Object> map );
	
	
	/**
	 * 
	 * @Title: addEntity   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param claszz
	 * @param: @param tableName
	 * @param: @param t
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Integer      
	 * @throws
	 */
	public <T extends BaseEntity>   Integer   addEntity(final String tableName,T t) throws Exception;
	
	
	
	
	
	
}
