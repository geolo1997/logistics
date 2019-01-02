package pers.geolo.logisticsassistant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @桀骜
 * 数据库连接类
 * 单例模式
 */
public class DataBaseConnection {

    private final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Nima Logistics;user=sa;password=123456";

    private Connection connection;

    public DataBaseConnection() {
        try {
            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(DB_URL);
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
