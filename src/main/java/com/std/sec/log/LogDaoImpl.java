package com.std.sec.log;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoImpl implements LogDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertLog(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("user.insertLog",map);
	}

	@Override
	public List<LogDto> getloglist(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("user.getLogList",id);
	}

}
