package com.ganesh.mahindra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_details")
public class PMItemDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="item_id")
	int itemId;
	
	@Column(name = "machin_id")
	int machinId;
	
	@Column(name = "activity_id")
	int activityId;
	
	
	
	@Column(name = "item_name")
	String itemName;
	
	
	@Column(name = "item_desc")
	String itemDesc;
	
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getMachinId() {
		return machinId;
	}

	public void setMachinId(int machinId) {
		this.machinId = machinId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
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
		return "PMItemDetails [itemId=" + itemId + ", machinId=" + machinId + ", activityId=" + activityId
				+ ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", delStatus=" + delStatus + ", int1=" + int1
				+ ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + "]";
	}
	
	
	
}
