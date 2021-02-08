package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.MenuDAO;
import Entity.Menu;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;

	@Override
	public List<Menu> getMenu() {

		// DAO CALL from SERVICE Layer MUST autowire DAO class to do this.
		List<Menu> menuList = menuDAO.getMenu();

		// Take the menu obj and do your business opperation

		return menuList;
	}

	@Override
	public void addMenuItem(Menu menu) {

		menuDAO.addMenuItem(menu);

	}

	@Override
	public Menu getMenu(int id) {
		System.out.println("id = " + id);
		Menu menu = menuDAO.getMenu(id);

		return menu;
	}

	@Override
	public void deleteMenuItem(int id) {

		menuDAO.deleteMenuItem(id);

	}

	@Override
	public List<Menu> searchItem(String itemName) {

		List<Menu> searchItems = menuDAO.searchItem(itemName);
		return searchItems;
	}

	@Override
	public Menu getMenuItemByID(Integer id) {

		Menu menuItemByID = menuDAO.getMenuItemByID(id);
		return menuItemByID;
	}

}
