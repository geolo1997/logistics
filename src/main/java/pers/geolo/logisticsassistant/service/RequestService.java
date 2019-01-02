package pers.geolo.logisticsassistant.service;

import pers.geolo.logisticsassistant.dao.DAOFactory;
import pers.geolo.logisticsassistant.dao.RequestDAO;
import pers.geolo.logisticsassistant.entity.Request;

import java.util.List;

public class RequestService {
    private RequestDAO requestDAO;

    private RequestService() {
        requestDAO = DAOFactory.getInstance().getDAO("RequestDAO");
    }

    private static class Holder {
        private static final RequestService INSTANCE = new RequestService();
    }

    // 单例模式
    public static RequestService getInstance() {
        return Holder.INSTANCE;
    }

    public void save(Request request) {
        requestDAO.save(request);
    }


    public List<Request> getMyRequest(int driverId) {
        return requestDAO.listRequestOfDriver(driverId);
    }

    public List<Request> getRequestOfCargo(int cargoId) {
        return requestDAO.listRequestOfCargo(cargoId);
    }
}
