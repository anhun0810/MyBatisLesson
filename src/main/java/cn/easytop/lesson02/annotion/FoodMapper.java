package cn.easytop.lesson02.annotion;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import cn.easytop.lesson02.Food;

public interface FoodMapper {
	/*
	 * TypeAliasRegistry 别人类
	 * 
	 * 
	 * @Param("参数名") 可替换 #{param1}
	 * 
	 * 加注解后 可实行 "参数名"=param1
	 * */
	@Select("select * from food where foodname=#{0} and price=#{1}")
	public List<Map> queryFood(String foodname,String price);
	
	
	@Select("select * from food where foodname like '%${foodName}%'")
	public List<Food> queryByFoodName(@Param("foodName") String foodname);
	/**
	 * 
	 * @param foodid
	 */
	
	@Delete("delete from food where foodid=#{0}")
	public void deleteFood(String foodid);
	
	@SelectKey(before=true,keyProperty="foodId",resultType=int.class,statement="select FOOD_SEc.Nextval from dual")
	@Insert("insert into food values(#{foodId},#{foodName},#{price})")
	public void saveFood(Food food);
	
	
	
	
}
