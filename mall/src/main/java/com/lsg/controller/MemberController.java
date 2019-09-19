package com.lsg.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lsg.domain.MemberVo;
import com.lsg.service.MemberService;



@Controller
@RequestMapping("/member")
public class MemberController {
/*	Logger ��ü�� ������ ��, �ش� Ŭ������ Logger Ŭ������ �����ڿ� ������ �־��־���. 
	�̸� �̿��Ͽ� Log4j�� �˾Ƽ� � Ŭ�������� �αװ� ��µ� �������� �����ִ� �� 
	���� System.out.println()�� ��������� � Ŭ�������� ��µ� �α������� �˱Ⱑ ���� ������, 
	Log4j�� ����ؼ� ��� ��µ� �α������� �˼� �ֵ��� �Ͽ���.
	Logger : ����� �޽����� Appender�� �����Ѵ�.
    Appender : ���޵� �α׸� ��� ����� �� �����Ѵ�. (�ܼ� ���, ���� ���, DB ���� ��)
*/	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	//ȸ������ ���� �н����带 ��ȣȭ�Ҽ��ִ� maven�����ӿ�ũ�߰�����...
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	//ȸ������  get
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getSignup() throws Exception {
	 logger.info("get signup");
	}

	// ȸ�� ���� post
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(MemberVo vo) throws Exception {
		//INFO : ��� ���º���� ���� ������ �޽����� ��Ÿ����. 
	 logger.info("post signup");
	  
	 String inputPass = vo.getUserPass();
	 //�Է¹��� �н����带 BCrypt�� ��ȣȭ��Ű�� �ٽ� MemberVO�� �Ѱ��ִ� ���
	 String pass = passEncoder.encode(inputPass);
	 vo.setUserPass(pass);

	 service.signup(vo);

	 return "redirect:/";
	
	

}
}

