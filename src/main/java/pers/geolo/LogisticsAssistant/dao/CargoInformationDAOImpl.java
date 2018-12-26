package pers.geolo.LogisticsAssistant.dao;

import pers.geolo.LogisticsAssistant.entity.CargoInformation;
import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.utils.DAOUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CargoInformationDAOImpl implements CargoInformationDAO {

    @Override
    public boolean save(CargoInformation cargoInformation) {
        // TODO
        return true;
    }

    @Override
    public List<CargoInformation> listCargoInformation(User user) {
        DataBaseConnection connection = DataBaseConnection.getInstance();
        String SQL = "SELECT CargeInformation.* " +
                "FROM CargeInformation, [User] " +
                "WHERE CargeInformation.shipperId = User.id AND " +
                "User.name = ?";
        PreparedStatement statement;
        ResultSet resultSet;
        List<CargoInformation> cargoList = null;
        try {
            statement = connection.getConnection().prepareStatement(SQL);
            statement.setString(1, user.getUsername());
            resultSet = statement.executeQuery();
            cargoList = (List<CargoInformation>) DAOUtils.getList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargoList;
    }
}
