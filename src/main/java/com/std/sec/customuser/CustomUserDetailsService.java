package com.std.sec.customuser;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.std.sec.log.LogDao;
import com.std.sec.log.LogService;
import com.std.sec.user.UserDao;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao service;
	
	@Autowired
	private LogService logService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails users = null;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id",username);
		try {
			users=service.getUserById(map);
		}catch (NullPointerException e) {
			throw new UsernameNotFoundException("username " + username + " not found");
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if(users==null) {
			throw new UsernameNotFoundException("username " + username + " not found");
		}
		
		try {
			logService.insertLog(users.getUsername(), "1");
		} catch (Exception e) {}
		
		return users;
	}

}
