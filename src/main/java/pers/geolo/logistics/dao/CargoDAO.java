package pers.geolo.logistics.dao;

import pers.geolo.logistics.entity.Cargo;
import pers.geolo.logistics.constant.CargoState;
import pers.geolo.logistics.constant.CargoType;

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
