package dao;

import java.util.ArrayList;
import java.util.List;

import vo.BookVo;

public class BookDao implements Dao{

	@Override
	public List getList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		list.add(new BookVo("氓力格1", 1000, "家汲"));
		list.add(new BookVo("氓力格2", 12000, "内雇"));
		list.add(new BookVo("氓力格3", 10000, "稠巩"));
		list.add(new BookVo("氓力格4", 5000, "矫"));
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
