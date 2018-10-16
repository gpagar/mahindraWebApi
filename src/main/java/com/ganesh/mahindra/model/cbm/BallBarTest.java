package com.ganesh.mahindra.model.cbm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_cbm_ball_bar_test")
public class BallBarTest implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bbt_id")
	private int bbtId;

	@Column(name = "machine_no")
	private String machineNo; 
	
	@Column(name = "machine_name")
	private String machineName;
	
	@Column(name = "line")
	private String line;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "extra1")
	private int extra1;
	
	@Column(name = "extra2")
	private int extra2;
	
	@Column(name = "varchar1")
	private String varchar1;
	
	@Column(name = "varchar2")
	private String varchar2;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "year_end")
	private String yearEnd;
	
	@Column(name = "sch_id")
	private int schId;
	
	@Column(name = "dept_id")
	private int deptId;

	private String file;
	
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getBbtId() {
		return bbtId;
	}

	public void setBbtId(int bbtId) {
		this.bbtId = bbtId;
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

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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

	public String getVarchar2() {
		return varchar2;
	}

	public void setVarchar2(String varchar2) {
		this.varchar2 = varchar2;
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
		return "BallBarTest [bbtId=" + bbtId + ", machineNo=" + machineNo + ", machineName=" + machineName + ", line="
				+ line + ", remark=" + remark + ", date=" + date + ", extra1=" + extra1 + ", extra2=" + extra2
				+ ", varchar1=" + varchar1 + ", varchar2=" + varchar2 + ", status=" + status + ", yearEnd=" + yearEnd
				+ ", schId=" + schId + ", deptId=" + deptId + "]";
	}

	
}
