package com.daily.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.daily.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	int MemberRegister(MemberDTO dto);
	MemberDTO getMemberLogin(String id);
	int updateMemberPassword(MemberDTO dto);
}
