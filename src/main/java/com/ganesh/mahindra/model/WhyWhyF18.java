package com.ganesh.mahindra.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "why_why_f18")
public class WhyWhyF18 implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	 @Column(name = "machine_id")
	private int machineId;
	 
    @Column(name = "machine_no")
	private String machineNo;

	@Column(name = "month")
	private String month;

	@Column(name = "date")
	private Date date;

	@Column(name = "dept")
	private String dept;

	@Column(name = "cell_circle")
	private String cellCircle;

	@Column(name = " problem_reported")
	private String problemReported;

	@Column(name = "bd_time_loss")
	private String bdTimeLoss;

	@Column(name = "engine_loss")
	private String engineLoss;

	@Column(name = "part_status")
	private String partStatus;

	@Column(name = " part_desc")
	private String partDesc;

	@Column(name = "bd_ms_pt")
	private String bdMsPt;

	@Column(name = " action")
	private String action;

	@Column(name = " why1")
	private String why1;

	@Column(name = "why2")
	private String why2;

	@Column(name = " why3")
	private String why3;

	@Column(name = " why4")
	private String why4;

	@Column(name = " why5")
	private String why5;

	@Column(name = " root_cause")
	private String rootCause;

	@Column(name = " clarification_of_cause")
	private String clarificationOfCause;

	@Column(name = "  failure_code")
	private String failureCode;

	@Column(name = "counter_measure ")
	private String counterMeasure;

	@Column(name = "category")
	private String category;

	@Column(name = "recur_non_recurr ")
	private String recurNonRecurr;

	@Column(name = "linkage_with")
	private String linkageWith;

	@Column(name = "status ")
	private int status;
	
	@Column(name = "ref_no")
	private String refNo;
	
	@Column(name = "sap_notif_no ")
	private String sapNotifNo;
	
	@Column(name = "del_status")
	private int delStatus;
    
	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCellCircle() {
		return cellCircle;
	}

	public void setCellCircle(String cellCircle) {
		this.cellCircle = cellCircle;
	}

	public String getProblemReported() {
		return problemReported;
	}

	public void setProblemReported(String problemReported) {
		this.problemReported = problemReported;
	}

	public String getBdTimeLoss() {
		return bdTimeLoss;
	}

	public void setBdTimeLoss(String bdTimeLoss) {
		this.bdTimeLoss = bdTimeLoss;
	}

	public String getEngineLoss() {
		return engineLoss;
	}

	public void setEngineLoss(String engineLoss) {
		this.engineLoss = engineLoss;
	}

	public String getPartStatus() {
		return partStatus;
	}

	public void setPartStatus(String partStatus) {
		this.partStatus = partStatus;
	}

	public String getPartDesc() {
		return partDesc;
	}

	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}

	public String getBdMsPt() {
		return bdMsPt;
	}

	public void setBdMsPt(String bdMsPt) {
		this.bdMsPt = bdMsPt;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getWhy1() {
		return why1;
	}

	public void setWhy1(String why1) {
		this.why1 = why1;
	}

	public String getWhy2() {
		return why2;
	}

	public void setWhy2(String why2) {
		this.why2 = why2;
	}

	public String getWhy3() {
		return why3;
	}

	public void setWhy3(String why3) {
		this.why3 = why3;
	}

	public String getWhy4() {
		return why4;
	}

	public void setWhy4(String why4) {
		this.why4 = why4;
	}

	public String getWhy5() {
		return why5;
	}

	public void setWhy5(String why5) {
		this.why5 = why5;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public String getClarificationOfCause() {
		return clarificationOfCause;
	}

	public void setClarificationOfCause(String clarificationOfCause) {
		this.clarificationOfCause = clarificationOfCause;
	}

	public String getFailureCode() {
		return failureCode;
	}

	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}

	public String getCounterMeasure() {
		return counterMeasure;
	}

	public void setCounterMeasure(String counterMeasure) {
		this.counterMeasure = counterMeasure;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRecurNonRecurr() {
		return recurNonRecurr;
	}

	public void setRecurNonRecurr(String recurNonRecurr) {
		this.recurNonRecurr = recurNonRecurr;
	}

	public String getLinkageWith() {
		return linkageWith;
	}

	public void setLinkageWith(String linkageWith) {
		this.linkageWith = linkageWith;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getSapNotifNo() {
		return sapNotifNo;
	}

	public void setSapNotifNo(String sapNotifNo) {
		this.sapNotifNo = sapNotifNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "WhyWhyF18 [id=" + id + ", machineNo=" + machineNo + ", month=" + month + ", date=" + date + ", dept="
				+ dept + ", cellCircle=" + cellCircle + ", problemReported=" + problemReported + ", bdTimeLoss="
				+ bdTimeLoss + ", engineLoss=" + engineLoss + ", partStatus=" + partStatus + ", partDesc=" + partDesc
				+ ", bdMsPt=" + bdMsPt + ", action=" + action + ", why1=" + why1 + ", why2=" + why2 + ", why3=" + why3
				+ ", why4=" + why4 + ", why5=" + why5 + ", rootCause=" + rootCause + ", clarificationOfCause="
				+ clarificationOfCause + ", failureCode=" + failureCode + ", counterMeasure=" + counterMeasure
				+ ", category=" + category + ", recurNonRecurr=" + recurNonRecurr + ", linkageWith=" + linkageWith
				+ ", status=" + status + ", refNo=" + refNo + ", sapNotifNo=" + sapNotifNo + ", delStatus=" + delStatus
				+ "]";
	}

	
}
