package com.newsfed.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class UserDto implements Serializable {
	
	private static final long serialVersionUID = -4839319964003589473L;
	private Long id;
	
	private String userId;
	private String password;
	private String role;
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean isActive;
	private String emailId;
	private String createdBy;
	private String modifiedBy;
	private String createdDate;
	private String modifiedDate;

}
