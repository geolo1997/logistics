package pers.geolo.LogisticsAssistant.dao;

public class DAOFactory {

    public static DAOFactory getInstance() {
        return new DAOFactory();
    }

    public <T extends BaseDAO> T getDAO(String daoName) {
        if ("UserDAO".equals(daoName)) {
            return (T) new UserDAOImpl();
        } else if("CargoInformationDAO".equals(daoName)){
            return (T) new CargoInformationDAOImpl();
        }
        return null;
    }
}
