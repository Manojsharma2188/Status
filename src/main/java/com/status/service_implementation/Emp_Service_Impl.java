package com.status.service_implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.status.DAO.Employee_DAO;
import com.status.model.Employee;
import com.status.service.EmployeeService;

@Service
@Transactional
public class Emp_Service_Impl implements EmployeeService {

	@Autowired
	private Employee_DAO employeedao;

	@Override
	public boolean saveEmployee(Employee employee) {
		return employeedao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeedao.getEmployees();
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return employeedao.deleteEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeeByID(Employee employee) {
		return employeedao.getEmployeeByID(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeedao.updateEmployee(employee);
	}

}