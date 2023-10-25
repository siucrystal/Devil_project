package com.daily.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.daily.dto.FoodDTO;

@Mapper
public interface FoodMapper {

	List<FoodDTO> getCategory();
	List<FoodDTO> getFoodList(Map<String,Integer> pagingParams);
	List<FoodDTO> getFoodListSearch(FoodDTO dto);
	int boardCount();
	

}
