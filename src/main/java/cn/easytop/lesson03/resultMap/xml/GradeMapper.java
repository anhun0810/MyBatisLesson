package cn.easytop.lesson03.resultMap.xml;

import java.util.List;

public interface GradeMapper {
	
	/**
	 * ��ѯ���а༶
	 * @return
	 */
	public List queryAllGrade();
	
	/**
	 * ͨ��id��ѯ���еİ༶
	 */
	public Grade queryGrade(String gid);
}
