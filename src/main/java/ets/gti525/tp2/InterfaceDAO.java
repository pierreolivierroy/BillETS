package ets.gti525.tp2;

import java.util.ArrayList;

public interface InterfaceDAO {
	
	/**
	 * Find an objet from an id
	 * @param id
	 * @return
	 */
	public Object find(int id);
	
	/**
	 * Find all objects of a given type
	 * @return
	 */
	public ArrayList find();
	
}