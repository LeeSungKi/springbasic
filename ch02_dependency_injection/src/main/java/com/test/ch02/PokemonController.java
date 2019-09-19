package com.test.ch02;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.Service;

@Controller
//�̿� ���� Ŭ����, ����, �޼ҵ� � @xxx ���·� �پ��ִ� ���� 
//������̼�(Annotation)�̶�� �θ��ϴ�.
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
		System.out.println("PokemonController�� list() ����");
		
		List list = service.getList();
		// ��� ���� �����ϴ� �ڵ� pList = key , list = value
		model.addAttribute("pList",list);
		//���� �̸��� ����
		return "list_view"; // /WEB-INF/view + "list_view" + .jsp
	}
	//Controller �� servlet-context.xml �� ����ؾ� ������ Controller�� �ȴ�.
	
}
