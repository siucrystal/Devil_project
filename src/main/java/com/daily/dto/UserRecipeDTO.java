package com.daily.dto;

public class UserRecipeDTO {
	private String member_id;
	private String recipe_name;
	private double total_amount;
	private double total_energy;
	private double total_carb;
	private double total_sugar;
	private double total_protein;
	private double total_fat;
	private double total_sodium;
	private double total_gram;
	
	public UserRecipeDTO() {
		super();
	}
	
	public UserRecipeDTO(String member_id, String recipe_name, double total_amount, double total_energy,
			double total_carb, double total_sugar, double total_protein, double total_fat, double total_sodium,
			double total_gram) {
		super();
		this.member_id = member_id;
		this.recipe_name = recipe_name;
		this.total_amount = total_amount;
		this.total_energy = total_energy;
		this.total_carb = total_carb;
		this.total_sugar = total_sugar;
		this.total_protein = total_protein;
		this.total_fat = total_fat;
		this.total_sodium = total_sodium;
		this.total_gram = total_gram;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public double getTotal_energy() {
		return total_energy;
	}

	public void setTotal_energy(double total_energy) {
		this.total_energy = total_energy;
	}

	public double getTotal_carb() {
		return total_carb;
	}

	public void setTotal_carb(double total_carb) {
		this.total_carb = total_carb;
	}

	public double getTotal_sugar() {
		return total_sugar;
	}

	public void setTotal_sugar(double total_sugar) {
		this.total_sugar = total_sugar;
	}

	public double getTotal_protein() {
		return total_protein;
	}

	public void setTotal_protein(double total_protein) {
		this.total_protein = total_protein;
	}

	public double getTotal_fat() {
		return total_fat;
	}

	public void setTotal_fat(double total_fat) {
		this.total_fat = total_fat;
	}

	public double getTotal_sodium() {
		return total_sodium;
	}

	public void setTotal_sodium(double total_sodium) {
		this.total_sodium = total_sodium;
	}

	public double getTotal_gram() {
		return total_gram;
	}

	public void setTotal_gram(double total_gram) {
		this.total_gram = total_gram;
	}

	@Override
	public String toString() {
		return "UserRecipeDTO [member_id=" + member_id + ", recipe_name=" + recipe_name + ", total_amount="
				+ total_amount + ", total_energy=" + total_energy + ", total_carb=" + total_carb + ", total_sugar="
				+ total_sugar + ", total_protein=" + total_protein + ", total_fat=" + total_fat + ", total_sodium="
				+ total_sodium + ", total_gram=" + total_gram + "]";
	}
	
	
	
}
