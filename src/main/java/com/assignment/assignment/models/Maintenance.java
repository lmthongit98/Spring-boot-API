package com.assignment.assignment.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name="maintenance")
public class Maintenance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String asset;
	private String program;
	private Integer status;
	private Double lon;
	private Double lat;
		
	public Maintenance() {
		
	}
	
	public Maintenance(String asset, String program, Integer status, Double lon, Double lat) {
		super();
		this.asset = asset;
		this.program = program;
		this.status = status;
		this.lon = lon;
		this.lat = lat;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
}