package com.main.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String carBrand;
	
	private String carNumber;
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	private String BookingDate;
	private String routeFrom;
	private String routeTo;
	private String paymentMode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}
	public String getRoute_from() {
		return routeFrom;
	}
	public void setRoute_from(String route_from) {
		this.routeFrom = route_from;
	}
	public String getRoute_to() {
		return routeTo;
	}
	public void setRoute_to(String route_to) {
		this.routeTo = route_to;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
	public Admin(int id, String carBrand, String carNumber, Customer customer, String bookingDate, String route_from,
			String route_to, String paymentMode) {
		super();
		this.id = id;
		this.carBrand = carBrand;
		this.carNumber = carNumber;
		this.customer = customer;
		BookingDate = bookingDate;
		this.routeFrom = route_from;
		this.routeTo = route_to;
		this.paymentMode = paymentMode;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", carBrand=" + carBrand + ", carNumber=" + carNumber + ", customer=" + customer
				+ ", BookingDate=" + BookingDate + ", route_from=" + routeFrom + ", route_to=" + routeTo
				+ ", paymentMode=" + paymentMode + "]";
	}
		
}
