package com.std.sec.log;

import java.util.List;

public interface LogService {
	public int insertLog(String id, String type) throws Exception;	
	
	public List<LogDto> getloglist(String id) throws Exception;
}
