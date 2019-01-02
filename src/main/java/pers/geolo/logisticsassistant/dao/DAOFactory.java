package pers.geolo.logisticsassistant.dao;

import pers.geolo.logisticsassistant.dao.impl.CargoDAOImpl;
import pers.geolo.logisticsassistant.dao.impl.RequestDAOImpl;
import pers.geolo.logisticsassistant.dao.impl.UserDAOImpl;

public class DAOFactory {

    public static DAOFactory getInstance() {
        return new DAOFactory();
    }

    public <T> T getDAO(String daoName) {
        if ("UserDAO".equals(daoName)) {
            return (T) new UserDAOImpl();
        } else if("CargoDAO".equals(daoName)){
            return (T) new CargoDAOImpl();
        } else if ("RequestDAO".equals(daoName)) {
            return (T) new RequestDAOImpl();
        }
        return null;
    }
}
