package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.Dao;
import service.BookService;
import service.Service;

@Controller
public class BookController {
	private Service service;
	public Service getService() {
		return service;
	}

	public void setService(Service s) {
		this.service = s;
	}
	
	@RequestMapping("/")   // localhost:9090/ch03/
	public String welcome(Model model) {
		List list = service.getList();
		model.addAttribute("bookList", list);
		// return "book_list"; // /WEB-INF/views/book_list.jsp (X)
		return "book/book_list"; //  /WEB-INF/views/book/book_list.jsp (O)
	}
	
}













