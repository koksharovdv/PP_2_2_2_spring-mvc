package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers(int count);

    void save(User user);

    void edit(User user);

    User getUserById(Long id);

    void delete(Long id);
}
