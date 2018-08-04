package com.ganesh.mahindra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_setting")
public class TSetting{

	@Id
	private int settingId; 
	
	private String settingKey; 

	private int settingValue;

	public int getSettingId() {
		return settingId;
	}

	public String getSettingKey() {
		return settingKey;
	}

	public int getSettingValue() {
		return settingValue;
	}

	public void setSettingId(int settingId) {
		this.settingId = settingId;
	}

	public void setSettingKey(String settingKey) {
		this.settingKey = settingKey;
	}

	public void setSettingValue(int settingValue) {
		this.settingValue = settingValue;
	}

	@Override
	public String toString() {
		return "TSetting [settingId=" + settingId + ", settingKey=" + settingKey + ", settingValue=" + settingValue
				+ "]";
	} 
	
	
}
