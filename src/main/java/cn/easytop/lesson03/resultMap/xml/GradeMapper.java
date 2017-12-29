package cn.easytop.lesson03.resultMap.xml;

import java.util.List;

public interface GradeMapper {
	
	/**
	 * 查询所有班级
	 * @return
	 */
	public List queryAllGrade();
	
	/**
	 * 通过id查询所有的班级
	 */
	public Grade queryGrade(String gid);
}
