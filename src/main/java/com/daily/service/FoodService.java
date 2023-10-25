package com.daily.service;

import java.util.List;

import com.daily.dto.FoodDTO;
import com.daily.dto.PageDTO;

public interface FoodService {
	List<FoodDTO> getFoodList(PageDTO dto);
	PageDTO getPageParam(PageDTO dto);

	List<FoodDTO> getFoodListSearch(FoodDTO dto);
	List<FoodDTO> getCategory();
}
