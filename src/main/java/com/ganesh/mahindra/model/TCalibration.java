package com.ganesh.mahindra.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_mach_eq_calibration")
public class TCalibration implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "m_cal_id")
	private int mCalId;

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
	
	@Column(name = "calibration_done_date")
	private Date calibrationDoneDate;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "del_status")
	private int delStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getmCalId() {
		return mCalId;
	}

	public void setmCalId(int mCalId) {
		this.mCalId = mCalId;
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

	public Date getLastCalDate() {
		return lastCalDate;
	}

	public void setLastCalDate(Date lastCalDate) {
		this.lastCalDate = lastCalDate;
	}

	public Date getCalibrationDoneDate() {
		return calibrationDoneDate;
	}

	public void setCalibrationDoneDate(Date calibrationDoneDate) {
		this.calibrationDoneDate = calibrationDoneDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "TCalibration [id=" + id + ", mCalId=" + mCalId + ", eqName=" + eqName + ", srNo=" + srNo + ", cardNo="
				+ cardNo + ", machineNo=" + machineNo + ", line=" + line + ", frequency=" + frequency + ", lastCalDate="
				+ lastCalDate + ", calibrationDoneDate=" + calibrationDoneDate + ", status=" + status + ", delStatus="
				+ delStatus + "]";
	}

	
}
