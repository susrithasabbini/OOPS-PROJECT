package Map;
public abstract class basicmap{                         // all maps are of size 100*50 from (0 to 99) and (0 to 49)
    int[][] basicmap=new int[100][50];
    basicmap()
    {
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<100;j++)
            {
                basicmap[j][i]=0;
            }
        }
    }
    public abstract void setlocation(location l,int radius);
    public abstract void printmap();
    public abstract void localmap(location l);
    public abstract location nearestlocation(location l);
}
