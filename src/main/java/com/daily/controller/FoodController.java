package com.daily.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily.dto.FoodDTO;
import com.daily.dto.KDRIsDTO;
import com.daily.dto.MyFoodDTO;
import com.daily.service.FoodService;

@Controller
@RequestMapping("mypage")
public class FoodController {
	String view;

	@Autowired
	@Qualifier("foodServiceImpl")
	FoodService service;

	@GetMapping("main")
	public String foodList(Model model) {

		// 카테고리 조회
		List<FoodDTO> category = service.selectCategoryList();

		model.addAttribute("category",category);

		view ="mypage/main";


		return view;
	}
	
	@PostMapping("selectFoodList")
	@ResponseBody
	public Map<String, Object> selectFoodList(FoodDTO foodDTO){
		foodDTO.setPage(foodDTO.getPage());
		foodDTO.setCategory(foodDTO.getCategory() == null ? "" : foodDTO.getCategory());
		foodDTO.setName(foodDTO.getName() == null ? "" : foodDTO.getName());

		foodDTO = service.selectFoodListCnt(foodDTO);

		List<FoodDTO> foodList = service.selectFoodList(foodDTO);

		Map<String,Object> list = new HashMap<String, Object>();

		list.put("list", foodList);
		list.put("paging", foodDTO);

		return list;
	}

	@PostMapping("selectMyFoodList")
	@ResponseBody
	public Map<String, Object> selectMyFoodList(String date, HttpSession session){

		String id = (String)session.getAttribute("id");

		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("date", date);

		List<MyFoodDTO> myfoodList = service.selectMyFoodList(map);

		Map<String,Object> list = new HashMap<String, Object>();
		list.put("list", myfoodList);

		return list;
	}

	@PostMapping("insertMyFood")
	@ResponseBody
	public Map<String, Object> insertMyFood(int idx, String date, HttpSession session){

		Map<String,Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("date", date);
		map.put("id", session.getAttribute("id"));

		List<MyFoodDTO> myfoodList = service.insertMyFood(map);

		Map<String,Object> list = new HashMap<String, Object>();
		list.put("list", myfoodList);

		return list;
	}

	@PostMapping("updateMyFood")
	@ResponseBody
	public Map<String, Object> updateMyFood(int idx, int uamount, HttpSession session){

		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("uamount", uamount);

		List<MyFoodDTO> myfoodList = service.updateMyFood(map);

		Map<String,Object> list = new HashMap<String, Object>();
		list.put("list", myfoodList);

		return list;
	}

	@PostMapping("deleteMyFood")
	@ResponseBody
	public Map<String, Object> deleteMyFood(int idx){

		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);

		List<MyFoodDTO> myfoodList = service.deleteMyFood(map);

		Map<String,Object> list = new HashMap<String, Object>();
		list.put("list", myfoodList);

		return list;
	}

	@PostMapping("selectEatList")
	@ResponseBody
	public Map<String, Object> selectEatList(HttpSession session){

		String id = (String)session.getAttribute("id");

		// kdris
		KDRIsDTO kdris = service.selectKdris(id);
		// myeat
		MyFoodDTO myeat = service.selectMyEat(id);

		// % 값 보내기
		int energy = (int) (myeat.getEnergy() / kdris.getEnergy()*100) ;
		int carb = (int) (myeat.getCarb() / kdris.getCarb()*100) ;
		int sugar = (int) (myeat.getSugar() / kdris.getSugar()*100) ;
		int protein = (int) (myeat.getProtein() / kdris.getProtein()*100) ;
		int fat = (int) (myeat.getFat() / kdris.getFat()*100) ;
		int sodium = (int) (myeat.getSodium() / kdris.getSodium()*100) ;

		Map<String,Object> list = new HashMap();
		list.put("energy", energy);
		list.put("carb", carb);
		list.put("sugar", sugar);
		list.put("protein", protein);
		list.put("fat", fat);
		list.put("sodium", sodium);

		return list;
	}

	@PostMapping("recommendList")
	@ResponseBody
	public Map<String, Object> recommendList(HttpSession session){

		String id = (String)session.getAttribute("id");

		List<FoodDTO> food = service.recommendFoodList(id);

		Map<String,Object> list = new HashMap();
		list.put("list", food);

		return list;
	}
}