package com.ganesh.mahindra.model.tbm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_tbm_machine")
public class PostTbm implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_tbm_id")
	private int tTbmId;
	
	private int machineId;
	
	private int locationId;
	
	private int itemId;
	
	private int frequency;
	
	private String lastDoneDate;
	
	private String lastObservation;
	
	private String lastObDate;
	
	private String nextDoneDate;
	
	private String nextObservation;
	
	private String nextObDate;
	
	private int status;
	
	private int delStatus;

	public int gettTbmId() {
		return tTbmId;
	}

	public void settTbmId(int tTbmId) {
		this.tTbmId = tTbmId;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getLastDoneDate() {
		return lastDoneDate;
	}

	public void setLastDoneDate(String lastDoneDate) {
		this.lastDoneDate = lastDoneDate;
	}

	public String getLastObservation() {
		return lastObservation;
	}

	public void setLastObservation(String lastObservation) {
		this.lastObservation = lastObservation;
	}

	public String getLastObDate() {
		return lastObDate;
	}

	public void setLastObDate(String lastObDate) {
		this.lastObDate = lastObDate;
	}

	public String getNextDoneDate() {
		return nextDoneDate;
	}

	public void setNextDoneDate(String nextDoneDate) {
		this.nextDoneDate = nextDoneDate;
	}

	public String getNextObservation() {
		return nextObservation;
	}

	public void setNextObservation(String nextObservation) {
		this.nextObservation = nextObservation;
	}

	public String getNextObDate() {
		return nextObDate;
	}

	public void setNextObDate(String nextObDate) {
		this.nextObDate = nextObDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "PostTbm [tTbmId=" + tTbmId + ", machineId=" + machineId + ", locationId=" + locationId + ", itemId="
				+ itemId + ", frequency=" + frequency + ", lastDoneDate=" + lastDoneDate + ", lastObservation="
				+ lastObservation + ", lastObDate=" + lastObDate + ", nextDoneDate=" + nextDoneDate
				+ ", nextObservation=" + nextObservation + ", nextObDate=" + nextObDate + ", status=" + status
				+ ", delStatus=" + delStatus + "]";
	}
	
	

}
