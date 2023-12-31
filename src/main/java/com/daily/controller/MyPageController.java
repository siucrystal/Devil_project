package com.daily.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daily.dto.FoodDTO;
import com.daily.dto.WaterDTO;
import com.daily.service.FoodService;
import com.daily.service.WaterService;

@Controller
@RequestMapping("mypage")
public class MyPageController {
   String view;
   
   @Autowired
   @Qualifier("waterServiceImpl") 
   WaterService water2;

   @Autowired
   @Qualifier("foodServiceImpl")
   FoodService service;
   
   @RequestMapping("main")
   public String main() {
      return "mypage/main";
   }
   
   @GetMapping("water")
   public ModelAndView water(WaterDTO dto, RedirectAttributes ra, HttpSession session) {
      ModelAndView mav = new ModelAndView();
      String id = (String)session.getAttribute("id");
      int rs = water2.getOne(id);
      if(rs == 1) {
         rs = water2.WaterUpdate(dto);   
         dto = water2.getWaterOne(dto.getId()); 
         
      } else {
         rs = water2.getWaterAccure(dto);   
         dto = water2.getWaterOne(dto.getId());
      }
      
      List<FoodDTO> category = service.selectCategoryList();
      
      mav.setViewName("mypage/main");
      mav.addObject("id",dto.getId());
      mav.addObject("water",dto.getWater());
      mav.addObject("height", dto.getHeight());
      mav.addObject("weight", dto.getWeight());
      mav.addObject("waterguide", dto.getWaterguide());
      mav.addObject("category",category);
      return mav; 
   }
   
   @GetMapping("waterIdSubmit")
   @ResponseBody
   public Map<String, Object> waterIdSubmit(HttpSession session) {
      
      List<FoodDTO> category = service.selectCategoryList();
      
       String id = (String) session.getAttribute("id");
       int rs = water2.getOne(id);
       
       Map<String, Object> response = new HashMap();

       if (rs == 1) {
           // 만약 rs가 0인 경우
           WaterDTO dto = water2.getWaterOne(id);
           response.put("dto", dto);
       }else if (rs == 0) {
          response.put("rs", rs);
       }

       return response;
   }
}