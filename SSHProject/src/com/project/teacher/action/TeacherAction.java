package com.project.teacher.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.po.Teacher;
import com.project.service.TeacherService;

public class TeacherAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1524507943234596085L;
	
	
	private TeacherService teacherService;
	private List<Teacher> list;
	private Teacher teacher;

	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Teacher> getList() {
		return list;
	}
	public void setList(List<Teacher> list) {
		this.list = list;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public String listTeachersAction(){
		String hql = "from Teacher teacher";
		list = this.teacherService.getTeachersByHql(hql);
		return SUCCESS;
	}
	
	
	public String addTeacherAction(){
		this.teacherService.saveTeacher(teacher);
		teacher = null;
		return SUCCESS;
	}
	
	public String deleteTeacherAction(){
		this.teacherService.deleteTeacher(teacher);
		teacher = null;
		return SUCCESS;
	}
	public String updateTeacherAction(){
		this.teacherService.updateTeacher(teacher);
		teacher = null;
		return SUCCESS;
	}

}
