package cn.easytop.lesson02.annotion;

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
import cn.easytop.lesson02.annotion.FoodMapper;

public class HelloWorld {
	
	public static SqlSession getSession() throws IOException {
		String resource = "cn/easytop/lesson02/annotion/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory se = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = se.openSession();
		return session;
	} 
	@Test
	public void saveAnnoPrice() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		List list=fm.queryFood("«‡Ω∑≥¥»‚", "100");
		session.commit();
	}
	
	@Test
	public void saveAnnoInterPrice() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		List<Food> list=fm.queryByFoodName("≥¥");
		session.commit();
	}
	
	@Test
	public void deleteAnnoPrice() throws IOException{
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
		food.setFoodName("«‡Ω∑∆§µ∞");
		food.setPrice("10");
		fm.saveFood(food);
		session.commit();
		System.out.println(food.getFoodId());
	}
}
