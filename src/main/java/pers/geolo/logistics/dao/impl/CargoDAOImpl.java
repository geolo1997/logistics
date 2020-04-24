package pers.geolo.logistics.dao.impl;

import pers.geolo.logistics.dao.CargoDAO;
import pers.geolo.logistics.dao.DataBaseConnection;
import pers.geolo.logistics.entity.Cargo;
import pers.geolo.logistics.util.DAOUtils;
import pers.geolo.logistics.constant.CargoState;
import pers.geolo.logistics.constant.CargoType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CargoDAOImpl implements CargoDAO {

    @Override
    public boolean save(Cargo cargo) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "INSERT INTO Cargo(shipperId,cargoName,cargoTypeId,origin," +
                "destination,distance,freight,publishTime,cargoStateId) VALUES(?, ?, ?, ?, ?, ?," +
                " ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(cargo.getShipperId()));
            statement.setString(2, cargo.getCargoName());
            statement.setString(3, String.valueOf(cargo.getCargoType().ordinal()));
            statement.setString(4, cargo.getOrigin());
            statement.setString(5, cargo.getDestination());
            statement.setString(6, String.valueOf(cargo.getDistance()));
            statement.setString(7, String.valueOf(cargo.getFreight()));
            statement.setString(8, DAOUtils.formatDate(cargo.getPublishTime()));
            statement.setString(9, String.valueOf(cargo.getCargoState().ordinal()));
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO
        return true;
    }

    @Override
    public void update(int cargoId, int driverId, CargoState cargoState, Date dealTime) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "UPDATE Cargo SET driverId = ? ,cargoStateId = ?, dealTime = ? WHERE id = ? ";
        PreparedStatement statement;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(driverId));
            statement.setString(2, String.valueOf(cargoState.ordinal()));
            statement.setString(3, DAOUtils.formatDate(dealTime));
            statement.setString(4, String.valueOf(cargoId));
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cargo> listCargo(int shipperId) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM Cargo WHERE shipperId = ?";
        List<Cargo> cargoList = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(shipperId));
            ResultSet resultSet = statement.executeQuery();
            cargoList = DAOUtils.getList(resultSet, Cargo.class);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargoList;
    }

    @Override
    public Cargo getCargo(int cargoId) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM Cargo WHERE id = ?";
        Cargo cargo = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(cargoId));
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            cargo = DAOUtils.getBean(resultSet, Cargo.class);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargo;
    }

    @Override
    public List<Cargo> listAllCargo() {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM Cargo";
        List<Cargo> cargoList = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            ResultSet resultSet = statement.executeQuery();
            cargoList = DAOUtils.getList(resultSet, Cargo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return cargoList;
    }

    @Override
    public List<Cargo> listDealCargo(int driverId) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM Cargo WHERE driverId = ?";
        List<Cargo> cargoList = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, String.valueOf(driverId));
            ResultSet resultSet = statement.executeQuery();
            cargoList = DAOUtils.getList(resultSet, Cargo.class);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargoList;
    }

    @Override
    public List<Cargo> listCargoBy(String origin, String destination, CargoType cargoType) {
        DataBaseConnection connection = new DataBaseConnection();
        String SQL = "SELECT * FROM Cargo WHERE origin like ? AND destination like ? AND cargoTypeId = ?";
        List<Cargo> cargoList = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1,  "%" + origin + "%");
            statement.setString(2, "%" + destination + "%");
            statement.setString(3, String.valueOf(cargoType.ordinal()));
            ResultSet resultSet = statement.executeQuery();
            cargoList = DAOUtils.getList(resultSet, Cargo.class);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargoList;
    }
}
