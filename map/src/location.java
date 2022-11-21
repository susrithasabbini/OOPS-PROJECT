public class location{
    int la;
    int lo;
    location()
    {
        la=0;
        lo=0;
    }
    location(int latitude,int longitude)
    {
        la=latitude;
        lo=longitude;
    }
    void setlocation(int latitude,int longitude)
    {
        //if(latitude>50||latitude<0||longitude>100||longitude<0)
        
        la=latitude;
        lo=longitude;
    }
    void printlocation()
    {
        System.out.printf("\nLocation:(%d,%d)\n",la,lo);
    }
}
