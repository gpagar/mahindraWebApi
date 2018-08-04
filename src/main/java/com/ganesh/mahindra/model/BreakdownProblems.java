package com.ganesh.mahindra.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BreakdownProblems implements Serializable{

	@Id
	private int id;
	
	private String machineNo;
	
	private String problemReported;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getProblemReported() {
		return problemReported;
	}

	public void setProblemReported(String problemReported) {
		this.problemReported = problemReported;
	}

	@Override
	public String toString() {
		return "BreakdownProblems [id=" + id + ", machineNo=" + machineNo + ", problemReported=" + problemReported
				+ "]";
	}
	
	
}
