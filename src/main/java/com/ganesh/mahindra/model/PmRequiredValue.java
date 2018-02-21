package com.ganesh.mahindra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "pmrequiredvalue")
public class PmRequiredValue {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="required_value_id")
	int requiredValueId;
	
	
	@Column(name = "required_value")
	String requiredValue;
	
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

	public int getRequiredValueId() {
		return requiredValueId;
	}

	public void setRequiredValueId(int requiredValueId) {
		this.requiredValueId = requiredValueId;
	}

	public String getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(String requiredValue) {
		this.requiredValue = requiredValue;
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
		return "PmRequiredValue [requiredValueId=" + requiredValueId + ", requiredValue=" + requiredValue
				+ ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1
				+ ", string2=" + string2 + ", getRequiredValueId()=" + getRequiredValueId() + ", getRequiredValue()="
				+ getRequiredValue() + ", getDelStatus()=" + getDelStatus() + ", getInt1()=" + getInt1()
				+ ", getInt2()=" + getInt2() + ", getString1()=" + getString1() + ", getString2()=" + getString2()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
