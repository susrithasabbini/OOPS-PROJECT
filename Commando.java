package AIM;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
public class Commando {
    static String display(int disp[]) {
        char convert[] = new char[disp.length];
        for (int l = 0; l < disp.length; l++) {
            convert[l] = (char) disp[l];
        }
        String str = String.copyValueOf(convert);
        return str;
    }

    public static int[] encryption(String ptext) {
        int temp = 0;
        String key;
        int s[] = new int[256];
        int k[] = new int[256];

        key = "AIMS";

        char ptextc[] = ptext.toCharArray();
        char keyc[] = key.toCharArray();
        int cipher[] = new int[ptext.length()];
        int ptexti[] = new int[ptext.length()];
        int keyi[] = new int[key.length()];

        for (int i = 0; i < ptext.length(); i++) {
            ptexti[i] = (int) ptextc[i];
        }

        for (int i = 0; i < key.length(); i++) {
            keyi[i] = (int) keyc[i];
        }

        for (int i = 0; i < 255; i++) {
            s[i] = i;
            k[i] = keyi[i % key.length()];
        }

        int j = 0;
        for (int i = 0; i < 255; i++) {
            j = (j + s[i] + k[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        int i = 0;
        j = 0;
        int z = 0;
        for (int l = 0; l < ptext.length(); l++) {
            i = (l + 1) % 256;
            j = (j + s[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            z = s[(s[i] + s[j]) % 256];
            cipher[l] = z ^ ptexti[l];

        }

        return cipher;
    }

    public static ResultSet JDBC(String query, String database_name, String password) {

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

    public static void JDBC_Connection(String query, String database_name, String password) {

        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database_name + "", "root", password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s;
        try {
            s = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet r;
        try {
            r = s.executeQuery(query);
            while (r.next()) {
                System.out.format("%20s %10d\n", r.getString(1), r.getInt(2));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printTable(String TableName) {
        String printQuery = "select * from " + TableName;
        JDBC_Connection(printQuery, "pavan", "Pavan@161103");
    }

    public static void DeleteFood(String ConditionTuple, int Quantity) {
        String UpdateQuery = "UPDATE Food SET Quantity = Quantity - " + Quantity + " WHERE Food = '" + ConditionTuple + "'";
        System.out.println("Entered "+ ConditionTuple+" has been reduced by"+ Quantity+".");

        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan", "root", "Pavan@161103");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s;
        try {
            s = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            s.executeUpdate(UpdateQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void DeleteClothes(String ConditionTuple, int Quantity) {
        String UpdateQuery = "UPDATE clothes SET Quantity = Quantity - " + Quantity + " WHERE Clothes = '" + ConditionTuple + "'";
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan", "root", "Pavan@161103");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s;
        try {
            s = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            s.executeUpdate(UpdateQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void DeleteAmmunitions(String ConditionTuple, int Quantity) {
        String UpdateQuery = "UPDATE Ammunitions SET Quantity = Quantity - " + Quantity + " WHERE Ammunitions ='"
                + ConditionTuple + "'";
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan", "root", "Pavan@161103");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s;
        try {
            s = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            s.executeUpdate(UpdateQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Update(String BombName) {
        String UpdateQuery = "UPDATE Bomb SET No_of_Bombs= No_of_Bombs-1 where Bombs = '" + BombName + "'";
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan", "root", "Pavan@161103");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s;
        try {
            s = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            s.executeUpdate(UpdateQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void UpdateFood() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan", "root", "Pavan@161103");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s, stmt;
        try {
            s = c.createStatement();
            stmt = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet r;
        try {
            r = s.executeQuery("Select * from Food");
            while (r.next()) {
                String fd = r.getString(1);
                int brn = r.getInt(2);
                if (brn < 10) {
                    String UpdateQuery = "UPDATE Food SET Quantity= Quantity+50 WHERE Food = '" + fd + "'";
                    stmt.executeUpdate(UpdateQuery);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        printTable("Food");
    }

    public static void UpdateClothes() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan", "root", "Pavan@161103");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s, stmt;
        try {
            s = c.createStatement();
            stmt = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet r;
        try {
            r = s.executeQuery("Select * from Clothes");
            while (r.next()) {
                String fd = r.getString(1);
                int brn = r.getInt(2);
                if (brn < 10) {
                    String UpdateQuery = "UPDATE Clothes SET Quantity = Quantity+50 WHERE Clothes = '" + fd + "'";
                    stmt.executeUpdate(UpdateQuery);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        printTable("Clothes");
    }

    public static void UpdateAmmunitions() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan", "root", "Pavan@161103");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement s, stmt;
        try {
            s = c.createStatement();
            stmt = c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet r;
        try {
            r = s.executeQuery("Select * from Ammunitions");
            while (r.next()) {
                String fd = r.getString(1);
                int brn = r.getInt(2);
                if (brn < 10) {
                    String UpdateQuery = "UPDATE Ammunitions SET Quantity = Quantity + 50 WHERE Ammunitions = '" + fd
                            + "'";
                    stmt.executeUpdate(UpdateQuery);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        printTable("Ammunitions");
    }

    public static boolean SearchByFoodItem(String food_item_name) {
        Boolean Flag = true;
        String Query = "Select Food from Food where Food like '%" + food_item_name + "%'";
        ResultSet r = JDBC(Query, "pavan", "Pavan@161103");
        try {
            if (!r.next())
                Flag = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Flag;

    }

    public static boolean SearchByAmmunitions(String Ammunition_Name) {
        Boolean Flag = true;
        String Query = "Select Ammunitions from Ammunitions where Ammunitions like '%" + Ammunition_Name + "%'";
        ResultSet r = JDBC(Query, "pavan", "Pavan@161103");
        try {
            if (!r.next())
                Flag = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Flag;
    }

    public static boolean SearchByClothes(String Clothes) {
        Boolean Flag = true;
        String Query = "Select clothes from clothes where Clothes like '%" + Clothes + "%'";
        ResultSet r = JDBC(Query, "pavan", "Pavan@161103");
        try {
            if (!(r.next()))
                Flag = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Flag;
    }

    public static boolean SearchByPartialString(String str) {
        Boolean Flag = true;
        String Q1 = "Select Food from Food where Food like '%" + str + "%'";
        String Q2 = "Select clothes from clothes where Clothes like '%" + str + "%'";
        String Q3 = "Select Ammunitions from Ammunitions where Ammunitions like '%" + str + "%'";
        ResultSet r1 = JDBC(Q1, "pavan", "Pavan@161103");
        ResultSet r2 = JDBC(Q2, "pavan", "Pavan@161103");
        ResultSet r3 = JDBC(Q3, "pavan", "Pavan@161103");
        try {
            if (!(r1.next() || r2.next() || r3.next()))
                Flag = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Flag;
    }

    public static void SearchByQuantity(int Number) {
        ResultSet r1, r2, r3;
        String Query = "Select * from Food where Quantity <= " + Number;
        r1 = JDBC(Query, "pavan", "Pavan@161103");
        JDBC_Connection(Query, "pavan", "Pavan@161103");

        String Query1 = "Select * from Clothes where Quantity <= " + Number;
        r2 = JDBC(Query1, "pavan", "Pavan@161103");
        JDBC_Connection(Query1, "pavan", "Pavan@161103");
        String Query2 = "Select * from Ammunitions where Quantity <= " + Number;
        r3 = JDBC(Query2, "pavan", "Pavan@161103");
        JDBC_Connection(Query2, "pavan", "Pavan@161103");
        try {
            if (!(r1.next() || r2.next() || r3.next()))
                System.out.println("No Items with Quantity less than Input value ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}