package com.tavant.springboot1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.springboot1.dao.EmployeeDao;
import com.tavant.springboot1.exceptions.InvalidNameException;
import com.tavant.springboot1.exceptions.InvalidSalaryException;
import com.tavant.springboot1.model.Employee;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDaoImpl;
	
	private EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addEmployee(Employee emp) {
		return this.employeeDaoImpl.addEmployee(emp);
	}

	@Override
	public Optional<Employee> updateEmployee(Integer empId, Employee employee)
			throws InvalidNameException, InvalidSalaryException {
		return this.employeeDaoImpl.updateEmployee(empId, employee);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {

		return this.employeeDaoImpl.getEmployees();
	}

	@Override
	public Optional<Employee> deleteEmploye(Integer empid) {
		return this.employeeDaoImpl.deleteEmploye(empid);
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer empid) {
		return this.employeeDaoImpl.getEmployeeById(empid);
	}

	@Override
	public boolean isExists(Integer empId) {
		return this.employeeDaoImpl.isExists(empId);
	}

}
