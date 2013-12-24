package com.project.constant;

import java.util.List;

import com.project.po.Teacher;
import com.project.service.TeacherService;

public class PearDataForJsp {
	private TeacherService teacherService;

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public List<Teacher> getTeachers(){
		String hql = "from Teacher teacher";
		return this.teacherService.getTeachersByHql(hql);
	}

}
