package com.status.DAO_IMPL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.status.DAO.Employee_DAO;
import com.status.model.Employee;

@Repository
public class Employee_DAO_Implementation implements Employee_DAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveEmployee(Employee Employee) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().save(Employee);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Employee> getEmployees() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public boolean deleteEmployee(Employee Employee) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().delete(Employee);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Employee> getEmployeeByID(Employee Employee) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Employee> query = currentSession.createQuery("from Employee where Employee_id=:Employee_id",
				Employee.class);
		query.setParameter("Employee_id", Employee.getEmployee_id());
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public boolean updateEmployee(Employee Employee) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().update(Employee);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}