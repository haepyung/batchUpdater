package com.batch.updater.db0.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "EBAD")
public class EBAD {

	@Id
	@Column(length = 20)
	private String POST_ID;
	
	@Column(nullable = false, length = 24)
	private String MEMBER_ID;

	@Column(nullable = false, length = 200)
	private String MEMBER_NAME;
	
	@Column(nullable = false, length = 128)
	private String EMAIL_ID;

	@Column(length = 128)
	private String DOMAIN;
	
	@Column(length = 1024)
	private String FIELD1;
	
	@Column(length = 1024)
	private String FIELD2;
	
	@Column(length = 1024)
	private String FIELD3;
	
	@Column(length = 1024)
	private String FIELD4;
	
	@Column(length = 1024)
	private String FIELD5;
	
	@Column(length = 1024)
	private String FIELD6;
	 
	@Column(length = 14)
	private String SEND_TIME;
	
	@Column(length = 14)
	private String DELIVER_TIME;
	
	@Column(length = 2)
	private String ERROR_CODE;
	
	@Column()
	private int QUESTION_PART;
	
	@Column()
	private int OPEN_CNT;
	
	@Column()
	private int CLICK_CNT;
	
	@Column()
	private int TOT_DUR_TIME;
	
	@Column()
	private int TOT_DUR_CNT;
	
	@Column(length = 14)
	private String OPEN_TIME;
	
	@Column(length = 14)
	private String CLICK_TIME;
	
	@Column(length = 14)
	private String TDATE;
	
	@Column(length = 2)
	private String OLD_ERROR_CODE;
	
	@Column(length = 14)
	private String FIRST_OPEN_TIME;
	
	@Column(nullable = false, length = 3)
	private String SERVER_ID;
	
	@Column(nullable = false, length = 14)
	private String UPDATE_D;
	
	@Column(length = 20)
	private String MD_OS;
	
	@Column(length = 20)
	private String MD_DEVICE;
	
	@Column()
	private Date MD_UNIQUE_OPENTIME;
	
	@Column()
	private int UNIQUE_CLICK; 
}