package com.ganesh.mahindra.model.cbm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="cbm_yar_end")
public class CbmYearEnd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "year_end_id")
	private int yearEndId;

	@Column(name = "year")
	private String year;  
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "status")
	private int status;
	 
	@Column(name = "from_year")
	private String fromYear;
	   
	@Column(name = "to_year")
	private String toYear;
	 
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "cbm_type")
	private int cbmType;
	
	@Column(name = "dept_id")
	private int deptId;
 
	public int getYearEndId() {
		return yearEndId;
	}

	public void setYearEndId(int yearEndId) {
		this.yearEndId = yearEndId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFromYear() {
		return fromYear;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public String getToYear() {
		return toYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCbmType() {
		return cbmType;
	}

	public void setCbmType(int cbmType) {
		this.cbmType = cbmType;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "CbmYearEnd [yearEndId=" + yearEndId + ", year=" + year + ", date=" + date + ", status=" + status
				+ ", fromYear=" + fromYear + ", toYear=" + toYear + ", userId=" + userId + ", cbmType=" + cbmType
				+ ", deptId=" + deptId + "]";
	}
	
	

}
