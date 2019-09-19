package com.test.ch05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * @Component (�θ�)
 * 	 @Controller (�ڽ�)
 *   @Service (�ڽ�)
 *   @Repository (�ڽ�)
 *   
 * ==> servlet-context.xml ���� 
 * <context:component-scan> �� �±׷� ����������� ������ ���
 * �� ���� 1���� ����� Ŭ������ ���� load �߿� �ڵ� ������ (�̱��� ��ü�� ����)
 */
@Controller
public class TestController {
	
	private static final String VIEW_PATH = "/WEB-INF/views/";
	
	@RequestMapping("/")
	public String welcome() {
		return VIEW_PATH + "home.jsp";
	}
	
//	@RequestMapping("/test01.do")
//	public String a(HttpServletRequest request) {
//		PokemonVo vo = new PokemonVo();
//		vo.setName(request.getParameter("name"));
//		vo.setLevel( Integer.parseInt(request.getParameter("level")) );
//		vo.setHp( Integer.parseInt(request.getParameter("hp")) );
//		
//		String clientIp = request.getRemoteAddr();
//		
//		request.setAttribute("vo", vo);
//		request.setAttribute("ip", clientIp);
//		return VIEW_PATH + "result.jsp"; // /WEB-INF/views  + home + .jsp
//	}
	
	@RequestMapping("/test01.do")
	public String a(PokemonVo vo, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		request.setAttribute("vo", vo);
		request.setAttribute("ip", clientIp);
		return VIEW_PATH + "result.jsp"; // /WEB-INF/views  + home + .jsp
	}
	
//	@RequestMapping("/test02.do")
//	public String b(int num, HttpServletRequest request) {
//		request.setAttribute("msg", "�ǳ׹��� num�� " + num + "�Դϴ�.");
//		return VIEW_PATH + "result2.jsp";
//	}
	
//	@RequestMapping("/test02.do")
//	public String b(int num, Model model) {
//		model.addAttribute("msg", "�ǳ׹��� num�� " + num + "�Դϴ�.");
//		return VIEW_PATH + "result2.jsp";
//	}
	
	
	@RequestMapping(value = {"/test02.do", "/test03.do"})
	//public ModelAndView b(int num) {//num�̶�� param�� ������ �ڵ����� num������ ����
		public ModelAndView b(@RequestParam("num")int num1) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "�ǳ׹��� num�� " + num1 + "�Դϴ�.");
		mv.setViewName(VIEW_PATH +"result2.jsp");
		return mv;
		/*
		 * < ModelAndView Ŭ���� >
		 * - Model�� �����ϰ� attribute�� ������ �� �ִ� Ŭ���� 
		 * 	(addObject())
		 * - ���� : ModelAndView �� '�������� view' ������ ������ �� ����
		 */
	}
	
	@RequestMapping("/insert_pokemon")
	public String insertPokemon() {
		return VIEW_PATH + "insert_pokemon.jsp";
		
	}
	@RequestMapping("/result_pokemon1")
	public ModelAndView a(@RequestParam("name")String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("poName","�ǳ׹��� �̸��� "+name+" �Դϴ�.");
		mv.setViewName(VIEW_PATH+"result_pokemon1.jsp");
		return mv;
	}
	/*@RequestMapping("/result_pokemon1")
	public String resultPokemon1(String name, Model m) {
		//name �Ķ���͸� m ����Ƽ� result_pokemon1.jsp������
		m.addAttribute("msg","���ϸ��̸���"+name+"�Դϴ�.");
	}*/
	@RequestMapping("/result_pokemon2")
	public String resultPokemon2(PokemonVo vo, Model m) {
		m.addAttribute("pName",vo.getName());
		m.addAttribute("pLevel",vo.getLevel());
		m.addAttribute("pHp",vo.getHp());
		return VIEW_PATH + "result_pokemon2.jsp";
	}
	
}





















