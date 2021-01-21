package com.tavant.springboot1.service;

import java.util.List;
import java.util.Optional;

import com.tavant.springboot1.exceptions.InvalidNameException;
import com.tavant.springboot1.exceptions.InvalidSalaryException;
import com.tavant.springboot1.model.Customer;

public interface OfficeService {
	public boolean addOffice(Customer customer);
	public Optional<Customer> updateOffice(Integer officeCode , Customer customer) 
			throws InvalidSalaryException , InvalidNameException;
	public Optional<List<Customer>> getOffices();
	public Optional<Customer> deleteOffice(Integer officeCode);
	public Optional<Customer> getOfficeById(Integer officeCode);
	public boolean isExists(Integer officeCode);
}
