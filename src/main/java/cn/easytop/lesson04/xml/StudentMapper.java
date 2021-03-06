package cn.easytop.lesson04.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
	
	/**
	 * 通过编号查询学生
	 * @param student
	 * @return
	 */
	public List<Student> queryStudent(Student student);
	/**
	 * 根据性别查询所有学生
	 * 参数中 传入sex 就根据条件查 没有传值 查所有女生
	 */
	public List<Student> queryBySex(@Param("sex")Integer sex);
	
	/**
	 * 更新学生信息
	 * @param student
	 */
	public void updateStudent(Student student);
	
	/**
	 * 通过传入的班级查询所有学生
	 * @param gradeList
	 */
	public List<Student> queryAnyStudent(@Param("gradeList")List<String> gradeList);
}
