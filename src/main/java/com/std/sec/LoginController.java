package com.std.sec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.std.sec.log.LogService;
import com.std.sec.user.UsersService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UsersService service;
	
	@Autowired
	LogService logService;
	
	@RequestMapping(value = "/login/loginForm.do", method = RequestMethod.GET)
	public String loginFor(Model model) {
		logger.info("Welcome Login Form!");
		
		return "login/loginForm";
	}
	
	@RequestMapping(value = "/login/accessDenied.do", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		logger.info("Welcome Access Denied!");
		
		return "login/accessDenied";
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {			
			try {
				logService.insertLog(auth.getName(), "2");
			} catch (Exception e) {		
			}
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login/signin.do", method = RequestMethod.GET)
	public String signin() {
		logger.info("Welcome signin!");
		
		return "login/signin";
	}
	
	@RequestMapping(value = "/login/resister.do", method = RequestMethod.POST)
	public String resgister(
			@RequestParam() String id,
			@RequestParam() String pw,
			Model model
			) {
		if(id==null || pw==null) {
			model.addAttribute("errmsg", "empty login info" );
			return "login/signin";
		}
		id=id.replace(" ", "");
		pw=pw.replace(" ", "");
		if(id.isEmpty() || pw.isEmpty()) {
			model.addAttribute("errmsg", "empty login info, please dont use blank " );
			return "login/signin";
		}		
		
		try {
			service.insertUser(id,pw);
		} catch (Exception e) {
			model.addAttribute("errmsg", "insert fail caused exception" );
			return "login/signin";
		}
		
		try {
			logService.insertLog(id, "0");
		} catch (Exception e) {		
			model.addAttribute("logerrmsg", "log failed caused exception" );
		}
		
		return "login/loginForm";
	}
}
