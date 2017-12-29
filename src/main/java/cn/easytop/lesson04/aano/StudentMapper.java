package cn.easytop.lesson04.aano;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;
import org.junit.experimental.theories.FromDataPoints;


public interface StudentMapper {
	
	static class StudentProvider{
		/**
		 * %{}��ע�������ʧЧ
		 * ���������  ȡֵ ����.������
		 * �ṩsql�����Ĳ�����map��ֵ��
		 * �ṩsql��䷽��
		 * @param map
		 * @return
		 */
		public String queryStudentSql(Map map){
			Student student = (Student)map.get("stu");
			String sql="select * from student where 1= 1";
			if(student.getSname()!=null&&!"".equals(student.getSname())) {
				student.setSname("%"+student.getSname()+"%");
				sql+=" and sname like #{stu.sname} ";
			}
			if(student.getAddress()!=null&&!"".equals(student.getAddress())) {
				student.setAddress("%"+student.getAddress()+"%");
				sql+=" and address like #{stu.address} ";
			}
			return sql;
		}
		public String queryStudentSql1(Map map){
			Student student = (Student)map.get("stu");
			SQL sql = new SQL();
			sql.SELECT("*").FROM("student");
			if(student.getSname()!=null&&!"".equals(student.getSname())) {
				student.setSname("%"+student.getSname()+"%");
				sql.WHERE(" sname like #{stu.sname} ");
			}
			if(student.getAddress()!=null&&!"".equals(student.getAddress())) {
				student.setAddress("%"+student.getAddress()+"%");
				sql.AND();
				sql.WHERE(" address like #{stu.address} ");
			}
			return sql.toString();
		}
		/**
		 * <update id="updateStudent">
  			update student
		  	<set>
			  	<if test="sname!=null">
			  		sname=#{sname}
			  	</if>
			  	<if test="age!=null">
			  		age=#{age}
			  	</if>
			  	<if test="sex!=null">
			  		sex=#{age}
			  	</if>
			</set>
		  	where sid=#{sid}
		  </update>
		 * @param student
		 */
		public void updateStudentSql(Student student){
			SQL sql = new SQL();
			sql.UPDATE("student");
			if(student.getSname()!=null&&!"".equals(student.getSname())){
				student.setSname("%"+student.getSname()+"%");
				
			}
		}
		public String queryAnyStudentSql(Map map){
			Student student = (Student)map.get("stu");
			SQL sql = new SQL();
			sql.SELECT("*").FROM("student");
			
			return sql.toString();
		}
	}
	/**
	 * ͨ����Ų�ѯѧ��
	 * @param student
	 * @return
	 */
	@SelectProvider(type=StudentProvider.class,method="queryStudentSql1")
	public List<Student> queryStudent(@Param("stu")Student student);
	/**
	 * �����Ա��ѯ����ѧ��
	 * ������ ����sex �͸��������� û�д�ֵ ������Ů��
	 */
	
	@Select("<script>select * from student where 1=1 "+
			"<choose>"+
    	"<when test=\"sex!=null\">"+
    	 "	and sex=#{sex}"+
    	"</when>"+
    	"<otherwise>"+
    	"	and sex=1"+
    	"</otherwise>"+
    "</choose></script>")
	public List<Student> queryBySex(@Param("sex")Integer sex);
	
	/**
	 * ����ѧ����Ϣ
	 * @param student
	 */
	
	@UpdateProvider(type=StudentProvider.class,method="updateStudentSql")
	public void updateStudent(Student student);
	
	/**
	 * ͨ������İ༶��ѯ����ѧ��
	 * @param gradeList
	 */
	@SelectProvider(type=StudentProvider.class,method="queryStudentSql1")
	public List<Student> queryAnyStudent(@Param("gradeList")List<String> gradeList);
}
