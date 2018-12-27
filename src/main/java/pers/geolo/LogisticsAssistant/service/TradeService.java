package pers.geolo.LogisticsAssistant.service;

import pers.geolo.LogisticsAssistant.dao.CargoDAO;
import pers.geolo.LogisticsAssistant.dao.DAOFactory;
import pers.geolo.LogisticsAssistant.entity.Cargo;
import pers.geolo.LogisticsAssistant.entity.TradeRequest;
import pers.geolo.LogisticsAssistant.entity.User;

import java.util.List;

public class TradeService {

    CargoDAO cargoDAO;

    private TradeService() {
        cargoDAO = DAOFactory.getInstance().getDAO("CargoDAO");
    }




    // 实例持有者
    private static class Holder {
        private static final TradeService INSTANCE = new TradeService();
    }

    // 单例模式
    public static TradeService getInstance() {
        return Holder.INSTANCE;
    }

    public boolean publish(Cargo cargo) {
        return cargoDAO.save(cargo);
    }

    public List<Cargo> getMyPublish(User user) {
        return cargoDAO.listCargo(user);
    }

    public Cargo getCargoDetail(int id) {
        return cargoDAO.getCargo(id);
    }


    public List<Cargo> getAllPublished() {
        return cargoDAO.listAllCargo();
    }

    public List<TradeRequest> getTradeRequestList(int cargoNumber) {
        return null;
    }

}
