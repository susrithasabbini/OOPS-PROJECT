public class enemybase extends basicmap{
    int[][] enemybase=new int [100][50];
    enemybase()
    {
        int radius=1;
        int la,lo;
        la=18;lo=22;
        for(int i=la-radius;i<=la+radius;i++)
        {
            for(int j=lo-radius;j<=lo+radius;j++)
            {
                try 
                {
                    if((i>=0)&&(i<50)&&(j>=0)&&(j<100))
                        enemybase [j][i]=1;
                }
                catch(ArrayIndexOutOfBoundsException e) 
                {
                    System.out.println(e);
                }
            }
        }
        la=22;lo=56;
        for(int i=la-radius;i<=la+radius;i++)
        {
            for(int j=lo-radius;j<=lo+radius;j++)
            {
                try 
                {
                    if((i>=0)&&(i<50)&&(j>=0)&&(j<100))
                        enemybase [j][i]=1;
                }
                catch(ArrayIndexOutOfBoundsException e) 
                {
                    System.out.println(e);
                }
            }
        }
        la=29;lo=79;
        for(int i=la-radius;i<=la+radius;i++)
        {
            for(int j=lo-radius;j<=lo+radius;j++)
            {
                try 
                {
                    if((i>=0)&&(i<50)&&(j>=0)&&(j<100))
                        enemybase [j][i]=1;
                }
                catch(ArrayIndexOutOfBoundsException e) 
                {
                    System.out.println(e);
                }
            }
        }
        la=39;lo=99;
        for(int i=la-radius;i<=la+radius;i++)
        {
            for(int j=lo-radius;j<=lo+radius;j++)
            {
                try 
                {
                    if((i>=0)&&(i<50)&&(j>=0)&&(j<100))
                        enemybase [j][i]=1;
                }
                catch(ArrayIndexOutOfBoundsException e) 
                {
                    System.out.println(e);
                }
            }
        }
        la=29;lo=69;
        for(int i=la-radius;i<=la+radius;i++)
        {
            for(int j=lo-radius;j<=lo+radius;j++)
            {
                try 
                {
                    if((i>=0)&&(i<50)&&(j>=0)&&(j<100))
                        enemybase [j][i]=1;
                }
                catch(ArrayIndexOutOfBoundsException e) 
                {
                    System.out.println(e);
                }
            }
        }
        la=26;lo=12;
        for(int i=la-radius;i<=la+radius;i++)
        {
            for(int j=lo-radius;j<=lo+radius;j++)
            {
                try 
                {
                    if((i>=0)&&(i<50)&&(j>=0)&&(j<100))
                        enemybase [j][i]=1;
                }
                catch(ArrayIndexOutOfBoundsException e) 
                {
                    System.out.println(e);
                }
            }
        }
        la=15;lo=40;
        for(int i=la-radius;i<=la+radius;i++)
        {
            for(int j=lo-radius;j<=lo+radius;j++)
            {
                try 
                {
                    if((i>=0)&&(i<50)&&(j>=0)&&(j<100))
                        enemybase [j][i]=1;
                }
                catch(ArrayIndexOutOfBoundsException e) 
                {
                    System.out.println(e);
                }
            }
        }   
    }
    @Override
    void printmap()
    {
        System.out.printf("Enemy Operation Base Map\n");
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<100;j++)
            {
                if(enemybase[j][i]==0)
                {
                    if((i%5==0)&&(j%5==0))
                        System.out.printf("+ ");
                    else System.out.printf(". ");
                }
                else System.out.printf("%d ",enemybase[j][i]);
            }
            System.out.printf("\n");
        }
    }
    @Override
    void setlocation(location l,int radius)// radius
    {
        for(int i=l.la-radius;i<=l.la+radius;i++)
        {
            for(int j=l.lo-radius;j<=l.lo+radius;j++)
            {
                try 
                {
                    if((i>=0)&&(i<50)&&(j>=0)&&(j<100))
                        enemybase[j][i]=1;
                }
                catch(ArrayIndexOutOfBoundsException e) 
                {
                    System.out.println(e);
                }
            }
        }
    }
    @Override
    location nearestlocation(location l)
    {
        double min=10000;
        double temp;
        int c=0; int v=0;
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<100;j++)
            {
                if(enemybase[j][i]==1)
                {
                    temp=((l.la-i)*(l.la-i))+((l.lo-j)*(l.lo-j));
                    if(temp<min) 
                    {
                        min=Math.sqrt(temp);
                        //min=temp;
                        c=i; v=j;
                    }
                }
            }
        }
        l.la=c;
        l.lo=v;
        return l;
    }
    @Override
    void localmap(location l)
    {
        if((l.la-10<0)&&(l.la+10>50)&&(l.lo-10<0)&&(l.lo+10>100))
        System.out.println("Cannot display local map [edge case scenario].");
        else if((l.la-10<0)&&(l.lo-10<0))
        {
            for(int i=0;i<=20;i++)
            {
                for(int j=0;j<=20;j++)
                {
                    if(i==0)
                    System.out.printf("%2d ",j);
                    else if(j==0)
                    System.out.printf("%2d ",i);
                    else if(enemybase[j][i]==1)
                    System.out.printf(" 1 ");
                    else System.out.printf(" . ");
                }
                System.out.printf("\n");
            }
        }
        else if((l.la-10<0)&&(l.lo+10>100))
        {
            for(int i=0;i<=20;i++)
            {
                for(int j=79;j<100;j++)
                {
                    if(i==0)
                    System.out.printf("%2d ",j);
                    else if(j==79)
                    System.out.printf("%2d ",i);
                    else if(enemybase[j][i]==1)
                    System.out.printf(" 1 ");
                    else System.out.printf(" . ");
                }
                System.out.printf("\n");
            }
        }
        else if((l.la+10>50)&&(l.lo-10<0))
        {
            for(int i=29;i<50;i++)
            {
                for(int j=0;j<=20;j++)
                {
                    if(i==29)
                    System.out.printf("%2d ",j);
                    else if(j==0)
                    System.out.printf("%2d ",i);
                    else if(enemybase[j][i]==1)
                    System.out.printf(" 1 ");
                    else System.out.printf(" . ");
                }
                System.out.printf("\n");
            }
        }
        else if((l.la+10>50)&&(l.lo+10>100))
        {
            for(int i=29;i<50;i++)
            {
                for(int j=79;j<100;j++)
                {
                    if(i==29)
                    System.out.printf("%2d ",j);
                    else if(j==79)
                    System.out.printf("%2d ",i);
                    else if(enemybase[j][i]==1)
                    System.out.printf(" 1 ");
                    else System.out.printf(" . ");
                }
                System.out.printf("\n");
            }
        }
        else
        {
        for(int i=l.lo-10;i<=l.lo+10;i++)
        {
            for(int j=l.la-10;j<=l.lo+10;j++)
            {
                if(i==l.lo-10)
                System.out.printf("%2d ",j);
                else if(j==l.la-10)
                System.out.printf("%2d ",i);
                else if(enemybase[j][i]==1)
                System.out.printf(" 1 ");
                else System.out.printf(" . ");
            }
            System.out.printf("\n");
        }
        }
        System.out.printf("Location: %d,%d",l.la,l.lo);
    }
}