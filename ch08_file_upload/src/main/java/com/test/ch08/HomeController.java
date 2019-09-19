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
	ServletContext application; // 이 컨트롤러를 요청한 클라이언트의 application 객체가 자동 등록됨
	
	@Autowired
	HttpSession session; // 이 컨트롤러를 요청한 클라이언트의 session 객체가 자동 등록됨
	
	@Autowired
	HttpServletRequest request; // 이 컨트롤러를 요청한 클라이언트의 request 객체가 자동 등록됨
			
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
		if(!dir.exists()) { // images 폴더가 없다면
			dir.mkdirs(); // mkdirs() : 디렉토리 1개 생성 ( + 중간 경로의 디렉토리까지 모두 생성 )
						  // mkdir() : 디렉토리 1개 생성 
		}
		
		// 파라미터로 받은 이미지 파일을 위해 File 객체 생성
		MultipartFile file = vo.getImage();
		String filename = file.getOriginalFilename(); // 넘어온 파일의 이름 (aa.png)
		File newFile = new File(REAL_PATH, filename); // ~~~/images/aa.png
		if(newFile.exists()) { // 이미 같은 이름의 파일이 서버에 있다면 
			// 이름 바꾸기
			FileRenamePolicy fr = new DefaultFileRenamePolicy();
			filename = fr.rename(newFile).getName();
			// 새 업로드할 파일의 이름을 변경 + 그 이름을 filename에 저장
			newFile = new File(REAL_PATH, filename);
		}
		vo.setFilename(filename);
		newFile.createNewFile(); // 위에서 만든 파일객체를 실제 파일로 생성 ( 크기가 0byte인 빈파일이 만들어짐)
		file.transferTo(newFile); // file(MultipartFile(파라미터로 넘어온 파일)의 데이터를 
								  // newFile(새로 생성된 파일)에 복사
		request.setAttribute("resultVo", vo); // 결과화면으로 보여주기 위해 받은 vo를 attr로 저장

		dao.insert(vo); ///////////////////////////////////////////////////
		
		return VIEW_PATH + "insert_result.jsp"; // 결과페이지로 포워드
	}
	
	@RequestMapping("/list.do")
	public String list() {
		// images 폴더의 모든 파일이름, 글제목, 이미지 파일을 vo로 포장하고 
		// arrayList에 담기
		// arrayList를 attr로 추가하기
		List<ImageVo> list = dao.selectList();
		request.setAttribute("list", list);
		return VIEW_PATH + "list.jsp";
		// list.jsp : attr 형태로 받은 arraylist로 목록 생성
	}
}











