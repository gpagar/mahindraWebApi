package com.ganesh.mahindra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_graph_type")
public class GraphType implements Serializable{

	  @Id
	  private int id;
	  
	  private int graphType;
	  
	  private String graphName;
	  
	  private int userId;
	  
	  private int delStatus;
	  
	  private int exInt;
	  
	  @Column(name="ex_var")
	  private String exString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGraphType() {
		return graphType;
	}

	public void setGraphType(int graphType) {
		this.graphType = graphType;
	}

	public String getGraphName() {
		return graphName;
	}

	public void setGraphName(String graphName) {
		this.graphName = graphName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getExInt() {
		return exInt;
	}

	public void setExInt(int exInt) {
		this.exInt = exInt;
	}

	public String getExString() {
		return exString;
	}

	public void setExString(String exString) {
		this.exString = exString;
	}

	@Override
	public String toString() {
		return "GraphType [id=" + id + ", graphType=" + graphType + ", graphName=" + graphName + ", userId=" + userId
				+ ", delStatus=" + delStatus + ", exInt=" + exInt + ", exString=" + exString + "]";
	}
	  
	  
	
}
