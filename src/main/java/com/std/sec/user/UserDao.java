package com.std.sec.user;

import java.util.HashMap;

import com.std.sec.customuser.CustomUserDetails;

public interface UserDao {

	public int insertUser(HashMap<String, Object> map) throws Exception	;

	public int authinfo(HashMap<String, Object> map) throws Exception;
	
	public CustomUserDetails getUserById(HashMap<String,Object> map) throws Exception;
}
