package com.tavant.springboot1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer{
	private Integer customerNumber;
	private String customerName;
	private String contactFirstName;
	private String contactLastName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private Integer salesRepresentativeEmployeeNumber;
	private String creditLimit;

}