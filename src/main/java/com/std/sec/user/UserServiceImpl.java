package com.std.sec.user;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UsersService{
	
	@Autowired
	UserDao service;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	@Transactional
	public boolean insertUser(String id, String pw) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("ID", id);
		map.put("PW", bcryptPasswordEncoder.encode(pw));
		
		if( service.insertUser(map) < 1) return false;
		
		map.put("AUTH", "ROLE_USER");
		if( service.authinfo(map) < 1) return false;
		
		return true;
	}

}
