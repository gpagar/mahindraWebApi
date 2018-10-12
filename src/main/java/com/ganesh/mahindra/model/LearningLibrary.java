package com.ganesh.mahindra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_learning_library")
public class LearningLibrary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "file_id")
	private int fileId;

	@Column(name = "file_name ")
	private String fileName;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "file_desc")
	private String fileDesc;
	
	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "varchar1")
	private String varchar1;

	@Column(name = "varchar2")
	private String varchar2;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getVarchar1() {
		return varchar1;
	}

	public void setVarchar1(String varchar1) {
		this.varchar1 = varchar1;
	}

	public String getVarchar2() {
		return varchar2;
	}

	public void setVarchar2(String varchar2) {
		this.varchar2 = varchar2;
	}

	@Override
	public String toString() {
		return "LearningLibrary [fileId=" + fileId + ", fileName=" + fileName + ", date=" + date + ", fileDesc="
				+ fileDesc + ", delStatus=" + delStatus + ", varchar1=" + varchar1 + ", varchar2=" + varchar2 + "]";
	}
	
	

}
