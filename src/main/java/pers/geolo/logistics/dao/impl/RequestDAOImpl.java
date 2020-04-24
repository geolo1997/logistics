package pers.geolo.logistics.dao.impl;

import pers.geolo.logistics.dao.DataBaseConnection;
import pers.geolo.logistics.dao.RequestDAO;
import pers.geolo.logistics.entity.Request;
import pers.geolo.logistics.util.DAOUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RequestDAOImpl implements RequestDAO {

    public void save(Request request) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "INSERT INTO Request(driverId,cargoId,requestTime) VALUES(?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(request.getDriverId()));
            statement.setString(2, String.valueOf(request.getCargoId()));
            statement.setString(3, DAOUtils.formatDate(request.getRequestTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }

    @Override
    public List<Request> listRequestOfDriver(int driverId) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM Request WHERE driverId = ?";
        List<Request> requestList = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(driverId));
            ResultSet resultSet = statement.executeQuery();
            requestList = DAOUtils.getList(resultSet, Request.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return requestList;
    }

    @Override
    public List<Request> listRequestOfCargo(int cargoId) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM Request WHERE cargoId = ?";
        List<Request> requestList = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(cargoId));
            ResultSet resultSet = statement.executeQuery();
            requestList = DAOUtils.getList(resultSet, Request.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return requestList;
    }
}
