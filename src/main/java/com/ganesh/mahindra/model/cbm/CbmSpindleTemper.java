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
@Table(name="t_cbm_spindle_tapper_blue")
public class CbmSpindleTemper {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stb_id")
	private int stbId;

	@Column(name = "machine_no")
	private String machineNo; 
	
	@Column(name = "machine_name")
	private String machineName;
	
	@Column(name = "per1")
	private String per1;
	
	@Column(name = "remark1")
	private String remark1;
	
	@Column(name = "date1")
	private Date date1;
	
	@Column(name = "per2")
	private String per2;
	
	@Column(name = "remark2")
	private String remark2;
	
	@Column(name = "date2")
	private Date date2;
	
	@Column(name = "extra1")
	private int extra1;
	
	@Column(name = "extra2")
	private int extra2;
	
	@Column(name = "vachar1")
	private String vachar1;
	
	@Column(name = "vachar2")
	private String vachar2;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "year_end")
	private String yearEnd;
	
	@Column(name = "sch_id")
	private int schId;
	
	@Column(name = "dept_id")
	private int deptId;

	public int getStbId() {
		return stbId;
	}

	public void setStbId(int stbId) {
		this.stbId = stbId;
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

	public String getPer1() {
		return per1;
	}

	public void setPer1(String per1) {
		this.per1 = per1;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getPer2() {
		return per2;
	}

	public void setPer2(String per2) {
		this.per2 = per2;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
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

	public String getVachar1() {
		return vachar1;
	}

	public void setVachar1(String vachar1) {
		this.vachar1 = vachar1;
	}

	public String getVachar2() {
		return vachar2;
	}

	public void setVachar2(String vachar2) {
		this.vachar2 = vachar2;
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "CbmSpindleTemper [stbId=" + stbId + ", machineNo=" + machineNo + ", machineName=" + machineName
				+ ", per1=" + per1 + ", remark1=" + remark1 + ", date1=" + date1 + ", per2=" + per2 + ", remark2="
				+ remark2 + ", date2=" + date2 + ", extra1=" + extra1 + ", extra2=" + extra2 + ", vachar1=" + vachar1
				+ ", vachar2=" + vachar2 + ", status=" + status + ", yearEnd=" + yearEnd + ", schId=" + schId
				+ ", deptId=" + deptId + "]";
	}
	
	
	 
}
