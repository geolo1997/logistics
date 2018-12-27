package pers.geolo.LogisticsAssistant.dao;

import pers.geolo.LogisticsAssistant.entity.Cargo;
import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.utils.DAOUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CargoDAOImpl implements CargoDAO {

    @Override
    public boolean save(Cargo cargo) {
        // TODO
        return true;
    }

    @Override
    public List<Cargo> listCargo(User user) {
        DataBaseConnection connection = DataBaseConnection.getInstance();
        String SQL = "SELECT CargeInformation.* " +
                "FROM CargeInformation, [User] " +
                "WHERE CargeInformation.shipperId = User.id AND " +
                "User.name = ?";
        PreparedStatement statement;
        ResultSet resultSet;
        List<Cargo> cargoList = null;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, user.getUsername());
            resultSet = statement.executeQuery();
            cargoList = (List<Cargo>) DAOUtils.getList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargoList;
    }

    @Override
    public Cargo getCargo(int id) {
        return null;
    }

    @Override
    public List<Cargo> listAllCargo() {
        return null;
    }
}
