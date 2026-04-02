package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers(int count) {
        List<User> users = userDao.listUsers();
        if (count >= users.size()) {
            return users;
        }
        return users.subList(0, count);

    }
    @Override
    public void save(User user){
        userDao.add(user);
    }
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    @Override
    public void delete(Long id){
        userDao.delete(id);
    }



}

