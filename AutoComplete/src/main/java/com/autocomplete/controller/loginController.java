package com.autocomplete.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autocomplete.DTO.User;
import com.autocomplete.service.loginService;

@Controller
public class loginController implements IloginContoller {

	loginService loginservice;

	public loginController() {
		loginservice = new loginService();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		model.addAttribute("loginform", new User());
		return "homepage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("loginForm") User user, HttpSession session, Model model) {
		System.out.println("POst");
		if (null == user)
			return "redirect:login";
		else if (user.getUserId() == null) {
			return "redirect:login";
		} else if (user.getPassword() == null) {
			return "redirect:login";
		} else { // TODO validate it if want
		}
		return "homepage";
	}
}
