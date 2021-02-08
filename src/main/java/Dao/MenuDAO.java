package Dao;

import java.util.List;

import Entity.Menu;

public interface MenuDAO {
	
	Menu getMenuItemByID(Integer id);

	List<Menu> getMenu();

	void addMenuItem(Menu menu);

	Menu getMenu(int id);

	void deleteMenuItem(int id);

	List<Menu> searchItem(String itemName);

}
