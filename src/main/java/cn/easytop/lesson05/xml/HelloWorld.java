package cn.easytop.lesson05.xml;

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
	
	public SqlSessionFactory  getSqlSessionFactory() throws IOException{
		String resource = "cn/easytop/lesson05/xml/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		return sessionFactory;
	}
	
	public static SqlSession getSession() throws IOException {
		String resource = "cn/easytop/lesson05/xml/mybatis.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory se = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = se.openSession();
		return session;
	} 
	/**
	 * һ������  ͬһ��session�������ͬһ�����ݵĲ�ѯ �����Ļ���
	 * ��һ�β�ѯʱ  ��������  ��ȡ���ݺ�
	 * ͨ��session���õ�һ��������
	 * �ڶ��β�ѯʱ ͭ��sessionһ�������ж��Ƿ������ͬ����������ֵ �������  ֱ�ӷ�������  �����ѯ���ݿ�
	 * @throws IOException
	 */
	@Test
	public void testInterface() throws IOException{
		SqlSession session = getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student s = fm.queryStudentById("1");
		
		Student s1 = fm.queryStudentById("1");
		System.out.println(s==s1);
	}
	
	/**
	 * ��������ͬһ��sessionFactory�µĲ�ͬsession
	 * @throws IOException
	 */
	@Test
	public void testSession() throws IOException{
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		SqlSession session1 = sessionFactory.openSession();
		
		
//		Student s = session.selectOne("cn.easytop.lesson05.xml.StudentMapper.queryStudentById",1);
//		session.close();
//		
//		Student s1 = session1.selectOne("cn.easytop.lesson05.xml.StudentMapper.queryStudentById",1);
		
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student s = fm.queryStudentById("1");
		session.close();
		StudentMapper fm1=session1.getMapper(StudentMapper.class);
		Student s1 = fm1.queryStudentById("1");
	}
	
	
}
