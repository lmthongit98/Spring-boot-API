package com.assignment.assignment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="intime_asset")
public class IntimeAsset {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer id_asset;
	private Integer intime_month; 
	public IntimeAsset() {
		
	}
		
	public IntimeAsset(Integer id_asset, Integer intime_month) {
		super();
		this.id_asset = id_asset;
		this.intime_month = intime_month;
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
	public Integer getIntime_month() {
		return intime_month;
	}
	public void setIntime_month(Integer intime_month) {
		this.intime_month = intime_month;
	}
}
