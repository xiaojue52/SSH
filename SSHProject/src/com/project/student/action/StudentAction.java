package com.project.student.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.project.po.Student;
import com.project.po.Teacher;
import com.project.service.StudentService;
import com.project.service.TeacherService;

public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482287939244643007L;
	
	private StudentService studentService;
	private TeacherService teacherService;
	private List<Student> list;
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

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
	
	public String addStudentAction(){
		
		if (student.getTeacher()!=null){
			Integer teacherId = student.getTeacher().getId();
			student.setTeacher(this.teacherService.getTeacherById(teacherId));
		}
		this.studentService.saveStudent(student);
		this.student = null;
		return SUCCESS;
	}
	public String deleteStudentAction(){
		this.studentService.deleteStudent(student);
		this.student = null;
		return SUCCESS;
	}
	public String updateStudentAction(){
		this.studentService.updateStudent(student);
		this.student = null;
		return SUCCESS;
	}
	public void getTotalScoreAction(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put("data", this.studentService.getTotalScore());
		this.flush(dataMap);
	}
	class Test{
		public String sName;
		public String tName;
		public Teacher teacher;
	}
	class Test1{
		public String str1;
		public List<String> list;
	}
	@SuppressWarnings("unchecked")
	public void getCostomizeHqlDataAction(){
		System.out.print("in....");
		Map<String,Object> dataMap = new HashMap<String,Object>();
		String hql = "select student.name,wmsys.wm_concat(student.grade) from Student student, Teacher teacher group by student.name";
		//System.out.print(this.studentService.getList(hql));
		//List list = this.studentService.getList(hql);
		dataMap.put("data", "list");
		//dataMap.put("size", list.size());
		
		this.flush(dataMap);
	}
	private void flush(Map<String,Object> dataMap){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			Gson gson = new Gson();
			String jsonString = gson.toJson(dataMap);
			out.println(jsonString);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
