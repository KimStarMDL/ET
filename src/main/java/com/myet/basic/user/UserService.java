package com.myet.basic.user;

import com.myet.basic.dto.UserDTO;

public interface UserService {

	public boolean userInsert(UserDTO dto);  //회원가입
	public int idCheck(String u_id);  // 아이디 체크
	public int nickCheck(String u_nick);  // 비밀번호 체크
	public int emailCheck(String u_email); // 이메일 체크
	public boolean userUpdate();  //회원 정보 수정
	public boolean userDelete();  //회원 정보 삭제
	public UserDTO login(UserDTO user);  //로그인
	
}
