package pers.geolo.logistics.dao;

import pers.geolo.logistics.dao.impl.CargoDAOImpl;
import pers.geolo.logistics.dao.impl.RequestDAOImpl;
import pers.geolo.logistics.dao.impl.UserDAOImpl;

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
