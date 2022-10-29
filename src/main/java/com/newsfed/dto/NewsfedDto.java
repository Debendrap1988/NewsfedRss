package com.newsfed.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class NewsfedDto implements Serializable {

	private static final long serialVersionUID = 6527938032638419389L;

	private Long id;

	private String header;
	private Date publishedDate;
	private String description;
	private boolean sentStatus;
	private Date createdDate;
	private Date modifiedDate;
	private boolean deleted;

}
