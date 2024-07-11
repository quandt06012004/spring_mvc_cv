package com.admin.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProId")
	private Integer proId;
	@Column(name="Name")
	@NotEmpty(message = "tên không được rỗng")
	private String proName;
	@Column(name="Price")
	@NotNull(message = "giá không được rỗng")
	private BigDecimal price;
	
	@Column(name="Quantity")
	@NotNull(message = "sô lượng không được rỗng")
	private Integer quantity;
	
	@Column(name="Credate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "ngày tháng không được rỗng")
	private Date creDate;
	@Column(name ="Imgage")
//	@NotEmpty(message = "ảnh không được để trống")
	private String image;
	@Column(name="describe")
	@NotEmpty(message = "mô tả không được rỗng")
	private String describe;
	
	@ManyToOne
	@JoinColumn(name = "CatId", referencedColumnName = "CatId")
//	@NotEmpty(message= "loại sản phẩm không được để trống")
	private Category cat;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer proId, @NotEmpty(message = "tên không được rỗng") String proName,
			@NotNull(message = "giá không được rỗng") BigDecimal price, Integer quantity,
			@NotNull(message = "ngày tháng không được rỗng") Date creDate, String image,
			@NotEmpty(message = "mô tả không được rỗng") String describe) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.price = price;
		this.quantity = quantity;
		this.creDate = creDate;
		this.image = image;
		this.describe = describe;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	
	

}
