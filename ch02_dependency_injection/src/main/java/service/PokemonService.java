package service;

import java.util.List;

import dao.Dao;

public class PokemonService implements Service{
	//��� dao�����Ҽ��ִ�.
	private Dao dao;
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	public Dao getDao() {
		return dao;
	}
	
	//�⺻������
	public PokemonService() {
		System.out.println("--PokemonService �⺻������--");
	}
	@Override
	public List getList() {
		List list = dao.getList();
		return list;
	}
	//service�� ���� : Dao ��ü���� ������ �ִٰ� �ʿ��Ҷ� Dao�� �޼��带 �����ϴ� ����
	

}
