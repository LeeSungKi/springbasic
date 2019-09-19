package com.test.ch11;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.ch11.service.MyService;


@Controller
public class HomeController {
	
	@Autowired
	private MyService service;
	
	@RequestMapping("/")
	public String home() {
		service.test();
		
		return "home";
	}
	
	
	
}
