package com.greatlearning.crm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long Id;

	@Column(name = "customer_fname", length = 150, nullable = false)
	@NotBlank(message = "First Name is Required!")
	@Size(min = 2, max = 150, message = "First Name must be between 2 to 150 characters!")
	private String firstName;

	@Column(name = "customer_lname", length = 150, nullable = false)
	@NotBlank(message = "Last Name is Required!")
	@Size(min = 2, max = 150, message = "Last Name must be between 2 to 150 characters!")
	private String lastName;

	@Column(name = "customer_email", length = 150, nullable = false)
	@NotBlank(message = "Email is Required!")
	@Email(message = "Please enter valid email address!")
	private String email;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
