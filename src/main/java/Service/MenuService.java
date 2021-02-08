package Service;

import java.util.List;

import Entity.Menu;

public interface MenuService {

	
	List <Menu> getMenu();
	void addMenuItem(Menu menu);
	Menu getMenu(int id);
	void deleteMenuItem(int id);
	List<Menu> searchItem(String itemName);
	Menu getMenuItemByID(Integer id);

	
	
}
