package com.daily.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodDTO {
	private int idx;
	private String member_id;
	private int amount;
	private double energy;
	private double carb;
	private double sugar;
	private double protein;
	private double fat;
	private double sodium;	
	private Date date;
	private int food_recipe;
}
