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
	public List<FoodDTO> getFoodList(int page) {
	
		int pageStart = (page-1) * pageLimit;
		Map<String, Integer> pagingParams = new HashMap();
		pagingParams.put("start", pageStart);
		pagingParams.put("limit", pageLimit);
		List<FoodDTO> getFoodList = food.getFoodList(pagingParams); 
		
		return getFoodList;
	}


	@Override
	public PageDTO getPageParam(int page) {
		int boardCount = food.boardCount();
		
		int maxPage = (int) (Math.ceil((double)boardCount / pageLimit));
		
		int startPage = (((int)(Math.ceil((double)page / blockLimit))) - 1 ) * blockLimit + 1;
		
		int endPage = startPage + blockLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setStartPage(startPage);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setEndPage(endPage);
		
		return pageDTO;
	}

	@Override
	public List<FoodDTO> getCategory() {
		return food.getCategory();
	}
	
	@Override
	public List<FoodDTO> getFoodListSearch(int page, FoodDTO dto) {
		return null;
	}




}
