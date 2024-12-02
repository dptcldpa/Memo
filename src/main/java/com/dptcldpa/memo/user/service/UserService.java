package com.dptcldpa.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dptcldpa.memo.common.MD5HashingEncoder;
import com.dptcldpa.memo.user.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

//	@Autowired // autowired를 위한 생성자만 존재하는 경우에 생략 가능
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		String encodingPassword = MD5HashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, encodingPassword, name, email);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
