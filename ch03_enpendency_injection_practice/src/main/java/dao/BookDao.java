package dao;

import java.util.ArrayList;
import java.util.List;

import vo.BookVo;

public class BookDao implements Dao{

	@Override
	public List getList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
	
		list.add(new BookVo("���ΰ��ٴ�",2000,"�Ҽ�"));
		list.add(new BookVo("���Ǿ��̵�",200,"��Ÿ��"));
		list.add(new BookVo("���޷���",25500,"��"));
		list.add(new BookVo("��",10000,"�߼�"));
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
