package com.ganesh.mahindra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machin_details")
public class MachinDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "machin_id")
	int machinId;

	@Column(name = "machin_name ")
	String machinName;
	
	@Column(name = "machin_no")
	String machinNo;

	@Column(name = "string3")
	String string3;

	@Column(name = " del_status")
	int delStatus;
	@Column(name = "int_1")
	int int1;

	@Column(name = "int_2")
	int int2;

	@Column(name = "string1")
	String string1;
	@Column(name = "string2")
	String string2;
	public int getMachinId() {
		return machinId;
	}
	public void setMachinId(int machinId) {
		this.machinId = machinId;
	}
	public String getMachinName() {
		return machinName;
	}
	public void setMachinName(String machinName) {
		this.machinName = machinName;
	}
	public String getMachinNo() {
		return machinNo;
	}
	public void setMachinNo(String machinNo) {
		this.machinNo = machinNo;
	}
	public String getString3() {
		return string3;
	}
	public void setString3(String string3) {
		this.string3 = string3;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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
	public String getString1() {
		return string1;
	}
	public void setString1(String string1) {
		this.string1 = string1;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	@Override
	public String toString() {
		return "MachinDetails [machinId=" + machinId + ", machinName=" + machinName + ", machinNo=" + machinNo
				+ ", string3=" + string3 + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2
				+ ", string1=" + string1 + ", string2=" + string2 + "]";
	}
 
	
	
	
}
