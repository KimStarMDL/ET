package com.myet.basic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myet.basic.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public boolean userInsert(UserDTO dto) {
		
		return userMapper.userInsert(dto);
	}

	@Override
	public int idCheck(String u_id) {
		
		return userMapper.idCheck(u_id);
	}

	@Override
	public int nickCheck(String u_nick) {

		return userMapper.nickCheck(u_nick);
	}

	@Override
	public boolean userUpdate(UserDTO dto) {
		
		return userMapper.userUpdate(dto);
	}

	@Override
	public boolean userDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDTO login(UserDTO user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public int emailCheck(String u_email) {
		// TODO Auto-generated method stub
		return userMapper.emailCheck(u_email);
	}

	@Override
	public UserDTO userRead(String u_id) {
		
		return userMapper.userRead(u_id);
	}
}
