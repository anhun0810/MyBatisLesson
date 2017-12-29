package cn.easytop.lesson02.xml;

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

import cn.easytop.lesson02.Food;

public class HelloWorld {
	
	public static SqlSession getSession() throws IOException {
		String resource = "cn/easytop/lesson02/xml/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory se = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = se.openSession();
		return session;
	} 
	@Test
	public void savePrice() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		List list=fm.queryByFoodName("³´");
		session.commit();
	}
	@Test
	public void deletePrice() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		fm.deleteFood("206");
		session.commit();
	}
	@Test
	public void saveXmlInterface() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		Food food = new Food();
		food.setFoodName("Çà½·Æ¤µ°");
		food.setPrice("10");
		fm.saveFood(food);
		session.commit();
		System.out.println(food.getFoodId());
	}
}
