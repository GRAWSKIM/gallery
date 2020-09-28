package com.std.sec.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogDao logdao;
	@Override
	public int insertLog(String id,String type) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ID", id);
		map.put("TYPE", type);
		
		Date now= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		map.put("DATE", sdf.format(now));
				
		return logdao.insertLog(map);
	}
	@Override
	public List<LogDto> getloglist(String id) throws Exception {
		return logdao.getloglist(id);
	}

}
