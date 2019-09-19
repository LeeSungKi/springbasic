package com.test.ch06;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class MyController {
	
	DeptDao dao;
	
	private final String VIEW_PATH = "/WEB-INF/views/";
	
	public MyController() {
		
	}
	public MyController(DeptDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = {"/list.do", "/"})
	public String list(Model model) {
		List<DeptVo> list = dao.selectList();
		model.addAttribute("list",list);
		return  VIEW_PATH +  "dept_list.jsp";// /WEB-INF/views/dept_list.jsp
	}
	
	@RequestMapping("/write_view.do")
	public String writeView() {
		return VIEW_PATH +"dept_write.jsp";
	}
	@RequestMapping("/write.do")
	public String write(DeptVo vo) {
		dao.insert(vo);
		return"list.do";
	}
	@RequestMapping("/delete.do")
	public String delete(int no) {
		dao.delete(no);
		return "list.do";
	}
	
	
}
