package com.ganesh.mahindra.model.tbm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="tbm_machine")
public class TbmMachine implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "machine_id")
	private int machineId;
	
	@Column(name = "machine_name")
	private String machineName;
	
	@Column(name = "machine_no")
	private String machineNo;
	
	@Column(name = "del_status")
	private int delStatus;

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "TbmMachine [machineId=" + machineId + ", machineName=" + machineName + ", machineNo=" + machineNo
				+ ", delStatus=" + delStatus + "]";
	}
	
	

}
