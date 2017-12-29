package cn.easytop.lesson04.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
		String resource = "cn/easytop/lesson04/xml/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory se = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = se.openSession();
		return session;
	} 
	@Test
	public void testInterface() throws IOException{
		SqlSession session = getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student s = new Student();
		s.setSname("张");
		s.setAddress("深圳");
		List<Student> list=fm.queryStudent(s);
		for(Student g:list){
			System.out.println(g.getSname());
		}
	}
	
	@Test
	public void testSex() throws IOException{
		SqlSession session = getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Integer sex=0;
		List<Student> list = fm.queryBySex(sex);
		for(Student s:list) {
			System.out.println(s.getSname());
		}
	}
	@Test
	public void testUpdate() throws IOException{
		SqlSession session = getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setSid("1");
		student.setSname("张三三");
		fm.updateStudent(student);
		session.commit();
	}
	
	@Test
	public void testForeach() throws IOException{
		SqlSession session = getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		List list = new ArrayList();
		list.add("0");
		list.add("1");
		List<Student> li = fm.queryAnyStudent(list);
		for(Student s:li) {
			System.out.println(s.getSname());
		}
		session.commit();
	}
}
