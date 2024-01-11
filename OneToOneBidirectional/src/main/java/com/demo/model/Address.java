package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address3")
public class Address {
	@Id
	private int addrid;
	private String street;
	private String city;
	private String state;
	@OneToOne(mappedBy = "addr")
	private MyUser u;
	public Address() {
		super();
	}
	public Address(int addrid, String street, String city, String state) {
		super();
		this.addrid = addrid;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	
	public Address(int addrid, String street, String city, MyUser u) {
		super();
		this.addrid = addrid;
		this.street = street;
		this.city = city;
		this.u = u;
	}

	public int getAddrid() {
		return addrid;
	}
	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public MyUser getU() {
		return this.u;
	}
	public void setU(MyUser u) {
		this.u = u;
	}
	
	@Override
	public String toString() {
		return "Address [addrid=" + addrid + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
