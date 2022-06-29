package com.greatlearning.crm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crm.dao.CustomerRepository;
import com.greatlearning.crm.models.Customer;

@Controller
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping(value = { "/", "/customer" }, method = RequestMethod.GET)
	public String customerList(Model model) {
		model.addAttribute("customers", customerRepository.getAllCustomers());
		return "customerList";
	}

	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		model.addAttribute("customerInfo", new Customer());
		return "customerAdd";
	}

	@RequestMapping(value = "/showFormForUpdate", method = { RequestMethod.PUT, RequestMethod.GET })
	public String viewCustomer(@RequestParam long customerId, Model model) {
		Customer customer = customerRepository.getCustomerById(customerId);
		model.addAttribute("customerInfo", customer);
		return "customerView";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savecustomer(@Valid @ModelAttribute("customerInfo") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			if (customer.getId() > 0) {
				return "customerView";
			} else {
				return "customerAdd";
			}
		} else {
			customerRepository.saveCustomer(customer);
			return "redirect:/customer";
		}
	}

	@RequestMapping(value = "/deleteCustomer", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteStudent(@RequestParam long customerId) {
		System.out.println(customerId);
		customerRepository.deleteCustomer(customerId);
		return "redirect:/customer";
	}
}
