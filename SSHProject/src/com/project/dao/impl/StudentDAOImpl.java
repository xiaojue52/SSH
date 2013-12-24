package com.project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.dao.StudentDAO;
import com.project.po.Student;

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

	@Override
	public Student getStudentById(Integer arg0) {
		
		// TODO Auto-generated method stub	
		return this.getHibernateTemplate().get(Student.class, arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentsByHql(String hql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalScore() {
		// TODO Auto-generated method stub
		String hql = "select student.score from Student student";
		Query query=this.getSession().createQuery(hql);
		List<String> list = (List<String>)query.list();
		int total = 0;
		for (int i=0;i<list.size();i++){
			if(list.get(i)!=null)
				total = total + Integer.valueOf(list.get(i));
		}
		return total;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getList(String hql) {
		// TODO Auto-generated method stub
		Query query=this.getSession().createSQLQuery(hql);
		return query.list();
	}

}
