package cn.easytop.lesson03.resultMap.anno;

import java.util.ArrayList;
import java.util.List;

public class Grade {
	private int gid;
	private String gname;
	List<Student> studentList = new ArrayList<Student>();
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
