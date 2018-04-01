package com.ganesh.mahindra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetPMData implements Serializable{

	
	@Column(name = "machin_id")
	private int machinId;
	
	@Column(name = "activity_id")
	private int activityId;
	
	@Column(name = "activity_name")
	private String activityName;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_name")
	private String itemName;
	
	@Id
	@Column(name = "check_point_id")
	private int checkPointId;
	
	@Column(name = "check_point_name")
	private String checkPointName;

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

	@Override
	public String toString() {
		return "GetPMData [machinId=" + machinId + ", activityId=" + activityId + ", activityName=" + activityName
				+ ", itemId=" + itemId + ", itemName=" + itemName + ", checkPointId=" + checkPointId
				+ ", checkPointName=" + checkPointName + "]";
	}
	
	
	
}
