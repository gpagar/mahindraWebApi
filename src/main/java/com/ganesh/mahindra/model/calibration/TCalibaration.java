package com.ganesh.mahindra.model.calibration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_mach_eq_calibration")
public class TCalibaration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;

	@Column(name = "eq_name ")
	String eqName;
	
	@Column(name = "sr_no")
	String srNo;
	
	@Column(name = "card_no")
	String cardNo;

	@Column(name = "machine_no")
	String machineNo;

	@Column(name = "line")
	String line;
	
	@Column(name = " frequency")
	float frequency;
	
	@Column(name = "last_cal_date")
	Date lastCalDate;

	@Column(name = "calibration_done_date")
	Date calibrationDoneDate;

	@Column(name = "status")
	int status;
	
	@Column(name = "del_status")
	int delStatus;
	
	@Column(name = "m_cal_id")
	int mCalId;
	
	@Column(name = "dept_id")
	int deptId;
	
	@Column(name = "inta")
	int int1;
	
	@Column(name = "intb")
	int int2;
	
	@Column(name = "file_name")
	String fileName;

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
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLastCalDate() {
		return lastCalDate;
	}

	public void setLastCalDate(Date lastCalDate) {
		this.lastCalDate = lastCalDate;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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
 

	public int getmCalId() {
		return mCalId;
	}

	public void setmCalId(int mCalId) {
		this.mCalId = mCalId;
	}

	 

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public float getFrequency() {
		return frequency;
	}

	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "TCalibaration [id=" + id + ", eqName=" + eqName + ", srNo=" + srNo + ", cardNo=" + cardNo
				+ ", machineNo=" + machineNo + ", line=" + line + ", frequency=" + frequency + ", lastCalDate="
				+ lastCalDate + ", calibrationDoneDate=" + calibrationDoneDate + ", status=" + status + ", delStatus="
				+ delStatus + ", mCalId=" + mCalId + ", deptId=" + deptId + ", int1=" + int1 + ", int2=" + int2
				+ ", fileName=" + fileName + "]";
	}
 
	 

}
