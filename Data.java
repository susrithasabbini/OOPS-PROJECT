package AIM;
import java.sql.*;

public class Data {

    public ResultSet JDBC(String query, String database_name, String password) {

        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database_name + "", "root", password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s = null;
        try {
            s = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet r;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return r;
    }

}
