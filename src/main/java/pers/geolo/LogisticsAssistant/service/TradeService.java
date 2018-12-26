package pers.geolo.LogisticsAssistant.service;

import pers.geolo.LogisticsAssistant.dao.CargoInformationDAO;
import pers.geolo.LogisticsAssistant.dao.DAOFactory;
import pers.geolo.LogisticsAssistant.entity.CargoInformation;
import pers.geolo.LogisticsAssistant.entity.User;

import java.util.List;

public class TradeService {

    CargoInformationDAO cargoInformationDAO;

    private TradeService() {
        cargoInformationDAO = DAOFactory.getInstance().getDAO("CargoInformationDAO");
    }

    // 实例持有者
    private static class Holder {
        private static final TradeService INSTANCE = new TradeService();
    }

    // 单例模式
    public static TradeService getInstance() {
        return Holder.INSTANCE;
    }

    public boolean publish(CargoInformation cargoInformation) {
        return cargoInformationDAO.save(cargoInformation);
    }

    public List<CargoInformation> getMyPublish(User user) {
        return cargoInformationDAO.listCargoInformation(user);
    }
}
