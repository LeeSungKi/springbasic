package com.test.ch03;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.Service;

@Controller
public class BookController {
	private Service service;
	
	@RequestMapping("/bookView")
	public String list(Model model) {
		
		List list = service.getList();
		
		model.addAttribute("bList",list);
		
		return "BookList_view";
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	

}
