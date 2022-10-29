package com.newsfed.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "autogen")
	@TableGenerator(name = "autogen", initialValue = 1 ,allocationSize = 1)
	private Long id;
	
	@Column(name = "user_id", unique = true, nullable = false)
	private String userId;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "role", nullable = false)
	private String role;
	@Column(name="first_name", nullable = false)
	private String firstName;
	@Column(name="middle_name", nullable = true)
	private String middleName;
	@Column(name="last_name", nullable = false)
	private String lastName;
	@Column(name="is_active", nullable = false)
	private boolean isActive;
	@Column(name="email_id", unique = true, nullable = false)
	private String emailId;
	@Column(name="created_by", nullable = false)
	private String createdBy;
	@Column(name="modified_by", nullable = false)
	private String modifiedBy;
	@Column(name="created_date", nullable = false)
	private String createdDate;
	@Column(name="modified_date", nullable = false)
	private String modifiedDate;
	
}
