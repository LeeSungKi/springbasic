package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MyDao {
	
	public List<String> selectList(){
		//DB ��ȸ�ߴٰ� ����..
		List list = new ArrayList<String>();
		list.add("��ī��");
		list.add("������");
		list.add("���̸�");
		list.add("����");
		return list;
	}

}
