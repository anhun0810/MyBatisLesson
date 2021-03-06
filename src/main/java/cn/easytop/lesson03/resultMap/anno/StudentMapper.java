package cn.easytop.lesson03.resultMap.anno;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface StudentMapper {
	
	@Results({
		@Result(property="grade",column="gid",one=@One(
				select="cn.easytop.lesson03.resultMap.anno.GradeMapper.queryGradeByGid"
		)),
		
	})
	@Select("select * from student where sid=#{0}")
	public Student queryStudent(String sid);
	
	@Select("select * from student where gid=#{0}")
	public List<Student> queryStudentByGid(String gid);
}
