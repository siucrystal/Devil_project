package com.daily.service;

import com.daily.dto.MemberDTO;

public interface MemberService {
	int MemberRegister(MemberDTO dto);
	MemberDTO getMemberLogin(String id);
	int updateMemberPassword(MemberDTO dto);
}
