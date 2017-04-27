package com.lwq.dao;

import java.util.List;
import java.util.Map;

import com.lwq.base.BaseEntity;
import com.lwq.entity.TbItem;
import com.lwq.entity.TbUser;


/**
 * 
 * All rights Reserved, Designed By lwq
 * @Title:  TestDao.java   
 * @Package com.lwq.dao   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 上海易往     
 * @date:   2017年4月26日 下午3:19:35   
 * @version V1.0 
 * @Copyright: 2017 lwq. All rights reserved. 
 *
 */
public interface TestDao {
	
	
	public int insert(String tableName,TbItem item) throws Exception;
	
	public int deleteEntity(String tableName,Map<String, Object> map) throws Exception;
	
	public TbItem select(Class<? extends BaseEntity> claszz, String tableName,String id) throws Exception;
	
	public List<TbItem> selectList(final String tableName,Class<? extends BaseEntity> clazz,Object ...objects) throws Exception;
	
	
}
