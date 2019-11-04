package com.batch.updater.db1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "Customs")
public class Custom {

	@Id
	@Column(length = 36)
	private String id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 64)
	private String pw;
	
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	
	@Column(length = 255)
	private String ip;
}