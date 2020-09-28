package com.std.sec.log;

import java.util.HashMap;
import java.util.List;

public interface LogDao {
	public int insertLog(HashMap<String, Object> map) throws Exception;
	public List<LogDto> getloglist(String id) throws Exception;
}
