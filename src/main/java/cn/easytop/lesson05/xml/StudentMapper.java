package cn.easytop.lesson05.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
	
	/**
	 * ͨ����Ų�ѯѧ��
	 * @param student
	 * @return
	 */
	public Student queryStudentById(String sid);
}
