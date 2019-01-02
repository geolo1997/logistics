package pers.geolo.logisticsassistant.dao;

import pers.geolo.logisticsassistant.entity.Cargo;
import pers.geolo.logisticsassistant.value.CargoState;
import pers.geolo.logisticsassistant.value.CargoType;

import java.util.Date;
import java.util.List;

/**
 * @author 桀骜
 *
 * 操作TABLE Cargo(货物表)
 */
public interface CargoDAO {

    boolean save(Cargo cargo);

    void update(int cargoId, int driverId, CargoState cargoState, Date dealTime);

    Cargo getCargo(int cargoId);

    List<Cargo> listCargo(int ShipperId);

    List<Cargo> listAllCargo();

    List<Cargo> listDealCargo(int driverId);

    List<Cargo> listCargoBy(String origin, String destination, CargoType cargoType);
}
