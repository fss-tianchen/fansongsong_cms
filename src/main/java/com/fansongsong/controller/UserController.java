package com.fansongsong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping(value="hello", method=RequestMethod.GET)
	public String list(HttpServletRequest request) {
		request.setAttribute("hello", "hello");
		return "user/list";
	}
}
