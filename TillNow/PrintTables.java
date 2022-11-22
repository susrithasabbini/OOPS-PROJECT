import java.sql.*;


public class PrintTables {


    public ResultSet JDBC(String query, String database_name, String password){

        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database_name+"", "root", password);
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


    public void P_Tables() throws SQLException {
        PrintTables Tables = new PrintTables();

        ResultSet r = Tables.JDBC("SELECT * FROM Authentication","pavan","Pavan@161103");


        System.out.println(" ID's\t\t\t\tPassword's" );
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        while(r.next())
        {

            System.out.println(r.getString(1) +"\t\t\t\t"+ r.getString(2));
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        r = Tables.JDBC("SELECT * FROM bomb","pavan","Pavan@161103");


        System.out.println("\tBombs\t\t\t\t Number of bombs");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        while(r.next())
        {

            System.out.println(r.getString(1)+ "\t\t\t\t" + r.getInt(2));
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");


        r = Tables.JDBC("SELECT * FROM Food ","pavan","Pavan@161103");

        System.out.format("%15s %15s\n", "Food", "Quantity");

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");


        while(r.next())
        {

            System.out.format("%15s %10d\n",r.getString(1), r.getInt(2));
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");


        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        r = Tables.JDBC("SELECT * FROM Clothes ","pavan","Pavan@161103");

        System.out.format("%15s %20s\n", "Clothes", "Quantity");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");



        while(r.next())
        {

            System.out.format("%20s %10d\n",r.getString(1), r.getInt(2));
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        r = Tables.JDBC("SELECT * FROM Ammunitions ","pavan","Pavan@161103");

        System.out.format("%15s %20s\n", "Gun", "Quantity");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        while(r.next())
        {
            System.out.format("%20s %15d\n",r.getString(1), r.getInt(2));
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }


}


