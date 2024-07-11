package com.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Users")
public class Users {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UseId")
	private Integer id;
	@Column(name = "FullName")
	@Length(min = 2, max = 20, message = "tên tối thiểu 2 ký tự tối đa 20 ký tự")
	@NotEmpty(message  = "tên không được để trống")
	private String fullName;
	@Column(name = "Email")
	@NotEmpty(message  = "email không được để trống")
	@Email(message = "email phải đúng định dạng")
	private String email;
	@Column(name = "Gender")
	private Boolean gender;
	@Column(name = "Phone")
	@Pattern(regexp = "^(0)\\d{8,10}$", message = "điện thoại phải đúng định dạng ")
	@NotEmpty(message  = "số điện thoại không được để trống")
	private String phone;
	@Column(name = "Avatar")
	private String Avatar;
	@Column(name = "UserPassWord")
	@NotEmpty(message  = "mật khẩu không được để trống")
	private String passWord;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	




	public Users(Integer id, String fullName, String email, Boolean gender, String phone, String avatar,
			String passWord) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		Avatar = avatar;
		this.passWord = passWord;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return Avatar;
	}





	public void setAvatar(String avatar) {
		Avatar = avatar;
	}





	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
