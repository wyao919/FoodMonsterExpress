package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.Menu;

@Repository
public class MenuDAOImpl implements MenuDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public MenuDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Menu> getMenu() {

        Session session = sessionFactory.getCurrentSession();
        List<Menu> menuList = session.createQuery("From Menu").getResultList();
        System.out.println(menuList);

        for (Menu temp : menuList) {
            System.out.println(temp);
        }

        System.out.println(session);
        return menuList;
    }

    @Override
    @Transactional
    public void addMenuItem(Menu menu) {

        Session session = sessionFactory.getCurrentSession();

        // if you do not use cascading you have to do it this way.
//		MenuDetail menuDetail = menu.getMenuDetail();
//		session.save(menuDetail);
        session.saveOrUpdate(menu);
    }

    @Override
    @Transactional
    public Menu getMenu(int id) {

        Session session = sessionFactory.getCurrentSession();
        Menu menu = session.get(Menu.class, id);
        System.out.println("id is = " + id);
        return menu;
    }

    @Override
    @Transactional
    public void deleteMenuItem(int id) {

        Session session = sessionFactory.getCurrentSession();
        Menu menu = session.get(Menu.class, id);
        session.delete(menu);

    }

    @Override
    @Transactional
    public List<Menu> searchItem(String itemName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;

        if (itemName != null && itemName.trim().length() > 0) {
            query = session.createQuery("From Menu where item Like :itemN");
            query.setParameter("itemN", "%" + itemName + "%");

        } else {

            query = session.createQuery("From Menu");

        }
        List<Menu> resultList = query.getResultList();

        return resultList;
    }

    @Override
    @Transactional
    public Menu getMenuItemByID(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Menu menuId = session.get(Menu.class, id);

        return menuId;
    }

}
