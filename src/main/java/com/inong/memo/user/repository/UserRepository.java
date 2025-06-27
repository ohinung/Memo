package com.inong.memo.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.inong.memo.user.domain.User;

@Mapper //xml과 연결하기 위한 어노테이션
public interface UserRepository {

	public int insertUser(
			@Param("loginId") String loginId
			,@Param("password")String password
			,@Param("name")String name
			,@Param("email")String email);
	
	
	public User selectUser(
					@Param("loginId") String loginId
					,@Param("password") String password) ;
	
}
