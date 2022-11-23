package AIM;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;


class Authentication extends Encryption {

        public boolean isAuthentication(String ID, String name) throws SQLException {

        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;

        ResultSet r = new Data().JDBC("SELECT * FROM Authentication where id = '" + ID + "'", "pavan", "Pavan@161103");

        String DATA_PASS = null;

        while (r.next()) {
            if (ID.compareTo(r.getString(1)) == 0) {
                DATA_PASS = r.getString(2);
            }
        }
        if (DATA_PASS == null) {
            System.out.println("ID not found, Enter correct credentials");
            return false;
        }

        String ans = encryption(DATA_PASS);

        System.out.println("Encrypted Input is " + "'" + ans + "''");

        String check = encryption(name);

        if (ans.compareTo(check) == 0) {
            flag = true;

        } else {
            System.out.println("Wrong Password, Enter again..");
            flag = false;
        }
        return flag;
    }

}

class Bombs {

    private String Bomb;

    public void getBomb(int val) {

        Scanner in = new Scanner(System.in);
        Commando C2 = new Commando();

        if (val < 5) {
            System.out.println("Bomb-1 has been selected");
            C2.Update("Cluster Bomb");

        } else if (val > 5 && val < 15) {

            System.out.println("Bomb-2 has been selected");
            C2.Update("Incendiary Bomb");
        } else if (val > 15) {
            System.out.println("Bomb-3 has been selected");
            C2.Update("TriNitroToluene");

        }

    }

}

class Resque extends Homebase {

    public Resque(int X, int Y) {

        super(X, Y);
    }

    public Resque() {

    }

    public void getDistance(int Co_OrdX, int Co_OrdY) {
        double X_Dist = Math.pow(Math.abs(Co_OrdX - getX_CO()), 2);
        double Y_Dist = Math.pow(Math.abs(Co_OrdY - getY_CO()), 2);
        int ans = (int) Math.sqrt(X_Dist + Y_Dist);

        System.out.println("The Distance is " + ans + " Kilometre's from the Main Base.");

    }

}

class Homebase {

    private int X_CO;
    private int Y_CO;

    public int getX_CO() {

        return X_CO;
    }

    public void setX_CO(int x_CO) {

        X_CO = x_CO;
    }

    public int getY_CO() {
        return Y_CO;
    }

    public void setY_CO(int y_CO) {
        Y_CO = y_CO;
    }

    public Homebase(int X, int Y) {
        this.X_CO = X;
        this.Y_CO = Y;
    }

    public Homebase() {

    }

}

class Diary {
    private String TEXT;

    ArrayList<String> DiaryArray = new ArrayList<>();

    public Diary(String TEXT) {
        this.TEXT = TEXT;
    }

    public Diary() {

    }

    public String getTEXT() {
        return this.TEXT;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public void DiaryNote() {
        Scanner in = new Scanner(System.in);

        this.TEXT = in.nextLine();

        this.DiaryArray.add(TEXT);

    }

    public void getDiary() {
        for (int i = 0; i < DiaryArray.size(); i++) {
            System.out.println(this.DiaryArray.get(i));
        }

    }

}
