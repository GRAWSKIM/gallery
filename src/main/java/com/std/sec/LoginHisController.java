package com.std.sec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.std.sec.log.LogDto;
import com.std.sec.log.LogService;

@Controller
public class LoginHisController {
	private static final Logger logger = LoggerFactory.getLogger(LoginHisController.class);

	@Autowired
	private LogService logservice;
	
	@RequestMapping(value = "/loginhis/loginhistory.do", method = RequestMethod.GET)
	public String getloginlog(Model model) throws Exception {
		logger.info("Welcome getloginlog");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<LogDto> list =logservice.getloglist(auth.getName());
		
		model.addAttribute("LIST", list);
		
		return "loginhis/loginhistory";
	}
}
