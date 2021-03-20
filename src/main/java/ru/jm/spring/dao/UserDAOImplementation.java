package ru.jm.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.jm.spring.model.User;

import javax.management.Query;
import javax.persistence.TypedQuery;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImplementation implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

//    private static int USER_COUNT_ID;
//    private List<User> users;
//
//    {
//        users = new ArrayList<>();
//
//        users.add(new User(++USER_COUNT_ID, "Tom", "Jons",25));
//        users.add(new User(++USER_COUNT_ID, "Ilon", "Musk",55));
//        users.add(new User(++USER_COUNT_ID, "Ivan", "Dub",18));
//        users.add(new User(++USER_COUNT_ID, "Mila", "Tyo",33));
//    }

//    public List<User> getAllUsers() {
//        return users;
//    }
    @Override

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> query = session.createQuery("from User", User.class);
        List<User> allUsers = query.getResultList();

        return allUsers;
    }

    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;

        //return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
//        user.setId(++USER_COUNT_ID);
//        users.add(user);
    }

//    public void updateUser(int id, User updatedUser) {
//        User userToBeUpdated = getUserById(id);
//
//        userToBeUpdated.setFirstName(updatedUser.getFirstName());
//        userToBeUpdated.setLastName(updatedUser.getLastName());
//        userToBeUpdated.setAge(updatedUser.getAge());
//
//    }

    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> query = session.createQuery("delete from User " + "where  id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();

        //users.removeIf(p -> p.getId() == id);
    }

}
