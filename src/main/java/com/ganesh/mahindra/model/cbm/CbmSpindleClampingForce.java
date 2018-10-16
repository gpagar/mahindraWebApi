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
@Table(name="t_cbm_spindle_clamping_force")
public class CbmSpindleClampingForce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scf_id")
	private int scfId;

	@Column(name = "machine_no")
	private String machineNo; 
	
	@Column(name = "machine_name")
	private String machineName;
	
	@Column(name = "frequency")
	private String frequency;
	
	@Column(name = "minimum_required_value")
	private String minimumRequiredValue;
	
	@Column(name = "date1")
	private Date date1;
	
	@Column(name = "q1")
	private String q1;
	  
	@Column(name = "date2")
	private Date date2;
	
	@Column(name = "q2")
	private String q2;
	 
	@Column(name = "date3")
	private Date date3;
	
	@Column(name = "q3")
	private String q3;
	
	@Column(name = "date4")
	private Date date4;
	
	@Column(name = "q4")
	private String q4;
	
	@Column(name = "avg_value")
	private String avgValue;
	
	@Column(name = "status_remark")
	private String statusRemark;
	
	@Column(name = "dept_id")
	private int deptId;
	
	@Column(name = "extra1")
	private int extra1;
	
	@Column(name = "extra2")
	private int extra2;
	
	@Column(name = "varchar1")
	private String varchar1;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "year_end")
	private String yearEnd;

	@Column(name = "sch_id")
	private int schId;

	public int getScfId() {
		return scfId;
	}

	public void setScfId(int scfId) {
		this.scfId = scfId;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getMinimumRequiredValue() {
		return minimumRequiredValue;
	}

	public void setMinimumRequiredValue(String minimumRequiredValue) {
		this.minimumRequiredValue = minimumRequiredValue;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate4() {
		return date4;
	}

	public void setDate4(Date date4) {
		this.date4 = date4;
	}

	public String getQ4() {
		return q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}

	public String getAvgValue() {
		return avgValue;
	}

	public void setAvgValue(String avgValue) {
		this.avgValue = avgValue;
	}

	public String getStatusRemark() {
		return statusRemark;
	}

	public void setStatusRemark(String statusRemark) {
		this.statusRemark = statusRemark;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getExtra1() {
		return extra1;
	}

	public void setExtra1(int extra1) {
		this.extra1 = extra1;
	}

	public int getExtra2() {
		return extra2;
	}

	public void setExtra2(int extra2) {
		this.extra2 = extra2;
	}

	public String getVarchar1() {
		return varchar1;
	}

	public void setVarchar1(String varchar1) {
		this.varchar1 = varchar1;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}

	public int getSchId() {
		return schId;
	}

	public void setSchId(int schId) {
		this.schId = schId;
	}

	@Override
	public String toString() {
		return "CbmSpindleClampingForce [scfId=" + scfId + ", machineNo=" + machineNo + ", machineName=" + machineName
				+ ", frequency=" + frequency + ", minimumRequiredValue=" + minimumRequiredValue + ", date1=" + date1
				+ ", q1=" + q1 + ", date2=" + date2 + ", q2=" + q2 + ", date3=" + date3 + ", q3=" + q3 + ", date4="
				+ date4 + ", q4=" + q4 + ", avgValue=" + avgValue + ", statusRemark=" + statusRemark + ", deptId="
				+ deptId + ", extra1=" + extra1 + ", extra2=" + extra2 + ", varchar1=" + varchar1 + ", status=" + status
				+ ", yearEnd=" + yearEnd + ", schId=" + schId + "]";
	}
	
	
}
