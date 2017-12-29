                    package cn.easytop.lesson03.resultMap.anno;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface GradeMapper {
	
	/**
	 * ��ѯ���а༶
	 * @return
	 */
	public List queryAllGrade();
	
	/**
	 * ͨ��id��ѯ���еİ༶
	 */
	
	@Results({
		@Result(property="gname",column="gname"),
		@Result(property="studentList",javaType=ArrayList.class,column="gid",many=@Many(
				select="cn.easytop.lesson03.resultMap.anno.StudentMapper.queryStudentByGid"
		))
	})
	@Select("select * from grade where gid=#{0}")
	public Grade queryGrade(String gid);
	
	@Results(
			@Result(property="gname",column="gname")
	)
	@Select("select * from grade where gid=#{0}")
	public Grade queryGradeByGid(String gid);
	
	
	
}
