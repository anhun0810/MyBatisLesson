package cn.easytop.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easytop.lesson02.Food;

public interface FoodMapper {
	/*
	 * 
	 * */
	public List queryFood(String foodname,String price);
	
	public List queryByFoodName(@Param("foodname")String foodname);
	
	/**
	 * 
	 * @param foodid
	 */
	public void deleteFood(String foodid);
	/**
	 * 
	 * @param food
	 */
	public void saveFood(Food food);
	
	
	
	
}
