package cn.easytop.lesson03.sql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easytop.lesson02.Food;

public interface FoodMapper {
	/*
	 * 
	 * */
	public List queryFood(String foodname,String price);
		
}
