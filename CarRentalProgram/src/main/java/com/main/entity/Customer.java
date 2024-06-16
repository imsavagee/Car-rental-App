package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String Name;
	private String Address;
//	@OneToOne(mappedBy = "customer")
//	private Admin admin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
//	public Admin getAdmin() {
//		return admin;
//	}
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	public Customer(int id, String name, String address, Admin admin) {
		super();
		this.id = id;
		Name = name;
		Address = address;
//		this.admin = admin;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", Name=" + Name + ", Address=" + Address +  "]";
	}
	

}
