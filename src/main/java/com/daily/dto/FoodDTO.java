package com.daily.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
	private int idx;
	private String name;
	private String category;
	private int amount;
	private double energy;
	private double carb;
	private double sugar;
	private double protein;
	private double fat;
	private double sodium;
}
