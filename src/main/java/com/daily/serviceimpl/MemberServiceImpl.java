package com.daily.serviceImpl;

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
		int rs = 0;
		try {
			rs = member.MemberRegister(dto);
			return rs;
		} catch (Exception e) {
			return rs;
		}
	}

	@Override
	public MemberDTO getMemberLogin(String id) {
		MemberDTO dto = null;
		try {
			dto = member.getMemberLogin(id);
			return dto;
		} catch (Exception e) {
			return dto;
		}
	
	}

	@Override
	public int updateMemberPassword(MemberDTO dto) {
		int rs = 0;
		try {
			rs = member.updateMemberPassword(dto);
			return rs;
		} catch (Exception e) {
			return rs;
		}
	}
		
}
