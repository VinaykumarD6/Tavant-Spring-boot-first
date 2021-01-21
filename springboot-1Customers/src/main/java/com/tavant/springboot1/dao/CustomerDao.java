package com.tavant.springboot1.dao;

import java.util.List;
import java.util.Optional;

import com.tavant.springboot1.exceptions.InvalidNameException;
import com.tavant.springboot1.exceptions.InvalidSalaryException;
import com.tavant.springboot1.model.Employee;
import com.tavant.springboot1.model.Customer;

public interface CustomerDao {
	public boolean addCustomer(Customer customer);
	public Optional<Customer> updateCustomer(Integer customerNumber , Customer customer)throws InvalidSalaryException , InvalidNameException;
	public Optional<List<Customer>> getCustomers();
	public Optional<Customer> deleteCustomer(Integer customerNumber);
	public Optional<Customer> getCustomerById(Integer customerNumber);
	public boolean isExists(Integer customerNumber);


}
