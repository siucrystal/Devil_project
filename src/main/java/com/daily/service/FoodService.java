package com.daily.service;

import java.util.List;
import java.util.Map;

import com.daily.dto.FoodDTO;
import com.daily.dto.MyFoodDTO;
import com.daily.dto.PageDTO;

public interface FoodService {
	List<FoodDTO> getFoodList(PageDTO dto);
	PageDTO getPageParam(PageDTO dto);
	List<FoodDTO> getCategory();
	
	List<MyFoodDTO> setMyFood(Map<String,Object> map);
	List<FoodDTO> getFoodone(int idx);
	
}
