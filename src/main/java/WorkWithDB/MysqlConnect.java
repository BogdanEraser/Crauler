package WorkWithDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Bogdan Kukharskiy on 29.09.2015.
 */
public final class MysqlConnect {
    public static MysqlConnect db;
    public Connection conn;

    protected MysqlConnect() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "bfl";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "masterkey";
        try {
            Class.forName(driver).newInstance();
            this.conn = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static synchronized MysqlConnect getDbCon() {
        if (db == null) {
            db = new MysqlConnect();
        }
        return db;
    }

}
