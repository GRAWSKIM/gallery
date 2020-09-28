package com.std.sec.user;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.std.sec.customuser.CustomUserDetails;


@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertUser(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("user.insertUser",map);
	}

	@Override
	public int authinfo(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("user.insertAuth",map);
	}

	@Override
	public CustomUserDetails getUserById(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.getUserById",map);			
	}

}
