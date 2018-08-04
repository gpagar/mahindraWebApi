package com.ganesh.mahindra.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="why_why_f18")
public class BreakdownDetail implements Serializable{

	@Id
   private int id;
	
	
	private int isHdp;
	
	private String hdp;

	private int breakdownPhenomenon;
		
	private int prevenReccurId;
	
	private String prevenReccur;

	private int systemclassif;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsHdp() {
		return isHdp;
	}

	public void setIsHdp(int isHdp) {
		this.isHdp = isHdp;
	}

	public String getHdp() {
		return hdp;
	}

	public void setHdp(String hdp) {
		this.hdp = hdp;
	}

	public int getBreakdownPhenomenon() {
		return breakdownPhenomenon;
	}

	public void setBreakdownPhenomenon(int breakdownPhenomenon) {
		this.breakdownPhenomenon = breakdownPhenomenon;
	}

	public int getPrevenReccurId() {
		return prevenReccurId;
	}

	public void setPrevenReccurId(int prevenReccurId) {
		this.prevenReccurId = prevenReccurId;
	}

	public String getPrevenReccur() {
		return prevenReccur;
	}

	public void setPrevenReccur(String prevenReccur) {
		this.prevenReccur = prevenReccur;
	}

	public int getSystemclassif() {
		return systemclassif;
	}

	public void setSystemclassif(int systemclassif) {
		this.systemclassif = systemclassif;
	}

	@Override
	public String toString() {
		return "BreakdownDetail [id=" + id + ", isHdp=" + isHdp + ", hdp=" + hdp + ", breakdownPhenomenon="
				+ breakdownPhenomenon + ", prevenReccurId=" + prevenReccurId + ", prevenReccur=" + prevenReccur
				+ ", systemclassif=" + systemclassif + "]";
	}
	
	

    
}
