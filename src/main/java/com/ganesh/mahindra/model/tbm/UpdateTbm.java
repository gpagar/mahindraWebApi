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
public class UpdateTbm implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_tbm_id")
	private int tTbmId;
	
    private String nextDoneDate;
	
	private String nextObservation;
	
	private String nextObDate;
	
	private int delStatus;

	public int gettTbmId() {
		return tTbmId;
	}

	public void settTbmId(int tTbmId) {
		this.tTbmId = tTbmId;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "UpdateTbm [tTbmId=" + tTbmId + ", nextDoneDate=" + nextDoneDate + ", nextObservation=" + nextObservation
				+ ", nextObDate=" + nextObDate + ", delStatus=" + delStatus + "]";
	}
	
	
}
