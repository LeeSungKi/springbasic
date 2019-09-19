package com.test.ch07;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.MyCommon;
import dao.VisitDao;
import vo.VisitVo;

@Controller
public class MyController {
	private VisitDao dao;
	public void setDao(VisitDao d) {
		dao = d;
	}
	
	@RequestMapping(value = {"/", "/list.do"})
	public String list(Model model) {
		model.addAttribute("list", dao.selectList());
		return MyCommon.VIEW_PATH + "visit_list" + MyCommon.VIEW_SUFFIX; 
		
	}
	@RequestMapping("insert_form.do")
	public String insert_form(HttpServletRequest request) {
		//String ip = request.getRemoteAddr();//Ŭ���̾�Ʈ��  ip
		return MyCommon.VIEW_PATH + "visit_insert_form"+MyCommon.VIEW_SUFFIX;
	}
	@RequestMapping("insert.do")
	public String insert(HttpServletRequest request, VisitVo vo) {//vo : name,content,pwd�ڵ���
		String ip =request.getRemoteAddr();
		vo.setIp(ip);
		//mybatis ����#{}�� ������ ���� ���� \n �ȵ� �� ����
		//\n ==> <br>�� ��ü
		String content = vo.getContent();
		content = content.replace("\n", "<br>");
		vo.setContent(content);
		
		dao.insert(vo); 
		return "redirect : list.do"; //sendRedirect("list.do");
	}
	@RequestMapping("/modify_form.do")
	public String modify_form(int idx, Model model) {
		VisitVo vo = dao.selectOne(idx); 
		model.addAttribute("vo", vo); 
		return MyCommon.VIEW_PATH + "visit_modify_form" + MyCommon.VIEW_SUFFIX; 
	}
	@RequestMapping("/modify.do")
	@ResponseBody // return ��(���⼭��  yes/no)�� �������� �������� �ν����� ����
				  // response �޽����� body�� ä�� �κ����� �ν��϶�
	public String modify(VisitVo vo, HttpServletRequest request) {
		// (name,content,pwd,idx prameter���� vo�� �ڵ����� ������ ����)
		String ip = request.getRemoteAddr();//Ŭ���̾�Ʈ�� ip
		vo.setIp(ip);
		
		String content = vo.getContent();
		content = content.replace("\n", "<br>");
		vo.setContent(content);
		
		boolean result = dao.update(vo) == 1;
		if(result) {
			return "yes";
		}
		return "no";
	}
	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(int idx) {
		
		boolean result = dao.delete(idx) == 1;
		if(result) {//��������
			return "yes";
		}else {//��������
			return "no";
		}
		
	}
}






