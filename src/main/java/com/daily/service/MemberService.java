package com.daily.service;

import com.daily.dto.MemberDTO;

public interface MemberService {
	int MemberRegister(MemberDTO dto);
	String getMemberLogin(String id);
}
