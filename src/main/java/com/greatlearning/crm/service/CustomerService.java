package com.greatlearning.crm.service;

import java.util.List;

import com.greatlearning.crm.models.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();

	public Customer getCustomerById(long customerId);

	public void saveCustomer(Customer customer);

	public void deleteCustomer(long customerId);
}
