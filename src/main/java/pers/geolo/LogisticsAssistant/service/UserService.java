package pers.geolo.LogisticsAssistant.service;

import pers.geolo.LogisticsAssistant.dao.CargoInformationDAO;
import pers.geolo.LogisticsAssistant.dao.DAOFactory;
import pers.geolo.LogisticsAssistant.dao.UserDAO;
import pers.geolo.LogisticsAssistant.entity.CargoInformation;
import pers.geolo.LogisticsAssistant.entity.User;

import java.util.List;

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

    public boolean register(User user) {

        if (!userDAO.existUsername(user.getUsername())) {
            userDAO.save(user);
            return true;
        } else { // 用户已存在
            return false;
        }
    }

    public boolean login(User user) {
        return userDAO.getUser(user) != null;
    }

    public boolean update(User user) {
        return userDAO.update(user);
    }

    public void logout(User user) {
    }


}
