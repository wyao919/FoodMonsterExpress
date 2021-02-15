package Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Entity.UserAccount;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

    SessionFactory sessionFactory;

    @Autowired
    public RegistrationDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveUser(UserAccount userAccount) {

        Session session = sessionFactory.getCurrentSession();
        session.save(userAccount);
    }

    @Override
    @Transactional
    public List<UserAccount> getUserName(String name) {

        Session session = sessionFactory.getCurrentSession();
        List<UserAccount> resultList = session.createQuery("From UserAccount where username = '" + name + "'").getResultList();

        return resultList;
    }

}
