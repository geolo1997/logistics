package pers.geolo.LogisticsAssistant.dao;

import pers.geolo.LogisticsAssistant.entity.User;

public interface UserDAO extends BaseDAO {

    User getUser(User user);

    boolean existUsername(String username);

    void save(User user);

    boolean update(User user);
}
