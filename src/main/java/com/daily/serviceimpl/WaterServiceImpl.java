package com.daily.serviceImpl;

import org.apache.ibatis.annotations.Param;
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
	public int WaterUpdate(WaterDTO dto) {
		
		int rs = 0;
		try {
			rs = water2.WaterUpdate(dto);
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
	public WaterDTO getWaterOne(String id) {
		WaterDTO dto = water2.getWaterOne(id); 
		return dto;
	}
}
