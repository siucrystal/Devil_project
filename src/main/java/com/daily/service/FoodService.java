package com.daily.service;

import java.util.List;

import com.daily.dto.FoodDTO;
import com.daily.dto.PageDTO;

public interface FoodService {
	List<FoodDTO> getFoodList(int page);
	PageDTO getPageParam(int page);

	List<FoodDTO> getFoodListSearch(int page, FoodDTO dto);
	List<FoodDTO> getCategory();
}
