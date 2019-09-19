package dao;

import java.util.ArrayList;
import java.util.List;

import vo.BookVo;

public class BookDao implements Dao{

	@Override
	public List getList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
	
		list.add(new BookVo("노인과바다",2000,"소설"));
		list.add(new BookVo("룬의아이들",200,"판타지"));
		list.add(new BookVo("진달래꽃",25500,"시"));
		list.add(new BookVo("뀨",10000,"야설"));
		return list;
	}

	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
