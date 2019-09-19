package service;

import java.util.List;

import dao.Dao;

public class BookService implements Service{
	
	private Dao dao;

	@Override
	public List getList() {
		
		List list = dao.getList();
		
		return list;
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	

}
