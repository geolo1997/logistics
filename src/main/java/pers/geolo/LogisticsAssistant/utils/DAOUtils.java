package pers.geolo.LogisticsAssistant.utils;

import pers.geolo.LogisticsAssistant.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUtils {

    public static List<?> getList(ResultSet resultSet) {
        List<User> userList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = (User) getBean(resultSet);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object getBean(ResultSet resultSet) {
        User user = new User();
        try {
            user.setUsername(resultSet.getString(1));
            user.setPassword(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            // TODO 类型对不上！！！
            user.setUserType(resultSet.getString(4));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static  PreparedStatement setBean(PreparedStatement statement ,User user) throws SQLException {
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getUserType().toString());
        return statement;
    }
}
