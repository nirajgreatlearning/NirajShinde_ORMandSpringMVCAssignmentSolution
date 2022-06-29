package com.greatlearning.crm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.crm.models.Customer;
import com.greatlearning.crm.service.CustomerService;

@Repository
public class CustomerRepository implements CustomerService {
	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public CustomerRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException exc) {
			this.session = this.sessionFactory.openSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		return this.session.createQuery("from Customer").list();
	}

	@Override
	public Customer getCustomerById(long customerId) {
		return this.session.get(Customer.class, customerId);
	}

	@Override
	public void saveCustomer(Customer customer) {
		Transaction tx = this.session.beginTransaction();
		if (customer.getId() > 0) {
			this.session.merge(customer);
		} else {
			this.session.save(customer);
		}
		tx.commit();

	}

	@Override
	public void deleteCustomer(long customerId) {
		Transaction tx = this.session.beginTransaction();
		this.session.delete(this.session.get(Customer.class, customerId));
		tx.commit();

	}

}
