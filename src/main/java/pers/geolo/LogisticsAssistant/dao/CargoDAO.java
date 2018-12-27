package pers.geolo.LogisticsAssistant.dao;

import pers.geolo.LogisticsAssistant.entity.Cargo;
import pers.geolo.LogisticsAssistant.entity.User;

import java.util.List;

public interface CargoDAO extends BaseDAO {

    boolean save(Cargo cargo);

    List<Cargo> listCargo(User user);

    Cargo getCargo(int id);

    List<Cargo> listAllCargo();
}
