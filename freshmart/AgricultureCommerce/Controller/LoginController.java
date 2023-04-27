package com.rutikProject.AgricultureCommerce.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rutikProject.AgricultureCommerce.Entiy.User;
import com.rutikProject.AgricultureCommerce.Service.UserService;

@Controller
public class LoginController {
	
	
	@Autowired
	private UserService uService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String addRecord(@RequestParam("email") String username, 
			@RequestParam("password") String password, HttpServletRequest request , Model model)
	{
			//System.out.println("Email :"+username + " Pass : "+ password );	
			User user = uService.findByEmail(username);
			if(user == null)
			{
				String msg ="User not Found ";
				model.addAttribute("loginMsg", msg);
				return "user-login";
			}
			else {
				if(password.equals(user.getPassword()))
				{
					
					model.addAttribute("userName", user.getfname());
					return "index";
				}
			}
			
			
			model.addAttribute("loginMsg", "Username & Password is not valid");
			return "user-login";
	}
}
