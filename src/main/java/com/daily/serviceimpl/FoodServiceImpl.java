package com.daily.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daily.dto.FoodDTO;
import com.daily.dto.PageDTO;
import com.daily.mapper.FoodMapper;
import com.daily.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodMapper food;
	
	int pageLimit = 10;
	int blockLimit = 10;
	@Override
	public List<FoodDTO> getFoodList(PageDTO dto) {
		
		int page = dto.getPage();
		int pageStart = (page-1) * pageLimit;
		Map<String, Object> pagingParams = new HashMap();
		pagingParams.put("start", pageStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("category", dto.getCategory());
		pagingParams.put("name", dto.getName());
		List<FoodDTO> getFoodList = food.getFoodList(pagingParams); 
		
		return getFoodList;
	}


	@Override
	public PageDTO getPageParam(PageDTO dto) {
		int page = dto.getPage();
		int boardCount = food.boardCount(dto);
		
		int maxPage = (int) (Math.ceil((double)boardCount / pageLimit));
		
		int startPage = (((int)(Math.ceil((double)page / blockLimit))) - 1 ) * blockLimit + 1;
		
		int endPage = startPage + blockLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		dto.setMaxPage(maxPage);
		dto.setStartPage(startPage);
		dto.setMaxPage(maxPage);
		dto.setEndPage(endPage);
		
		return dto;
	}

	@Override
	public List<FoodDTO> getCategory() {
		return food.getCategory();
	}
	
	@Override
	public List<FoodDTO> getFoodListSearch(FoodDTO dto) {
		return food.getFoodListSearch(dto);
	}




}
