package com.daily.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dto.WaterDTO;
import com.daily.mapper.WaterMapper;
import com.daily.service.WaterService;

@Service
public class WaterServiceImpl implements WaterService {
	@Autowired 
	WaterMapper water2;
	 
	@Override 
	public int getWaterAccure(WaterDTO dto) {
		System.out.println("It this here??");
		System.out.println("ServiceImpl :  " + dto);
		
		int rs = 0;
		try {
			rs = water2.getWaterAccure(dto);
			rs = 1;
			return rs;
		} catch (Exception e) {
			return rs;
		}
	}
	
	@Override 
	public int getOne(String id) {
		int rs = 0;
		try {
			rs = water2.getOne(id);
			rs = 1;
			return rs;
		} catch (Exception e) {
			return rs;
		}
	}
	
	@Override 
	public int WaterUpdate(WaterDTO dto) {
		
		int rs = 0;
		try {
			rs = water2.WaterUpdate(dto);
			rs = 1;
			System.out.println("이쪽 update impl rs 1 : " + rs);
			return rs;
		} catch (Exception e) {
			System.out.println("이쪽 update impl rs 2 : " + rs);
			return rs;
		}
	}
	@Override 
	public WaterDTO getWaterOne(String id) {
		System.out.println("waterOne  dto : " + id);
		WaterDTO dto = water2.getWaterOne(id); 
		System.out.println("waterOne  dto : " + dto);
		return dto;
	}
}
