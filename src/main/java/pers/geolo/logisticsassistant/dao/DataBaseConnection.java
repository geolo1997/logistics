package pers.geolo.logisticsassistant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @桀骜 数据库连接类
 */
public class DataBaseConnection {

    private final String DBDRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/Nima_Logistics";
    private final String USER = "Geolo";
    private final String PASSWORD = "123456";

    private Connection connection;

    public DataBaseConnection() {
        try {
            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
//        TODO     System.out.println("数据库创建异常");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public synchronized void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
