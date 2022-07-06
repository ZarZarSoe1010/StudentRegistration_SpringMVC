package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import persistant.dao.UserDAO;
import persistant.dto.UserResponseDTO;
@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDao;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() { 
		return "LGN001";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,@RequestParam("password") String password,
			HttpSession session,ModelMap model) {	
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String currentDate = formatter.format(date);
		
		ArrayList<UserResponseDTO> userResList = userDao.selectAllUser();
		for (UserResponseDTO userInfo : userResList) {
			if (userInfo.getUid().equals(id) && userInfo.getPassword().equals(password)) {
				session.setAttribute("userInfo", userInfo);
				session.setAttribute("date", currentDate);

				
			} else {
				model.addAttribute("msg", "ID and password do not match");
				session.setAttribute("data",userInfo);
				return "/LGN001";
			}		
	}
		return "/MNU001";	
}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(ModelMap model, HttpSession session) {
		session.removeAttribute("userInfo");
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String showWelcome() {
		return "MNU001";
	}
	
	
}
