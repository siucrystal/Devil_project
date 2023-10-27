package com.daily.dto;

public class RecipeDTO {
	private int idx;
	private String id;
	private String name;
	private String category;
	private String recipe_name;
	private int amount;
	private double energy;
	private double carb;
	private double sugar;
	private double protein;
	private double fat;
	private double sodium;
	private double gram;
	
	public RecipeDTO() {
		super();
	}
	
	public RecipeDTO(int idx,String name, String category, int amount, double energy, double carb, double sugar, double protein,
			double fat, double sodium) {
		super();
		this.idx = idx;
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
	
	

	public RecipeDTO(int idx, String id, String name, String category, int amount, double energy, double carb,
			double sugar, double protein, double fat, double sodium) {
		super();
		this.idx = idx;
		this.id = id;
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

	
	public RecipeDTO(int idx, String id, String name, String category, int amount, double energy, double carb,
			double sugar, double protein, double fat, double sodium, double gram) {
		super();
		this.idx = idx;
		this.id = id;
		this.name = name;
		this.category = category;
		this.amount = amount;
		this.energy = energy;
		this.carb = carb;
		this.sugar = sugar;
		this.protein = protein;
		this.fat = fat;
		this.sodium = sodium;
		this.gram = gram;
	}

	
	public RecipeDTO(int idx, String id, String name, String category, String recipe_name, int amount, double energy,
			double carb, double sugar, double protein, double fat, double sodium, double gram) {
		super();
		this.idx = idx;
		this.id = id;
		this.name = name;
		this.category = category;
		this.recipe_name = recipe_name;
		this.amount = amount;
		this.energy = energy;
		this.carb = carb;
		this.sugar = sugar;
		this.protein = protein;
		this.fat = fat;
		this.sodium = sodium;
		this.gram = gram;
	}

	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
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

	public double getGram() {
		return gram;
	}

	public void setGram(double gram) {
		this.gram = gram;
	}

	@Override
	public String toString() {
		return "RecipeDTO [idx=" + idx + ", id=" + id + ", name=" + name + ", category=" + category + ", recipe_name="
				+ recipe_name + ", amount=" + amount + ", energy=" + energy + ", carb=" + carb + ", sugar=" + sugar
				+ ", protein=" + protein + ", fat=" + fat + ", sodium=" + sodium + ", gram=" + gram + "]";
	}




	
	
}
