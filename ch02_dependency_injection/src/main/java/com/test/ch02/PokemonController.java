package com.test.ch02;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.Service;

@Controller
//이와 같이 클래스, 변수, 메소드 등에 @xxx 형태로 붙어있는 것을 
//어노테이션(Annotation)이라고 부릅니다.
public class PokemonController {
	private Service service;

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping("/pokView")
	public String list( Model model) {
		System.out.println("PokemonController의 list() 실행");
		
		List list = service.getList();
		// 뷰로 값을 전달하는 코드 pList = key , list = value
		model.addAttribute("pList",list);
		//뷰의 이름을 리턴
		return "list_view"; // /WEB-INF/view + "list_view" + .jsp
	}
	//Controller 는 servlet-context.xml 에 등록해야 진정한 Controller가 된다.
	
}
