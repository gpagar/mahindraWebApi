package com.ganesh.mahindra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPaMaintainence implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pa_maint_id")
	private int paMaintId;

	@Column(name = "machin_id")
	private int machinId;
	
	@Column(name = "machin_name")
	private String machinName;
	
	@Column(name = "machin_no")
	private String machinNo;
	
	@Column(name = "activity_id")
	private int activityId;
	
	@Column(name = "activity_name")
	private String activityName;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "check_point_id")
	private int checkPointId;
	
	@Column(name = "check_point_name")
	private String checkPointName;

	@Column(name = "method")
	private int method;

	@Column(name = "required_value")
	private int rquiredValure;

	@Column(name = "date1")
	private String date1;

	@Column(name = "date1_observation")
	private String date1Obervation;
	

	@Column(name = "date1_photo")
	private String date1Photo;


	@Column(name = "date2")
	private String date2;

	@Column(name = "date2_observation")
	private String date2Obervation;
	

	@Column(name = "date2_photo")
	private String date2Photo;


	@Column(name = "date3")
	private String date3;

	@Column(name = "date3_observation")
	private String date3Obervation;
	
	@Column(name = "date3_photo")
	private String date3Photo;

	@Column(name = "status")
	private int status;
	
	@Column(name = "type")
	private int type;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "int_1")
	private int int1;

	@Column(name = "int_2")
	private int int2;
	
	@Column(name = "int_3")
	private int int3;

	@Column(name = "string1")
	private String string1;

	@Column(name = "string2")
	private String string2;

	@Column(name = "remark")
	private String remark;

	
	
	public int getInt3() {
		return int3;
	}

	public void setInt3(int int3) {
		this.int3 = int3;
	}

	public int getPaMaintId() {
		return paMaintId;
	}

	public void setPaMaintId(int paMaintId) {
		this.paMaintId = paMaintId;
	}

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

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCheckPointId() {
		return checkPointId;
	}

	public void setCheckPointId(int checkPointId) {
		this.checkPointId = checkPointId;
	}

	public String getCheckPointName() {
		return checkPointName;
	}

	public void setCheckPointName(String checkPointName) {
		this.checkPointName = checkPointName;
	}

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
	}

	public int getRquiredValure() {
		return rquiredValure;
	}

	public void setRquiredValure(int rquiredValure) {
		this.rquiredValure = rquiredValure;
	}


	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate1Obervation() {
		return date1Obervation;
	}

	public void setDate1Obervation(String date1Obervation) {
		this.date1Obervation = date1Obervation;
	}

	public String getDate1Photo() {
		return date1Photo;
	}

	public void setDate1Photo(String date1Photo) {
		this.date1Photo = date1Photo;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getDate2Obervation() {
		return date2Obervation;
	}

	public void setDate2Obervation(String date2Obervation) {
		this.date2Obervation = date2Obervation;
	}

	public String getDate2Photo() {
		return date2Photo;
	}

	public void setDate2Photo(String date2Photo) {
		this.date2Photo = date2Photo;
	}

	public String getDate3() {
		return date3;
	}

	public void setDate3(String date3) {
		this.date3 = date3;
	}

	public String getDate3Obervation() {
		return date3Obervation;
	}

	public void setDate3Obervation(String date3Obervation) {
		this.date3Obervation = date3Obervation;
	}

	public String getDate3Photo() {
		return date3Photo;
	}

	public void setDate3Photo(String date3Photo) {
		this.date3Photo = date3Photo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "GetPaMaintainence [paMaintId=" + paMaintId + ", machinId=" + machinId + ", machinName=" + machinName
				+ ", machinNo=" + machinNo + ", activityId=" + activityId + ", activityName=" + activityName
				+ ", itemId=" + itemId + ", itemName=" + itemName + ", checkPointId=" + checkPointId
				+ ", checkPointName=" + checkPointName + ", method=" + method + ", rquiredValure=" + rquiredValure
				+ ",date1=" + date1 + ", date1Obervation=" + date1Obervation
				+ ", date1Photo=" + date1Photo + ", date2=" + date2 + ", date2Obervation=" + date2Obervation
				+ ", date2Photo=" + date2Photo + ", date3=" + date3 + ", date3Obervation=" + date3Obervation
				+ ", date3Photo=" + date3Photo + ", status=" + status + ", type=" + type + ", delStatus=" + delStatus
				+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + ", remark="
				+ remark + "]";
	}
	
	
}
