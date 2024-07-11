package com.admin.entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Invoices")
public class Invoices {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InId")
	private Integer inId;
	@Column(name = "Invoice_date")
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	@Temporal(TemporalType.DATE)
	@NotNull(message  = "ngày tháng không được để rỗng")
	private Date inDate;
	@Column(name="Total_amount")
	@NotNull(message = "tổng số lượng không được để rỗng")
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name = "CuIid", referencedColumnName = "CusId")
	private Customers cust;
	
	public Invoices() {
		// TODO Auto-generated constructor stub
	}

	public Invoices(Integer inId, @NotNull(message = "ngày tháng không được để rỗng") Date inDate,
			@NotNull(message = "tổng số lượng không được để rỗng") BigDecimal total) {
		super();
		this.inId = inId;
		this.inDate = inDate;
		this.total = total;
	}

	public Integer getInId() {
		return inId;
	}

	public void setInId(Integer inId) {
		this.inId = inId;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Customers getCust() {
		return cust;
	}

	public void setCust(Customers cust) {
		this.cust = cust;
	}



	
	
	
}
