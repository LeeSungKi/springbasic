package com.test.ch08;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.ImageDao;
import vo.ImageVo;


@Controller
public class HomeController {
	public static String VIEW_PATH = "/WEB-INF/views/";
	private ImageDao dao;
	
	@Autowired
	ServletContext application; // �� ��Ʈ�ѷ��� ��û�� Ŭ���̾�Ʈ�� application ��ü�� �ڵ� ��ϵ�
	
	@Autowired
	HttpSession session; // �� ��Ʈ�ѷ��� ��û�� Ŭ���̾�Ʈ�� session ��ü�� �ڵ� ��ϵ�
	
	@Autowired
	HttpServletRequest request; // �� ��Ʈ�ѷ��� ��û�� Ŭ���̾�Ʈ�� request ��ü�� �ڵ� ��ϵ�
			
	public void setDao(ImageDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = {"/", "/insert_form.do"})
	public String insert_form() {
		return  VIEW_PATH + "insert_form.jsp";
	}
	
	@RequestMapping("insert.do")
	public String upload(ImageVo vo) throws IOException { // title(String), image(File) 
		final String STORAGE_PATH = "/resources/images/"; // webapp/resources/images
		System.out.println(application);
		System.out.println(session);
		System.out.println(request);
		final String REAL_PATH = application.getRealPath(STORAGE_PATH);
		System.out.println("REAL_PATH : " + REAL_PATH );
		
		File dir = new File(REAL_PATH); 
		if(!dir.exists()) { // images ������ ���ٸ�
			dir.mkdirs(); // mkdirs() : ���丮 1�� ���� ( + �߰� ����� ���丮���� ��� ���� )
						  // mkdir() : ���丮 1�� ���� 
		}
		
		// �Ķ���ͷ� ���� �̹��� ������ ���� File ��ü ����
		MultipartFile file = vo.getImage();
		String filename = file.getOriginalFilename(); // �Ѿ�� ������ �̸� (aa.png)
		File newFile = new File(REAL_PATH, filename); // ~~~/images/aa.png
		if(newFile.exists()) { // �̹� ���� �̸��� ������ ������ �ִٸ� 
			// �̸� �ٲٱ�
			FileRenamePolicy fr = new DefaultFileRenamePolicy();
			filename = fr.rename(newFile).getName();
			// �� ���ε��� ������ �̸��� ���� + �� �̸��� filename�� ����
			newFile = new File(REAL_PATH, filename);
		}
		vo.setFilename(filename);
		newFile.createNewFile(); // ������ ���� ���ϰ�ü�� ���� ���Ϸ� ���� ( ũ�Ⱑ 0byte�� �������� �������)
		file.transferTo(newFile); // file(MultipartFile(�Ķ���ͷ� �Ѿ�� ����)�� �����͸� 
								  // newFile(���� ������ ����)�� ����
		request.setAttribute("resultVo", vo); // ���ȭ������ �����ֱ� ���� ���� vo�� attr�� ����

		dao.insert(vo); ///////////////////////////////////////////////////
		
		return VIEW_PATH + "insert_result.jsp"; // ����������� ������
	}
	
	@RequestMapping("/list.do")
	public String list() {
		// images ������ ��� �����̸�, ������, �̹��� ������ vo�� �����ϰ� 
		// arrayList�� ���
		// arrayList�� attr�� �߰��ϱ�
		List<ImageVo> list = dao.selectList();
		request.setAttribute("list", list);
		return VIEW_PATH + "list.jsp";
		// list.jsp : attr ���·� ���� arraylist�� ��� ����
	}
}











