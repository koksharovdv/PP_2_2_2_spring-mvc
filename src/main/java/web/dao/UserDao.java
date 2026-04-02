package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void edit(User user);

    List<User> listUsers();

    void delete(Long id);

    User  getUserById(Long id);
}
