package com.tavant.springboot1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tavant.springboot1.exceptions.InvalidNameException;
import com.tavant.springboot1.exceptions.InvalidSalaryException;
import com.tavant.springboot1.model.Customer;
import com.tavant.springboot1.model.Customer;
import com.tavant.springboot1.utils.DBUtils;

@Repository("CustomerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private DBUtils dbUtils;

	public boolean addCustomer(Customer customer) {
		Customer Customer = null;
		Connection connection = dbUtils.getConnection();

		try {
			String query = "INSERT into customer" + " (customerNumber , customerName , contactFirstName , contactLastName , phone , addressLine1 , "
					+ "addressLine2 , city , state , postalCode , country , salesRepresentativeEmployeeNumber , creditLimit) values (? , ? , ? , ? , ?, ? , ? , ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, customer.getCustomerNumber());
			statement.setString(2, customer.getCustomerName());
			statement.setString(3, customer.getContactFirstName());
			statement.setString(4, customer.getContactLastName());
			statement.setString(5,customer.getPhone());
			statement.setString(6,customer.getAddressLine1());
			statement.setString(7, customer.getAddressLine2());
			statement.setString(8, customer.getCity());
			statement.setString(9, customer.getState());
			statement.setString(10, customer.getPostalCode());
			statement.setString(11, customer.getCountry());
			statement.setInt(12, customer.getSalesRepresentativeEmployeeNumber());
			statement.setString(13, customer.getCreditLimit());

			int updated = statement.executeUpdate();

			return (updated == 1) ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return false;
	}

	@Override
	public Optional<Customer> updateCustomer(Integer customerNumber, Customer customer)
			throws InvalidSalaryException, InvalidNameException {

		String query = "UPDATE customer SET  city = ?, phone = ?, addressLine1 = ?,addressLine2 = ?, state = ?, country = ?, postalCode = ?, territory = ? WHERE customerNumber = ?";

		Connection connection = dbUtils.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, customer.getCustomerName());
			statement.setString(2, customer.getContactFirstName());
			statement.setString(3, customer.getContactLastName());
			statement.setString(4,customer.getPhone());
			statement.setString(5,customer.getAddressLine1());
			statement.setString(6, customer.getAddressLine2());
			statement.setString(7, customer.getCity());
			statement.setString(8, customer.getState());
			statement.setString(9, customer.getPostalCode());
			statement.setString(10, customer.getCountry());
			statement.setInt(11, customer.getSalesRepresentativeEmployeeNumber());
			statement.setString(12, customer.getCreditLimit());
			statement.setInt(13, customer.getCustomerNumber());


			int updated = statement.executeUpdate();
			if (updated > 0) {
				return getCustomerById(customerNumber);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<List<customer>> getcustomer() {
		List<customer> customer = new ArrayList<>();
		Connection connection = dbUtils.getConnection();
		try {

			Statement statement = connection.createStatement();
			String query = "SELECT * FROM customer ";

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				customer customer = new customer();
				customer.setcustomerNumber(resultSet.getInt("customerNumber"));
				customer.setCity(resultSet.getString("city"));
				customer.setPhone(resultSet.getString("phone"));
				customer.setAddressLine1(resultSet.getString("addressLine1"));
				customer.setAddressLine2(resultSet.getString("addressLine2"));
				customer.setState(resultSet.getString("state"));
				customer.setCountry(resultSet.getString("country"));
				customer.setPostalCode(resultSet.getString("postalCode"));
				customer.setTerritory(resultSet.getString("territory"));

				customer.add(customer);
			}

			return Optional.of(customer);
		} catch (Exception e) {

		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

	@Override
	public Optional<customer> deleteCustomer(Integer customerNumber) {
		customer customer = null;
		Connection connection = dbUtils.getConnection();

		try {
			Optional<customer> optional = getCustomerById(customerNumber);
			if (!optional.isPresent()) {
				return Optional.ofNullable(customer);
			} else {
				customer = optional.get();
			}
			PreparedStatement statement = connection.prepareStatement("DELETE FROM customer where customerNumber = ?");
			statement.setInt(1, customerNumber);
			int updated = statement.executeUpdate();

			if (updated > 0) {
				return Optional.ofNullable(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.ofNullable(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(Integer customerNumber) {

		Customer customer = null;
		Connection connection = dbUtils.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM customer where customerNumber = ?");
			statement.setInt(1, customerNumber);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerNumber(resultSet.getInt("customerNumber"));
				customer.setCity(resultSet.getString("city"));
				customer.setPhone(resultSet.getString("phone"));
				customer.setAddressLine1(resultSet.getString("addressLine1"));
				customer.setAddressLine2(resultSet.getString("addressLine2"));
				customer.setState(resultSet.getString("state"));
				customer.setCountry(resultSet.getString("country"));
				customer.setPostalCode(resultSet.getString("postalCode"));
				customer.setTerritory(resultSet.getString("territory"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.ofNullable(customer);

	}

	@Override
	public boolean isExists(Integer customerNumber) {
		return getCustomerById(customerNumber).isPresent();
	}

}
