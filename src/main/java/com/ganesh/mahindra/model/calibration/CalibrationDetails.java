package com.ganesh.mahindra.model.calibration;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CalibrationDetails implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "eq_name ")
	private String eqName;
	
	@Column(name = "sr_no")
	private String srNo;
	
	@Column(name = "card_no")
	private String cardNo;
	
	@Column(name = "machine_no")
	private String machineNo;
	
	@Column(name = "line")
	private String line;
	
	@Column(name = "frequency")
	private int frequency;
	
	@Column(name = "last_cal_date")
	private Date lastCalDate;
	
	@Column(name = "next_cal_date")
	private Date nextCalDate;
	
	@Column(name = "del_status")
	private int delStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEqName() {
		return eqName;
	}

	public void setEqName(String eqName) {
		this.eqName = eqName;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLastCalDate() {
		return lastCalDate;
	}

	public void setLastCalDate(Date lastCalDate) {
		this.lastCalDate = lastCalDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getNextCalDate() {
		return nextCalDate;
	}

	public void setNextCalDate(Date nextCalDate) {
		this.nextCalDate = nextCalDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "CalibrationDetails [id=" + id + ", eqName=" + eqName + ", srNo=" + srNo + ", cardNo=" + cardNo
				+ ", machineNo=" + machineNo + ", line=" + line + ", frequency=" + frequency + ", lastCalDate="
				+ lastCalDate + ", nextCalDate=" + nextCalDate + ", delStatus=" + delStatus + "]";
	}
	
	
	
}
