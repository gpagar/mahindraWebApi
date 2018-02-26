package com.ganesh.mahindra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maintanance_schedule")
public class MachinMaintanaceSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "maint_id")
	int maintId;

	@Column(name = "machin_id")
	int machinId;
	
	@Column(name = "f_status")
	int fStatus;
	
	@Column(name = "s_status")
	int sStatus;

	@Column(name = "type")
	int type;

	@Column(name = "f_month")
	int fMonth;

	@Column(name = "f_week")
	int fWeek;

	@Column(name = "s_month")
	int sMonth;

	@Column(name = "s_week")
	int sWeek;

	@Column(name = "t_month")
	int tMonth;

	@Column(name = "t_week")
	int tweek;

	@Column(name = "del_status")
	int delStatus;

	@Column(name = "int_1")
	int int1;

	@Column(name = "int_2")
	int int2;

	@Column(name = "string1")
	String string1;

	@Column(name = "string2")
	String string2;
	
	@Column(name = "t_status")
	int tStatus;

	public int getMaintId() {
		return maintId;
	}

	public void setMaintId(int maintId) {
		this.maintId = maintId;
	}

	public int getMachinId() {
		return machinId;
	}

	public void setMachinId(int machinId) {
		this.machinId = machinId;
	}

	public int getfStatus() {
		return fStatus;
	}

	public void setfStatus(int fStatus) {
		this.fStatus = fStatus;
	}

	public int getsStatus() {
		return sStatus;
	}

	public void setsStatus(int sStatus) {
		this.sStatus = sStatus;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getfMonth() {
		return fMonth;
	}

	public void setfMonth(int fMonth) {
		this.fMonth = fMonth;
	}

	public int getfWeek() {
		return fWeek;
	}

	public void setfWeek(int fWeek) {
		this.fWeek = fWeek;
	}

	public int getsMonth() {
		return sMonth;
	}

	public void setsMonth(int sMonth) {
		this.sMonth = sMonth;
	}

	public int getsWeek() {
		return sWeek;
	}

	public void setsWeek(int sWeek) {
		this.sWeek = sWeek;
	}

	public int gettMonth() {
		return tMonth;
	}

	public void settMonth(int tMonth) {
		this.tMonth = tMonth;
	}

	public int getTweek() {
		return tweek;
	}

	public void setTweek(int tweek) {
		this.tweek = tweek;
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

	public int gettStatus() {
		return tStatus;
	}

	public void settStatus(int tStatus) {
		this.tStatus = tStatus;
	}

	@Override
	public String toString() {
		return "MachinMaintanaceSchedule [maintId=" + maintId + ", machinId=" + machinId + ", fStatus=" + fStatus
				+ ", sStatus=" + sStatus + ", type=" + type + ", fMonth=" + fMonth + ", fWeek=" + fWeek + ", sMonth="
				+ sMonth + ", sWeek=" + sWeek + ", tMonth=" + tMonth + ", tweek=" + tweek + ", delStatus=" + delStatus
				+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + ", tStatus="
				+ tStatus + "]";
	}

	 
	
}
