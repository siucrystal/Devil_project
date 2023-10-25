package com.daily.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.daily.dto.FoodDTO;
import com.daily.dto.PageDTO;

@Mapper
public interface FoodMapper {

	List<FoodDTO> getCategory();
	List<FoodDTO> getFoodList(Map<String,Object> pagingParams);
	List<FoodDTO> getFoodListSearch(FoodDTO dto);
	int boardCount(PageDTO dto);
	

}
