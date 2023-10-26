package com.daily.dto;

public class WaterDTO {
	private String id;
	private int water;
	private double height;
	private double weight;
	private double waterguide;
	
	public WaterDTO() {
	}
	
	public WaterDTO(String id, int water, double height, double weight, double waterguide) {
		super();
		this.id = id;
		this.water = water;
		this.height = height;
		this.weight = weight;
		this.waterguide = waterguide;
	}
	public WaterDTO(int water, double height, double weight,double waterguide) {
		super();
		this.water = water;
		this.height = height;
		this.weight = weight;
		this.waterguide = waterguide;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWaterguide() {
		return waterguide;
	}

	public void setWaterguide(double waterguide) {
		this.waterguide = waterguide;
	}

	@Override
	public String toString() {
		return "WaterDTO [id = " + id + ", water =" + water + ", height =" + height + ", weight =" + weight + ", waterguide =" + waterguide + "]";
	}
	
	
}
