package com.lwq.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lwq.base.BaseDao;
import com.lwq.base.BaseEntity;
import com.lwq.base.impl.BaseDaoImpl;
import com.lwq.dao.TestDao;
import com.lwq.entity.TbItem;
import com.lwq.entity.TbUser;

@Service("TestDaoImpl")
public class TestDaoImpl   implements TestDao   {
	
	@Autowired BaseDao baseDaoImpl;
	
	public int insert(String tableName,TbItem item)  throws Exception{
		
		return baseDaoImpl.addEntity(tableName, item);
		
	}


	@Override
	public TbItem select(Class<? extends BaseEntity> clazz, String tableName,
			String id) throws Exception {
		return (TbItem) baseDaoImpl.selectOneById(tableName, id, clazz);
	}


	@Override
	public List<TbItem> selectList(String tableName,
			Class<? extends BaseEntity> clazz, Object... objects)
			throws Exception {
		// TODO Auto-generated method stub
		return (List<TbItem>) baseDaoImpl.selectList(tableName, clazz, objects);
	}


	@Override
	public int deleteEntity(String tableName, Map<String, Object> map)
			throws Exception {
		return baseDaoImpl.deleteEntity(tableName, map);
	}

}
