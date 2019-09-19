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
		//(DB에 접근했다고 가정..)
		ArrayList<PokemonVo> list = new ArrayList<PokemonVo>();
		list.add(new PokemonVo("치코리타",10,10000));
		list.add(new PokemonVo("치코",10,1456000));
		list.add(new PokemonVo("코리타",50,100));
		list.add(new PokemonVo("타",40,10460));
		list.add(new PokemonVo("리타",30,1500));
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
