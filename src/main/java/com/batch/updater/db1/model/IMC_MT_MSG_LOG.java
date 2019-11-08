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
@Table(name = "IMC_MT_MSG_LOG")
public class IMC_MT_MSG_LOG {
	
	@Id
	@Column()
	private Long ID;

	@Column(nullable = false, length = 2)
	private String MT_TYPE;
	
	@Column(nullable = false, length = 2)
	private String STATUS;
	
	@Column(nullable = false, length = 2)
	private String PRIORITY;
	
	@Column(nullable = false, length = 2)
	private String AD_FLAG;

	@Column(nullable = false, length = 19)
	private String RESERVED_DATE;
	
	@Column(nullable = false, length = 16)
	private String PHONE_NUMBER;
	
	@Column(length = 16)
	private String CALLBACK;

	@Column(length = 100)
	private String TITLE;
	
	@Column(length = 3000)
	private String MESSAGE;
	
	@Column(length = 128)
	private String ATTACH_FILE_01;
	
	@Column(length = 128)
	private String ATTACH_FILE_02;
	
	@Column(length = 128)
	private String ATTACH_FILE_03;
	
	@Column(length = 5)
	private String BILL_CODE;
	
	@Column(length = 40)
	private String REQUEST_UID;
	
	@Column(length = 19)
	private String REQUEST_DATE;
	
	@Column(length = 19)
	private String RESPONSE_DATE;

	@Column(length = 5)
	private String RESPONSE_CODE;
	
	@Column(length = 2)
	private String REPORT_TYPE;
	
	@Column(length = 19)
	private String REPORT_DATE;
	
	@Column(length = 5)
	private String REPORT_CODE;
	
	@Column(length = 19)
	private String ARRIVAL_DATE;
	
	@Column(length = 2)
	private String SENDER_CODE;
	
	@Column(length = 64)
	private String ETC1;
	
	@Column(length = 64)
	private String ETC2;
	
	@Column(length = 64)
	private String ETC3;
	
	@Column(length = 64)
	private String ETC4;
	
	@Column(length = 64)
	private String ETC5;
}
