package pers.geolo.LogisticsAssistant.dao;

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
    private final String DB_URL = "jdbc:sqlserver://localhost:1433/LogisticsAssistant";
    private final String USER = "sa";
    private final String PASSWORD = "123";

    private Connection connection;

    private DataBaseConnection() {
        try {
            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
//        TODO     System.out.println("数据库创建异常");
            e.printStackTrace();

        }
    }

    public static class Holder {
        public static final DataBaseConnection INSTANCE = new DataBaseConnection();
    }

    public static DataBaseConnection getInstance() {
        return Holder.INSTANCE;
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
