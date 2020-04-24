package pers.geolo.logistics.service;

import pers.geolo.logistics.dao.DAOFactory;
import pers.geolo.logistics.dao.UserDAO;
import pers.geolo.logistics.entity.User;

public class UserService {

    private UserDAO userDAO;

    private UserService() {
        userDAO = DAOFactory.getInstance().getDAO("UserDAO");
    }

    private static class Holder {
        private static final UserService INSTANCE = new UserService();
    }

    // 单例模式
    public static UserService getInstance() {
        return Holder.INSTANCE;
    }

    public User register(User user) {
        if (!userDAO.exist(user.getUsername())) {
            userDAO.save(user);
            return userDAO.getUser(user.getUsername(), user.getPassword());
        } else { // 用户已存在
            return null;
        }
    }

    public User login(String username, String password) {
        return userDAO.getUser(username, password);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void logout(User user) {
    }

    public String getUsername(int id) {
        return userDAO.getUsername(id);
    }


}
