package com.newsfed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;
@Entity
@Table(name ="newsfed" )
@Data
public class Newsfed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "autogen")
	@TableGenerator(name = "autogen", initialValue = 1 ,allocationSize = 1)
	private Long id;
	
	@Column(name="header", nullable = false)
	private String header;
	@Column(name="published_date", nullable = false)
	private Date publishedDate;
	@Column(name="description", length= 1000, nullable = false)
	private String description;
	@Column(name="sent_status", nullable = false, columnDefinition="bit default false")
	private boolean sentStatus;
	@Column(name="created_date", nullable = false)
	private Date createdDate;
	@Column(name="modifie_date", nullable = false)
	private Date modifiedDate;
	@Column(name="is_deleted", nullable = false, columnDefinition="bit default false")
	private boolean deleted;

}
