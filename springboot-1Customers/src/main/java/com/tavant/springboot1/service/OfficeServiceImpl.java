package com.tavant.springboot1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.springboot1.dao.CustomerDao;
import com.tavant.springboot1.dao.CustomerDao;
import com.tavant.springboot1.exceptions.InvalidNameException;
import com.tavant.springboot1.exceptions.InvalidSalaryException;
import com.tavant.springboot1.model.Customer;
import com.tavant.springboot1.model.Customer;

@Service("OfficeServiceImpl")
public class OfficeServiceImpl implements OfficeService {
	
	@Autowired
	private CustomerDao officeDaoImpl;
	
	@Override
	public boolean addOffice(Customer customer) {
		return this.officeDaoImpl.addOffice(customer);
	}

	@Override
	public Optional<Customer> updateOffice(Integer officeCode, Customer Customer)
			throws InvalidNameException, InvalidSalaryException {
		return this.officeDaoImpl.updateOffice(officeCode, Customer);
	}

	@Override
	public Optional<List<Customer>> getOffices() {

		return this.officeDaoImpl.getOffices();
	}

	@Override
	public Optional<Customer> deleteOffice(Integer officeCode) {
		return this.officeDaoImpl.deleteOffice(officeCode);
	}

	@Override
	public Optional<Customer> getOfficeById(Integer officeCode) {
		return this.officeDaoImpl.getOfficeById(officeCode);
	}

	@Override
	public boolean isExists(Integer officeCode) {
		return this.officeDaoImpl.isExists(officeCode);
	}

}
