package dao;

import java.util.List;

public interface Dao {
	List getList();
	boolean insert();
	boolean update();
	boolean delete();
	String read();
}
