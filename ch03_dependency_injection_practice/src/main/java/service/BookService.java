package service;

import java.util.List;

import dao.BookDao;

public class BookService implements Service{
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	public List getList() {
		List list = bookDao.getList();
		return list;
	}
}







