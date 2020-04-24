package pers.geolo.logistics.dao.impl;

import pers.geolo.logistics.dao.DataBaseConnection;
import pers.geolo.logistics.dao.UserDAO;
import pers.geolo.logistics.entity.User;
import pers.geolo.logistics.util.DAOUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public User getUser(String username, String password) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM User WHERE username = ? AND password = ?";
        User user = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = DAOUtils.getBean(resultSet, User.class);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return user;
    }

    @Override
    public String getUsername(int id) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM User WHERE id = ?";
        User user = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = DAOUtils.getBean(resultSet, User.class);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return user.getUsername();
    }

    @Override
    public boolean exist(String username) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM User WHERE username = ?";
        int cnt = 0;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cnt++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return cnt > 0;
    }

    @Override
    public void save(User user) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "INSERT INTO User(username, password, email,userTypeId) " +
                "VALUES(?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getUserType().ordinal());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "UPDATE User SET password=?, realName=?, email=?, telephone=?, " +
                "userTypeId=?," +
                " vehicleTypeId=?, transportableTypeId=?, licensePlateNumber=?, address=? WHERE " +
                "id =?";
        PreparedStatement statement;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getRealName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getTelephone());
            statement.setInt(5, user.getUserType().ordinal());
            statement.setInt(6, user.getVehicleType().ordinal());
            statement.setInt(7, user.getTransportableType().ordinal());
            statement.setString(8, user.getLicensePlateNumber());
            statement.setString(9, user.getAddress());
            statement.setString(10, String.valueOf(user.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }
}
