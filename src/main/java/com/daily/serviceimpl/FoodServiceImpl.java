package com.daily.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daily.dto.FoodDTO;
import com.daily.mapper.FoodMapper;
import com.daily.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodMapper food;
	
	@Override
	public List<FoodDTO> getFoodList() {

		return food.getFoodList();
	}

	@Override
	public List<FoodDTO> getFoodListSearch(FoodDTO dto) {
		return food.getFoodListSearch(dto);
	}
	

}
