package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserService {


    @Autowired
    private UserDao userDao;
    public List<User> getUsers(int count) {
        List<User> users = userDao.listUsers();
        if (count >= users.size()) {
            return users;
        }
        return users.subList(0, count);

    }
    public void save(User user){
        userDao.add(user);
    }
    public void edit(User user) {
        userDao.edit(user);
    }
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    public void delete(Long id){
        userDao.delete(id);
    }



}

