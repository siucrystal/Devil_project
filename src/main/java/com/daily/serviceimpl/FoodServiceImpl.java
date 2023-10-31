package com.daily.serviceImpl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dto.FoodDTO;
import com.daily.dto.KDRIsDTO;
import com.daily.dto.MemberDTO;
import com.daily.dto.MyFoodDTO;
import com.daily.mapper.FoodMapper;
import com.daily.service.FoodService;


@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodMapper food;

	int pageLimit = 5;
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
	public List<FoodDTO> selectCategoryList() {
		return food.selectCategoryList();
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


	@Override
	public KDRIsDTO selectKdris(String id) {
		MemberDTO member = food.selectMember(id);
		int sex = member.getSex(); 
		int age = member.getAge();

		if(age < 29) {
			age = 18;
		} else if(age < 48) {
			age = 29;
		} else if(age < 64) {
			age = 48;
		} else if(age < 75) {
			age = 64;
		} else {
			age = 75;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("age", age);
		map.put("sex", sex);      

		return food.selectKdris(map);      

	}


	@Override
	public MyFoodDTO selectMyEat(String id) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String date = sdf.format(today);
		System.out.println(date);
		Map<String, Object> map = new HashMap();
		map.put("id", id);
		map.put("date", date);
		List<MyFoodDTO> myfoodlist = food.selectMyFoodList(map);

		double denergy = 0;
		double dcarb = 0;
		double dsugar = 0;
		double dprotein = 0;
		double dfat = 0;
		double dsodium = 0;

		MyFoodDTO myfood =  new MyFoodDTO();

		for(MyFoodDTO dto : myfoodlist) {
			denergy += dto.getEnergy();
			dcarb += dto.getCarb();
			dsugar += dto.getSugar();
			dprotein += dto.getProtein();
			dfat += dto.getFat();
			dsodium += dto.getSodium();

		}
		DecimalFormat df = new DecimalFormat("#.##");

		double energy = Double.parseDouble(df.format(denergy));
		double carb = Double.parseDouble(df.format(dcarb));
		double sugar = Double.parseDouble(df.format(dsugar));
		double protein = Double.parseDouble(df.format(dprotein));
		double fat = Double.parseDouble(df.format(dfat));
		double sodium = Double.parseDouble(df.format(dsodium));

		myfood.setEnergy(energy);
		myfood.setCarb(carb);
		myfood.setSugar(sugar);
		myfood.setProtein(protein);
		myfood.setFat(fat);
		myfood.setSodium(sodium);

		return myfood;
	}


	@Override
	public List<FoodDTO> recommendFoodList(String id) {

		MyFoodDTO m = selectMyEat(id);
		KDRIsDTO k = selectKdris(id);
		DecimalFormat df = new DecimalFormat("#.##");
		
		double energy = Double.parseDouble(df.format(k.getEnergy()-m.getEnergy()));
		double carb = Double.parseDouble(df.format(k.getCarb()-m.getCarb()));
		double protein = Double.parseDouble(df.format(k.getProtein()-m.getProtein()));
		
		List<FoodDTO> dto = null;
		
		if(protein>=energy && protein >= carb) {
			dto = food.getProtein(protein);
		} else if(energy>=carb && energy>=protein){
			dto = food.getEnergy(energy);
		} else if(carb>= energy && carb >= energy){
			dto = food.getCarb(carb);
		}
		
		
		return dto;
	}
}