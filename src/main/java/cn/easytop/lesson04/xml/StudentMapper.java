package cn.easytop.lesson04.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
	
	/**
	 * ͨ����Ų�ѯѧ��
	 * @param student
	 * @return
	 */
	public List<Student> queryStudent(Student student);
	/**
	 * �����Ա��ѯ����ѧ��
	 * ������ ����sex �͸��������� û�д�ֵ ������Ů��
	 */
	public List<Student> queryBySex(@Param("sex")Integer sex);
	
	/**
	 * ����ѧ����Ϣ
	 * @param student
	 */
	public void updateStudent(Student student);
	
	/**
	 * ͨ������İ༶��ѯ����ѧ��
	 * @param gradeList
	 */
	public List<Student> queryAnyStudent(@Param("gradeList")List<String> gradeList);
}
