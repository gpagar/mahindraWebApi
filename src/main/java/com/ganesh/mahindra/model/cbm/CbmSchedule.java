package com.ganesh.mahindra.model.cbm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_cbm_schedule")
public class CbmSchedule implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "machine_no")
	private String machineNo;
	
	@Column(name = "line")
	private String line;
	
	@Column(name = "machine_name")
	private String machineName;
	
	@Column(name = "scf_q1")
	private String scfQ1;
	
	@Column(name = "scf_q2")
	private String scfQ2;
	
	@Column(name = "scf_q3")
	private String scfQ3;
	
	@Column(name = "scf_q4")
	private String scfQ4;
	
	@Column(name = "bbt_h2")
	private String bbtH2;
	
	@Column(name = "sv_q1")
	private String svQ1;
	
	@Column(name = "sv_q3")
	private String svQ3;
	
	@Column(name = "stc_q1")
	private String stcQ1;
	
	@Column(name = "stc_q3")
	private String stcQ3;
	
	@Column(name = "tg")
	private String tg;
	
	@Column(name = "er_h1")
	private String erH1;
	
	@Column(name = "er_h2")
	private String erH2;
	
	@Column(name = "ahm_h1")
	private String ahmH1;
	
	@Column(name = "ahm_h2")
	private String ahmH2;
	
	@Column(name = "vm_h1")
	private String vmH1;
	
	@Column(name = "vm_h2")
	private String vmH2;
	
	@Column(name = "mmc_h1")
	private String mmcH1;
	
	@Column(name = "mmc_h2")
	private String mmcH2;
	
	@Column(name = "hpp")
	private String hpp;
	
	@Column(name = "oda")
	private String oda;
	
	@Column(name = "pa")
	private String pa;
	
	private int deptId;

	
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

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

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getScfQ1() {
		return scfQ1;
	}

	public void setScfQ1(String scfQ1) {
		this.scfQ1 = scfQ1;
	}

	public String getScfQ2() {
		return scfQ2;
	}

	public void setScfQ2(String scfQ2) {
		this.scfQ2 = scfQ2;
	}

	public String getScfQ3() {
		return scfQ3;
	}

	public void setScfQ3(String scfQ3) {
		this.scfQ3 = scfQ3;
	}

	public String getScfQ4() {
		return scfQ4;
	}

	public void setScfQ4(String scfQ4) {
		this.scfQ4 = scfQ4;
	}

	public String getBbtH2() {
		return bbtH2;
	}

	public void setBbtH2(String bbtH2) {
		this.bbtH2 = bbtH2;
	}

	public String getSvQ1() {
		return svQ1;
	}

	public void setSvQ1(String svQ1) {
		this.svQ1 = svQ1;
	}

	public String getSvQ3() {
		return svQ3;
	}

	public void setSvQ3(String svQ3) {
		this.svQ3 = svQ3;
	}

	public String getStcQ1() {
		return stcQ1;
	}

	public void setStcQ1(String stcQ1) {
		this.stcQ1 = stcQ1;
	}

	public String getStcQ3() {
		return stcQ3;
	}

	public void setStcQ3(String stcQ3) {
		this.stcQ3 = stcQ3;
	}

	public String getTg() {
		return tg;
	}

	public void setTg(String tg) {
		this.tg = tg;
	}

	public String getErH1() {
		return erH1;
	}

	public void setErH1(String erH1) {
		this.erH1 = erH1;
	}

	public String getErH2() {
		return erH2;
	}

	public void setErH2(String erH2) {
		this.erH2 = erH2;
	}

	public String getAhmH1() {
		return ahmH1;
	}

	public void setAhmH1(String ahmH1) {
		this.ahmH1 = ahmH1;
	}

	public String getAhmH2() {
		return ahmH2;
	}

	public void setAhmH2(String ahmH2) {
		this.ahmH2 = ahmH2;
	}

	public String getVmH1() {
		return vmH1;
	}

	public void setVmH1(String vmH1) {
		this.vmH1 = vmH1;
	}

	public String getVmH2() {
		return vmH2;
	}

	public void setVmH2(String vmH2) {
		this.vmH2 = vmH2;
	}

	public String getMmcH1() {
		return mmcH1;
	}

	public void setMmcH1(String mmcH1) {
		this.mmcH1 = mmcH1;
	}

	public String getMmcH2() {
		return mmcH2;
	}

	public void setMmcH2(String mmcH2) {
		this.mmcH2 = mmcH2;
	}

	public String getHpp() {
		return hpp;
	}

	public void setHpp(String hpp) {
		this.hpp = hpp;
	}

	public String getOda() {
		return oda;
	}

	public void setOda(String oda) {
		this.oda = oda;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	@Override
	public String toString() {
		return "CbmSchedule [id=" + id + ", machineNo=" + machineNo + ", line=" + line + ", machineName=" + machineName
				+ ", scfQ1=" + scfQ1 + ", scfQ2=" + scfQ2 + ", scfQ3=" + scfQ3 + ", scfQ4=" + scfQ4 + ", bbtH2=" + bbtH2
				+ ", svQ1=" + svQ1 + ", svQ3=" + svQ3 + ", stcQ1=" + stcQ1 + ", stcQ3=" + stcQ3 + ", tg=" + tg
				+ ", erH1=" + erH1 + ", erH2=" + erH2 + ", ahmH1=" + ahmH1 + ", ahmH2=" + ahmH2 + ", vmH1=" + vmH1
				+ ", vmH2=" + vmH2 + ", mmcH1=" + mmcH1 + ", mmcH2=" + mmcH2 + ", hpp=" + hpp + ", oda=" + oda + ", pa="
				+ pa + "]";
	}
	
	
	
}
