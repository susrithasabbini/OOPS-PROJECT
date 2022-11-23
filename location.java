package Map;

public class location {
    int la;
    int lo;
    public location()
    {
        la=0;
        lo=0;
    }
    public location(int latitude,int longitude)
    {
        la=latitude;
        lo=longitude;
    }
    public void setlocation(int latitude,int longitude)
    {

        la=latitude;
        lo=longitude;
    }
    public void printlocation()
    {
        System.out.printf("\nLocation:(%d,%d)\n",la,lo);
    }
}
