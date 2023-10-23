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
	public void MemberRegister(MemberDTO dto) {
		member.MemberRegister(dto);
	}

	@Override
	public String getMemberLogin(String id) {
		return member.getMemberLogin(id);
	
	}
		
}
