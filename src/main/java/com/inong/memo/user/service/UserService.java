package com.inong.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inong.memo.common.MD5HashingEncoder;
import com.inong.memo.user.repository.UserRepository;

@Service
public class UserService {
//	@Autowired
	//final : 해당 변수에 값이 저장된 후 수정 불가( 상수라고 칭한다.)
	private final UserRepository userRepository;
	
	//해당 클래스가 생성될 떄 Spring이 생성자를 호출해서 객체를 주입해준다.
	//다른 생성자 없이 Autowired를 위한 생성자만 있는 경우 Autowired 어노테이션 생략 가능
	@Autowired
	UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	//사용자 추가 기능
	public boolean addUser(
			String loginId
			,String password
			,String name
			,String email) {
		
		String hashingPassword = MD5HashingEncoder.encode(password);
		//원본을 정해진 길이의 16진수 문자열을 만듬 해싱된 문자열은 원본데이터로 되돌릴 수 없다.
		
		
		int count =userRepository.insertUser(loginId, hashingPassword, name, email);
		
		if(count == 1) {
			return true;
		}else {
			return false;
		}
		
	}

}
