package cn.bdqn.service;

import cn.bdqn.pojo.User;

import java.util.List;

public interface UserService {

    List<User> find();

    void addUser(String username, String password);

    User getUserById(int id);

    void update(User user);

    void delete(int id);
}
