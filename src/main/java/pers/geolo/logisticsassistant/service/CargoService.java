package pers.geolo.logisticsassistant.service;

import pers.geolo.logisticsassistant.dao.CargoDAO;
import pers.geolo.logisticsassistant.dao.DAOFactory;
import pers.geolo.logisticsassistant.entity.Cargo;
import pers.geolo.logisticsassistant.entity.User;
import pers.geolo.logisticsassistant.value.CargoState;
import pers.geolo.logisticsassistant.value.CargoType;

import java.util.Date;
import java.util.List;

public class CargoService {

    CargoDAO cargoDAO;

    private CargoService() {
        cargoDAO = DAOFactory.getInstance().getDAO("CargoDAO");
    }

    public List<Cargo> getTradeOrder(int driverId) {
        return cargoDAO.listDealCargo(driverId);
    }



    // 实例持有者
    private static class Holder {
        private static final CargoService INSTANCE = new CargoService();
    }

    // 单例模式
    public static CargoService getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 发布货物信息
     *
     * @param user  货主
     * @param cargo 货物信息
     */
    public void publish(User user, Cargo cargo) {
        cargo.setShipperId(user.getId());
        cargo.setDriverId(0);
        cargo.setCargoState(CargoState.WAITING_FOR_DRIVER);
        cargo.setPublishTime(new Date());
        cargoDAO.save(cargo);
    }

    /**
     * 获取货主发布的货物信息
     *
     * @param user 货主
     * @return
     */
    public List<Cargo> getMyPublish(int userId) {
        return cargoDAO.listCargo(userId);
    }

    public Cargo getCargo(int id) {
        return cargoDAO.getCargo(id);
    }

    public List<Cargo> getAllPublished() {
        return cargoDAO.listAllCargo();
    }

    public List<Cargo> getMyCargo(int userId) {
        return cargoDAO.listCargo(userId);
    }

    public void selectDriver(int cargoId, int driverId) {
        cargoDAO.update(cargoId, driverId, CargoState.DRIVER_SELECTED, new Date());
    }

    public void updateCargoState(int cargoId, CargoState cargoState) {
        Cargo cargo = cargoDAO.getCargo(cargoId);
        cargo.setCargoState(cargoState);
        cargoDAO.update(cargo.getId(), cargo.getDriverId(), cargoState, cargo.getDealTime());
    }

    public List<Cargo> getCargo(String origin, String destination, CargoType cargoType) {
        origin = (origin == null ? "" : origin);
        destination = (destination == null ? "" : destination);
        cargoType = (cargoType == null ? CargoType.UNDEFINE : cargoType);
        return cargoDAO.listCargoBy(origin, destination, cargoType);
    }

}
