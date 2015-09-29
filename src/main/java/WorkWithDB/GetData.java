package WorkWithDB;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Bogdan Kukharskiy on 29.09.2015.
 */
public class GetData {

    public static ResultSet doQuery(String query) throws SQLException {
        MysqlConnect db = new MysqlConnect();

        Statement statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    public static void main(String[] args) throws SQLException {
        String queryString = "SELECT * FROM bfl.materials";
        ResultSet resultSet = doQuery(queryString);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "\t|\t" + resultSet.getString(2) + "\t|\t" + resultSet.getFloat(3) + "\t|\t" + resultSet.getString(5));
        }
    }
}
