package com.admin.entities;

import java.io.Serializable;
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
@Table(name="Category")
public class Category implements Serializable{
	@Id
	@Column(name="CatId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	
	@Column(name="Name")
	private String catName;
	
	@OneToMany(mappedBy = "cat",fetch = FetchType.LAZY)
	private Set<Product> listProduct;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public Set<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(Set<Product> listProduct) {
		this.listProduct = listProduct;
	}
	
	
	


}
