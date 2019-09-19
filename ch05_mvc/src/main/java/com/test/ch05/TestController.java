package com.test.ch05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * @Component (부모)
 * 	 @Controller (자식)
 *   @Service (자식)
 *   @Repository (자식)
 *   
 * ==> servlet-context.xml 에서 
 * <context:component-scan> 이 태그로 오토디텍팅이 가능한 요소
 * 저 위의 1개가 선언된 클래스는 서버 load 중에 자동 생성됨 (싱글톤 객체로 생성)
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
//		request.setAttribute("msg", "건네받은 num은 " + num + "입니다.");
//		return VIEW_PATH + "result2.jsp";
//	}
	
//	@RequestMapping("/test02.do")
//	public String b(int num, Model model) {
//		model.addAttribute("msg", "건네받은 num은 " + num + "입니다.");
//		return VIEW_PATH + "result2.jsp";
//	}
	
	
	@RequestMapping(value = {"/test02.do", "/test03.do"})
	//public ModelAndView b(int num) {//num이라는 param이 들어오면 자동으로 num변수에 대입
		public ModelAndView b(@RequestParam("num")int num1) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "건네받은 num은 " + num1 + "입니다.");
		mv.setViewName(VIEW_PATH +"result2.jsp");
		return mv;
		/*
		 * < ModelAndView 클래스 >
		 * - Model과 동일하게 attribute를 저장할 수 있는 클래스 
		 * 	(addObject())
		 * - 차이 : ModelAndView 는 '포워드할 view' 정보를 저장할 수 있음
		 */
	}
	
	@RequestMapping("/insert_pokemon")
	public String insertPokemon() {
		return VIEW_PATH + "insert_pokemon.jsp";
		
	}
	@RequestMapping("/result_pokemon1")
	public ModelAndView a(@RequestParam("name")String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("poName","건네받은 이름은 "+name+" 입니다.");
		mv.setViewName(VIEW_PATH+"result_pokemon1.jsp");
		return mv;
	}
	/*@RequestMapping("/result_pokemon1")
	public String resultPokemon1(String name, Model m) {
		//name 파라미터를 m 에담아서 result_pokemon1.jsp에전달
		m.addAttribute("msg","포켓몬이름은"+name+"입니다.");
	}*/
	@RequestMapping("/result_pokemon2")
	public String resultPokemon2(PokemonVo vo, Model m) {
		m.addAttribute("pName",vo.getName());
		m.addAttribute("pLevel",vo.getLevel());
		m.addAttribute("pHp",vo.getHp());
		return VIEW_PATH + "result_pokemon2.jsp";
	}
	
}





















