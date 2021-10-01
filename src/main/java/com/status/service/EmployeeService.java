package com.status.service;

import java.util.List;
import com.status.model.Employee;  
  
public interface EmployeeService {

	public boolean saveEmployee(Employee employee);

	public List<Employee> getEmployees();

	public boolean deleteEmployee(Employee employee);

	public List<Employee> getEmployeeByID(Employee employee);

	public boolean updateEmployee(Employee employee);
}  