package com.assignment.assignment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="overdue_asset")
public class OverdueAsset {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer id_asset;
	private Integer overdue_month;
	private Integer overdue_num_day;
	public OverdueAsset() {
		
	}
	public OverdueAsset(Integer id_asset, Integer overdue_month, Integer overdue_num_day) {
		super();
		this.id_asset = id_asset;
		this.overdue_month = overdue_month;
		this.overdue_num_day = overdue_num_day;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_asset() {
		return id_asset;
	}
	public void setId_asset(Integer id_asset) {
		this.id_asset = id_asset;
	}
	public Integer getOverdue_month() {
		return overdue_month;
	}
	public void setOverdue_month(Integer overdue_month) {
		this.overdue_month = overdue_month;
	}
	public Integer getOverdue_num_day() {
		return overdue_num_day;
	}
	public void setOverdue_num_day(Integer overdue_num_day) {
		this.overdue_num_day = overdue_num_day;
	}
	
}	
