package dao;

import java.util.ArrayList;
import java.util.List;

import vo.BookVo;

public class BookDao implements Dao{

	@Override
	public List getList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		list.add(new BookVo("å����1", 1000, "�Ҽ�"));
		list.add(new BookVo("å����2", 12000, "�ڹ�"));
		list.add(new BookVo("å����3", 10000, "��"));
		list.add(new BookVo("å����4", 5000, "��"));
		return list;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
