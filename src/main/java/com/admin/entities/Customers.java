package com.admin.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CusId")
	private Integer cusId;
	@Column(name="Name")
	private String cusName;
	@Column(name="Email")
	private String email;
	@Column(name="Phone")
	private String phone;
	@Column(name="Address")
    private String address;
	
	@OneToMany(mappedBy = "cust")
	public Set<Invoices> listInvoices;
	public Customers() {
		// TODO Auto-generated constructor stub
	}
	public Customers(Integer cusId, String cusName, String email, String phone, String address) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public Integer getCusId() {
		return cusId;
	}
	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Invoices> getListInvoices() {
		return listInvoices;
	}
	public void setListInvoices(Set<Invoices> listInvoices) {
		this.listInvoices = listInvoices;
	}

	
}
