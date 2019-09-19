package service;

import java.util.List;

import dao.Dao;

public class PokemonService implements Service{
	//모든 dao관장할수있다.
	private Dao dao;
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	public Dao getDao() {
		return dao;
	}
	
	//기본생성자
	public PokemonService() {
		System.out.println("--PokemonService 기본생성자--");
	}
	@Override
	public List getList() {
		List list = dao.getList();
		return list;
	}
	//service의 역할 : Dao 객체들을 가지고 있다가 필요할때 Dao의 메서드를 실행하는 역할
	

}
