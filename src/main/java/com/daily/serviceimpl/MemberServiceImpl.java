package com.daily.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dto.MemberDTO;
import com.daily.mapper.MemberMapper;
import com.daily.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper member;
	
	@Override
	public int MemberRegister(MemberDTO dto) {
		try {
			member.MemberRegister(dto);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public String getMemberLogin(String id) {
		return member.getMemberLogin(id);
	
	}
		
}
