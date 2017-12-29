package cn.easytop.lesson03.resultMap.xml;

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
		String resource = "cn/easytop/lesson03/resultMap/xml/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory se = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = se.openSession();
		return session;
	} 
	@Test
	public void testInterface() throws IOException{
		SqlSession session = getSession();
		GradeMapper fm=session.getMapper(GradeMapper.class);
		List<Grade> list=fm.queryAllGrade();
		for(Grade g:list){
			System.out.println(g.getGid()+"----"+g.getGname1());
		}
	}
//	@Test
//	public void testManytoOne() throws IOException{
//		SqlSession session = getSession();
//		GradeMapper fm=session.getMapper(GradeMapper.class);
//		Student student=fm.queryStudent("1");
//		System.out.println(student.getSname()+"------"+student.getGrade().getGname1());
//	}
	
	/**
	 * mybatis懒加载
	 *   关联的对象是访问去属性时才加载
	 */
	@Test
	public void testOne() throws IOException{
		SqlSession session = getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student student=fm.queryStudent("1");
		System.out.println(student.getSname());
		System.out.println(student.getGrade().getGname1());
//		System.out.println(student.getSname()+"------"+student.getGrade().getGname1());
	}
	
	@Test
	public void testMany() throws IOException{
		SqlSession session = getSession();
		GradeMapper fm=session.getMapper(GradeMapper.class);
		Grade g=fm.queryGrade("2");
		for(Student s:g.getStudentList()) {
			System.out.println(s.getSname());
		}
		System.out.println(g.getStudentList().size());
	}
}
