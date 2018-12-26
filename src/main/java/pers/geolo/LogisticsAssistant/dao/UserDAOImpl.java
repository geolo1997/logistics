package pers.geolo.LogisticsAssistant.dao;

import com.sun.org.apache.bcel.internal.generic.RET;
import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.utils.DAOUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User getUser(User user) {
        DataBaseConnection connection = DataBaseConnection.getInstance();
        String SQL = "SELECT * FROM User WHERE username = ?, password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();
            List<User> userList = (List<User>) DAOUtils.getList(resultSet);
            if (userList.size() > 0) {
                return userList.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        // TODO 关闭连接
    }

    @Override
    public boolean existUsername(String username) {
        DataBaseConnection connection = DataBaseConnection.getInstance();
        String SQL = "SELECT * FROM User WHERE username = ?";
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            List<User> userList = (List<User>) DAOUtils.getList(resultSet);
            if (userList.size() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            connection.close();
        }
        return false;
        // TODO 关闭连接
    }

    @Override
    public void save(User user) {
        DataBaseConnection connection = DataBaseConnection.getInstance();
        String SQL = "INSERT INTO User(username, password, email, userType) VALUES(?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement = DAOUtils.setBean(statement, user);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(User user) {
        DataBaseConnection connection = DataBaseConnection.getInstance();
        // TODO 更新？
        String SQL = "UPDATE User SET password = ?";
        PreparedStatement statement;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            DAOUtils.setBean(statement, user);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
