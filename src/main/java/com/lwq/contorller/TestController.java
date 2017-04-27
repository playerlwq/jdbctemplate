package com.lwq.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.JedisPool;

import com.google.common.collect.Maps;
import com.lwq.dao.TestDao;
import com.lwq.entity.TbItem;
/**
 * 
 * All rights Reserved, Designed By lwq
 * @Title:  TestController.java   
 * @Package com.lwq.contorller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 上海易往     
 * @date:   2017年4月26日 下午4:48:45   
 * @version V1.0 
 * @Copyright: 2017 lwq. All rights reserved. 
 *
 */
@Controller
public class TestController {

	
	@Autowired JedisPool jedisPool; // jedis -- redis
	@Autowired TestDao testDao;   //@Autowired dao
	@RequestMapping("test")
	@ResponseBody
	public Map<String, Object> test(String test){
//		 Map<String, Object> map=Maps.newHashMap();
		 Map<String, Object> map=new HashMap<String, Object>();
		System.out.println(jedisPool+"=========jedisPool");
//		TbItem item=new TbItem(111, 1, "new2 - 阿尔卡特 (OT-927) 炭黑 联通3G手机 双卡双待", "清仓！仅北京，武汉仓有货！", 44D, 11D, "barcode", "http://image.taotao.com/jd/4ef8861cf6854de9889f3db9b24dc371.jpg", "2015-03-08 21:33:18", "2015-03-08 21:33:18");
		try {
			String tableName="tb_item";
//		int insertAccount = testDao.insert("tb_item", item);
//		map.put("result", insertAccount);
//		map.put("msg", "success");
//			TbItem select = testDao.select(TbItem.class, "tb_item", "2");
//			List<TbItem> selectList = testDao.selectList("tb_item", TbItem.class);
//			if(selectList!=null){
//				map.put("data", selectList);
//				map.put("msg", "success");
//				map.put("count", selectList.size());
//			}
			map.put("sellpoint", "'%w%'");
//			map.put("id", "2");
			int deleteEntity = testDao.deleteEntity(tableName, map);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("msg", "fail");
			e.printStackTrace();
		}
	  return map;
	}
	
	
}
