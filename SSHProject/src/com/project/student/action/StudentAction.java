package com.project.student.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.po.Student;
import com.project.service.StudentService;

public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482287939244643007L;
	
	private StudentService studentService;
	private List<Student> list;
	
	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String listStudentsAction(){
		String hql = "from Student student";
		list = this.studentService.getStudentsByHql(hql);
		return SUCCESS;
	}
}
