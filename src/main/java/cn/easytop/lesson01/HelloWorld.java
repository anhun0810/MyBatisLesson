package cn.easytop.lesson01;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class HelloWorld {
	
	public static SqlSession getSession() throws IOException {
		String resource = "cn/easytop/lesson01/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory se = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = se.openSession();
		return session;
	} 
	public static void main(String[] args) throws IOException {
		SqlSession session=getSession();
//		select(session);
		update(session);
	}
	public static void select(SqlSession session){
		List selectList = session.selectList("selectFood");
		System.out.println(selectList);
	}
	public static void update(SqlSession session){
		session.update("updateFood");
		System.out.println("�޸ĳɹ�");
		session.commit();
	}
	
	Logger logger = Logger.getLogger(HelloWorld.class);
	@Test
	public void testQueryParam() throws IOException{
		SqlSession session = getSession();
//		Map map = new HashMap();
//		map.put("myprice", 100);
//		map.put("myfoodname", "�ཷ����");
		
		Food food = new Food();
		food.setMyfoodname("�ཷ����");
		food.setMyprice("100");
		List list=session.selectList("a.selectFoodByParam", food);
		logger.info(list);
	}
	@Test
	public void savePrice() throws IOException{
		SqlSession session = getSession();
		Map map = new HashMap();
		map.put("foodname", "�ཷƤ��");
		map.put("price",100);
		session.insert("a.saveFood", map);
		session.commit();
	}
}
