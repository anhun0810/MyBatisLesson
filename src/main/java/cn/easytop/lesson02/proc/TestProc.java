package cn.easytop.lesson02.proc;

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

public class TestProc {
	
	public static SqlSession getSession() throws IOException {
		String resource = "cn/easytop/lesson02/proc/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory se = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = se.openSession();
		return session;
	} 
	@Test
	public void saveProcPrice() throws IOException{
		SqlSession session = getSession();
		Map map = new HashMap();
		map.put("p1", 1111);
		map.put("p2", 1212);
		session.selectOne("call_prg_add",map);
		System.out.println(map.get("result"));
	}
	@Test
	public void saveFunctionPrice() throws IOException{
		SqlSession session = getSession();
		Map map = new HashMap<String, Integer>();
		map.put("p1", 1111);
		map.put("p2", 1212);
		map.put("result", 0);
		session.selectOne("call_fun_add",map);
		System.out.println(map.get("result"));
	}
}
