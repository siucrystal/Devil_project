package com.daily.dto;

public class RecipeDTO {
	private String name;
	private String category;
	private int amount;
	private double energy;
	private double carb;
	private double sugar;
	private double protein;
	private double fat;
	private double sodium;
	
	public RecipeDTO(String name, String category, int amount, double energy, double carb, double sugar, double protein,
			double fat, double sodium) {
		super();
		this.name = name;
		this.category = category;
		this.amount = amount;
		this.energy = energy;
		this.carb = carb;
		this.sugar = sugar;
		this.protein = protein;
		this.fat = fat;
		this.sodium = sodium;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public double getCarb() {
		return carb;
	}

	public void setCarb(double carb) {
		this.carb = carb;
	}

	public double getSugar() {
		return sugar;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}
	
}
