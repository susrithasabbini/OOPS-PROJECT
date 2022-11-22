import javax.security.auth.kerberos.EncryptionKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;

class Authentication
{

    Diary D;
    public boolean isAuthentication(String ID,String name) throws SQLException {

        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));

        boolean flag =false;

        ResultSet r = new Data().JDBC("SELECT * FROM Authentication where id = '"+ID+"'", "pavan", "Pavan@161103");

        String DATA_PASS = null;

        while (r.next())
        {
            if (ID.compareTo(r.getString(1)) == 0)
            {
                DATA_PASS = r.getString(2);
            }

            else  {
                System.out.println("ID not found.");
                System.out.println("Enter again...");
                return false;
            }
        }


        String ans = Encryption.encryption(DATA_PASS);

        System.out.println("Encrypted Input is " + "'"+ ans + "''");

        String check = Encryption.encryption(name);


        if (ans.compareTo(check) == 0) {
            flag = true;

        }
        else {
            flag = false;
            System.out.println("Wrong Password , Enter again..");
        }
//
//        if(flag)
//        {
//           this.D=new Diary();
//           D.DiaryNote();
//        }
//
//        else{
//            System.out.println("Enter crt details");
//            System.exit(0);
//        }


        return flag;

    }



    }


class Information
{


    private int Co_OrdX;
    private int Co_OrdY;




    public void setCo_OrdX(int co_OrdX) {
        Co_OrdX = co_OrdX;
    }

    public void setCo_OrdY(int co_OrdY) {
        Co_OrdY = co_OrdY;
    }

    public int getCo_OrdX() {
        return Co_OrdX;
    }

    public int getCo_OrdY() {
        return Co_OrdY;
    }

    public int getDistance(int XCo_ord,int YCo_ord)
    {
        int Dist = (int) (Math.pow(XCo_ord,2) + Math.pow(YCo_ord,2));

        return (int) Math.sqrt(Dist);
    }

}

class Bombs
{

    private String Bomb;

    public void getBomb()

    {
        Commando C2 = new Commando();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value of impact in between 1-100 :- ");
        int val = in.nextInt();

        if(val < 30)
        {
            System.out.println("Bomb-1 has been selected");
            C2.Update("Cluster Bomb");

        }
        else if (val > 30 && val < 60)
        {

            System.out.println("Bomb-2 has been selected");
            C2.Update("Incendiary Bomb");
        }
        else if (val > 60)
        {
            System.out.println("Bomb-3 has been selected");
            C2.Update("TriNitroToulene");

        }

    }

}


class Resque extends Homebase
{


    public Resque(int X, int Y) {

        super(X, Y);
    }

    public Resque() {

    }

    public void getDistance(int Co_OrdX, int Co_OrdY)
    {
        double X_Dist = Math.pow(Math.abs(Co_OrdX - getX_CO()),2);
        double Y_Dist = Math.pow(Math.abs(Co_OrdY - getY_CO()),2);
        int ans = (int) Math.sqrt(X_Dist + Y_Dist);

        System.out.println("The Distance is "+ ans + " Kilometre's from the base.");


    }

}


class Homebase
{

    private int X_CO;
    private  int Y_CO;


    public int getX_CO()
    {

        return X_CO;
    }

    public void setX_CO(int x_CO)
    {

        X_CO = x_CO;
    }

    public int getY_CO()
    {
        return Y_CO;
    }

    public void setY_CO(int y_CO)
    {
        Y_CO = y_CO;
    }

    public Homebase(int X, int Y)
    {
        this.X_CO=X;
        this.Y_CO=Y;
    }

    public Homebase()
    {
        
    }


}


class Diary
{


    private String TEXT ;

    ArrayList<String> DiaryArray = new ArrayList<>();

    public Diary(String hello) {
        this.TEXT = hello;
    }

    public Diary()
    {

    }

    public String getTEXT() {
        return TEXT;
    }


    public void setTEXT(String TEXT) {

        this.TEXT = TEXT;
    }

    public void DiaryNote()
    {
        Scanner in = new Scanner(System.in);

        TEXT = in.nextLine();

        this.DiaryArray.add(TEXT);

    }



}
