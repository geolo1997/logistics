package pers.geolo.logisticsassistant.dao;

import pers.geolo.logisticsassistant.entity.User;

/**
 * @author 桀骜
 *
 * 操作TABLE User(用户表)
 */
public interface UserDAO {

    /**
     * 通过用户名和账号查找用户
     * @param username
     * @param password
     * @return
     */
    User getUser(String username, String password);

    /**
     * 通过id查找用户名
     * @param id
     * @return
     */
    String getUsername(int id);

    /**
     * 查找数据库中是否有用户名为username的用户
     * @param username
     * @return
     */
    boolean exist(String username);

    /**
     * 插入新用户
     * @param user
     */
    void save(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    void update(User user);
}
