package pers.geolo.LogisticsAssistant.dao;

import pers.geolo.LogisticsAssistant.entity.CargoInformation;
import pers.geolo.LogisticsAssistant.entity.User;

import java.util.List;

public interface CargoInformationDAO extends BaseDAO {

    boolean save(CargoInformation cargoInformation);

    List<CargoInformation> listCargoInformation(User user);
}
