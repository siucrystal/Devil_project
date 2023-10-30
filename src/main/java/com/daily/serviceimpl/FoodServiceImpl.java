package com.daily.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dto.FoodDTO;
import com.daily.dto.MyFoodDTO;
import com.daily.mapper.FoodMapper;
import com.daily.service.FoodService;


@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodMapper food;

	int pageLimit = 10;
	int blockLimit = 10;
	
	@Override
	public List<FoodDTO> selectFoodList(FoodDTO foodDTO) {

		int page = foodDTO.getPage();
		int pageStart = (page-1) * pageLimit;
		
		Map<String, Object> pagingParams = new HashMap<String, Object>();
		
		pagingParams.put("start", pageStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("category", foodDTO.getCategory());
		pagingParams.put("name", foodDTO.getName());
		
		List<FoodDTO> foodList = food.selectFoodList(pagingParams); 

		return foodList;
	}


	@Override
	public FoodDTO selectFoodListCnt(FoodDTO foodDTO) {
		
		int page = foodDTO.getPage() == 0 ? 1 : foodDTO.getPage();
		
		int foodListCnt = food.selectFoodListCnt(foodDTO);

		int maxPage = (int) (Math.ceil((double)foodListCnt / pageLimit));

		int startPage = (((int)(Math.ceil((double)page / blockLimit))) - 1 ) * blockLimit + 1;

		int endPage = startPage + blockLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		foodDTO.setPage(page);
		foodDTO.setStartPage(startPage);
		foodDTO.setMaxPage(maxPage);
		foodDTO.setEndPage(endPage);

		return foodDTO;
	}

	@Override
	public List<FoodDTO> slectCategoryList() {
		return food.slectCategoryList();
	}


	@Override
	public List<MyFoodDTO> selectMyFoodList(Map<String, Object> mmylist) {
		return food.selectMyFoodList(mmylist);
	}
	
	@Override
	public List<MyFoodDTO> insertMyFood(Map<String,Object> map) {
		
		int idx = (Integer) map.get("idx");
		String id = (String) map.get("id");
		String date = (String) map.get("date");

		FoodDTO dto = food.selectFood(idx);

		MyFoodDTO my = new MyFoodDTO();
		
		my.setId(id);
		my.setName(dto.getName());
		my.setCategory(dto.getCategory());
		my.setAmount(dto.getAmount());
		my.setEnergy(dto.getEnergy());
		my.setCarb(dto.getCarb());
		my.setSugar(dto.getSugar());
		my.setProtein(dto.getProtein());
		my.setFat(dto.getFat());
		my.setSodium(dto.getSodium());
		my.setDate(date);
		
		food.insertMyFood(my);

		return food.selectMyFoodList(map);
	}


	@Override
	public List<MyFoodDTO> updateMyFood(Map<String, Integer> map) {
		
		int idx = map.get("idx");
		MyFoodDTO dto = food.selectMyFood(idx);

		int uamount = map.get("uamount");
		double mul = (double)map.get("uamount")/ dto.getAmount();

		dto.setIdx(idx);
		dto.setAmount(uamount);
		dto.setEnergy(Math.round(dto.getEnergy()*mul*100)/100.0);
		dto.setCarb(Math.round(dto.getCarb()*mul*100)/100.0);
		dto.setSugar(Math.round(dto.getSugar()*mul*100)/100.0);
		dto.setProtein(Math.round(dto.getProtein()*mul*100)/100.0);
		dto.setFat(Math.round(dto.getFat()*mul*100)/100.0);
		dto.setSodium(Math.round(dto.getSodium()*mul*100)/100.0);

		food.updateMyFood(dto);

		Map<String, Object> myfood = new HashMap<String, Object>();
		myfood.put("id", dto.getId());
		String date = dto.getDate().substring(2,10);
		myfood.put("date", date);
		
		return food.selectMyFoodList(myfood);
	}
	
	@Override
	public List<MyFoodDTO> deleteMyFood(Map<String, Integer> map) {
		
		int idx = map.get("idx");
		MyFoodDTO dto = food.selectMyFood(idx);
		
		food.deleteMyFood(dto);
		
		Map<String, Object> myfood = new HashMap<String, Object>();
		myfood.put("id", dto.getId());
		String date = dto.getDate().substring(2,10);
		myfood.put("date", date);
		
		return food.selectMyFoodList(myfood);
	}
}
