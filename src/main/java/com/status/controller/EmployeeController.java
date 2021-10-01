package com.status.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.status.model.Employee;
import com.status.service.EmployeeService;

@RestController
/*
 * @CrossOrigin(origins = "http://localhost:4200")
 */@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@PostMapping("/save-employee")
	public boolean saveEmployee(@RequestBody Employee employee) {
		return employeeservice.saveEmployee(employee);

	}

	@GetMapping("employees-list")
	public List<Employee> allemployees() {
		return employeeservice.getEmployees();

	}

	@DeleteMapping("delete-employee/{employee_id}")
	public boolean deleteEmployee(@PathVariable("employee_id") int employee_id, Employee employee) {
		employee.setEmployee_id(employee_id);
		return employeeservice.deleteEmployee(employee);
	}

	@GetMapping("employee/{employee_id}")
	public List<Employee> allemployeeByID(@PathVariable("employee_id") int employee_id, Employee employee) {
		employee.setEmployee_id(employee_id);
		return employeeservice.getEmployeeByID(employee);

	}

	@PostMapping("update-employee/{employee_id}")
	public boolean updateEmployee(@RequestBody Employee employee, @PathVariable("employee_id") int employee_id) {
		employee.setEmployee_id(employee_id);
		return employeeservice.updateEmployee(employee);
	}
}