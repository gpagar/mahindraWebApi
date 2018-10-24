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
@Table(name="t_cbm_erthing_resis")
public class CbmEarthingResistance {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cer_id")
	private int cerId;

	@Column(name = "machin_no")
	private String machineNo;
	
	@Column(name = "dept")
	private String dept;
	
	@Column(name = "machine_name")
	private String machineName;
	
	@Column(name = "resistance1")
	private String resistance1;
	
	@Column(name = "obsrvn1")
	private String obsrvn1;
	
	@Column(name = "date1")
	private Date date1;
	
	@Column(name = "status1")
	private String status1;
	
	@Column(name = "remark1")
	private String remark1;
	
	@Column(name = "resistance2")
	private String resistance2;
	
	@Column(name = "obsrvn2")
	private String obsrvn2;
	
	@Column(name = "date2")
	private Date date2;
	
	@Column(name = "status2")
	private String status2;
	
	@Column(name = "remark2")
	private String remark2;
	
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
	
	@Column(name = "dept_id")
	private int deptId;
	
	@Column(name = "sch_id")
	private int schId;
	
	public int getCerId() {
		return cerId;
	}

	public void setCerId(int cerId) {
		this.cerId = cerId;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getResistance1() {
		return resistance1;
	}

	public void setResistance1(String resistance1) {
		this.resistance1 = resistance1;
	}

	public String getObsrvn1() {
		return obsrvn1;
	}

	public void setObsrvn1(String obsrvn1) {
		this.obsrvn1 = obsrvn1;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getResistance2() {
		return resistance2;
	}

	public void setResistance2(String resistance2) {
		this.resistance2 = resistance2;
	}

	public String getObsrvn2() {
		return obsrvn2;
	}

	public void setObsrvn2(String obsrvn2) {
		this.obsrvn2 = obsrvn2;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getSchId() {
		return schId;
	}

	public void setSchId(int schId) {
		this.schId = schId;
	}

	@Override
	public String toString() {
		return "CbmEarthingResistance [cerId=" + cerId + ", machineNo=" + machineNo + ", dept=" + dept
				+ ", machineName=" + machineName + ", resistance1=" + resistance1 + ", obsrvn1=" + obsrvn1 + ", date1="
				+ date1 + ", status1=" + status1 + ", remark1=" + remark1 + ", resistance2=" + resistance2
				+ ", obsrvn2=" + obsrvn2 + ", date2=" + date2 + ", status2=" + status2 + ", remark2=" + remark2
				+ ", extra1=" + extra1 + ", extra2=" + extra2 + ", varchar1=" + varchar1 + ", varchar2=" + varchar2
				+ ", status=" + status + ", deptId=" + deptId + ", schId=" + schId + "]";
	}
	
	

}
