package com.daily.service;

import java.util.List;

import com.daily.dto.FoodDTO;

public interface FoodService {
	List<FoodDTO> getFoodList();

	List<FoodDTO> getFoodListSearch(FoodDTO dto);
}
