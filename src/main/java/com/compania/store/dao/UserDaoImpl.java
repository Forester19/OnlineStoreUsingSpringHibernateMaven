package main.java.com.compania.store.dao;

import main.java.com.compania.store.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sun.nio.cs.US_ASCII;

import java.util.List;

/**
 * Created by Владислав on 31.01.2018.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private Logger logger = Logger.getRootLogger();

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. User: " + user.getNickname());

    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated. User: " + user.getNickname());

    }

    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);

        if (user != null) {
            session.remove(user);
            logger.info("User successfully deleted. User: " + user.getNickname());
        } else {
            logger.info("User unsuccessfully deleted. User is not detected! ");
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            logger.info("User successfully detected. User: " + user.getNickname());
            return user;
        } else {
            logger.info("User unsuccessfully detected. ");
            return null;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from Users").list();

        return userList;
    }
}
