package com.example.customer.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customers")
public class Customer {
	public Customer() {}
	
	private String name;
	private String email;
	private String phone;


@Id
private String id;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id=id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name=name;
}
public String getEmail() {
	return email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

}