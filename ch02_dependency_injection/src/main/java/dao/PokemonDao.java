package dao;

import java.util.ArrayList;
import java.util.List;

import vo.PokemonVo;

public class PokemonDao implements Dao{

	@Override
	public int insert() {
		return 0;
	}

	@Override
	public List getList() {
		//(DB�� �����ߴٰ� ����..)
		ArrayList<PokemonVo> list = new ArrayList<PokemonVo>();
		list.add(new PokemonVo("ġ�ڸ�Ÿ",10,10000));
		list.add(new PokemonVo("ġ��",10,1456000));
		list.add(new PokemonVo("�ڸ�Ÿ",50,100));
		list.add(new PokemonVo("Ÿ",40,10460));
		list.add(new PokemonVo("��Ÿ",30,1500));
		return list;
	}

	@Override
	public int delete() {
		return 0;
	}

	@Override
	public int update() {
		return 0;
	}
	
}
