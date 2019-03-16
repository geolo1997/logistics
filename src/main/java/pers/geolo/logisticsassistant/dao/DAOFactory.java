package pers.geolo.logisticsassistant.dao;

import pers.geolo.logisticsassistant.dao.impl.CargoDAOImpl;
import pers.geolo.logisticsassistant.dao.impl.RequestDAOImpl;
import pers.geolo.logisticsassistant.dao.impl.UserDAOImpl;

public class DAOFactory {

    private static volatile DAOFactory instance;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            synchronized (DAOFactory.class) {
                if (instance == null) {
                    instance = new DAOFactory();
                }
            }
        }
        return instance;
    }

    public <T> T getDAO(String daoName) {
        if ("UserDAO".equals(daoName)) {
            return (T) new UserDAOImpl();
        } else if ("CargoDAO".equals(daoName)) {
            return (T) new CargoDAOImpl();
        } else if ("RequestDAO".equals(daoName)) {
            return (T) new RequestDAOImpl();
        }
        return null;
    }
}
