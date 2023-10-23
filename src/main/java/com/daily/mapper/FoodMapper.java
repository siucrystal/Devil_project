package com.daily.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.daily.dto.FoodDTO;

@Mapper
public interface FoodMapper {

	List<FoodDTO> getFoodList();
	List<FoodDTO> getFoodListSearch(FoodDTO dto);

}
