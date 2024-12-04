package com.dptcldpa.memo.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dptcldpa.memo.common.MD5HashingEncoder;

@Mapper
public interface UserRepository {
	
	public int insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("email") String email);
	
	public User getUser(String loginId, String password) {
		
		String encodingPassword = MD5HashingEncoder.encode(password);
		
		return userRepository.selectUser(loginId, password);
		
	}
	
}
