package cn.easytop.lesson03.resultMap.anno;

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
		String resource = "cn/easytop/lesson03/resultMap/anno/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory se = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = se.openSession();
		return session;
	} 
	@Test
	public void testManyToOne() throws IOException{
		SqlSession session = getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student student = fm.queryStudent("2");
		System.out.println(student.getSname()+"----"+student.getGrade().getGname());
	}
	@Test
	public void testOneToMany() throws IOException{
		SqlSession session = getSession();
		GradeMapper fm=session.getMapper(GradeMapper.class);
		Grade g = fm.queryGrade("2");
		for(Student s:g.getStudentList()) {
			System.out.println(s.getSname());
		}
	}
}
