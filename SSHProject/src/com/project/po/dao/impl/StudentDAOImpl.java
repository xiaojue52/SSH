package com.project.po.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.po.Student;
import com.project.po.dao.StudentDAO;

public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO{

	public void deleteStudent(Student arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(arg0);
	}

	public void saveStudent(Student arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(arg0);
	}

	public void updateStudent(Student arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(arg0);
	}

}
