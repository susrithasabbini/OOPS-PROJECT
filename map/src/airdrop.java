public class airdrop {
    location airdroptt(location troop)
    {
        safelocation s=new safelocation();
        location l=new location();
        l=s.nearestlocation(troop);
        System.out.printf("The package will arrive at (%d,%d).\n", l.la,l.lo);
        time t= new time();
        t= gettime(l);
        enemyhotspot e=new enemyhotspot();
        System.out.printf("Local map of enemy hotspot:\n");
        e.localmap(l);
        return l;
    }
    time gettime(location l)
    {
        // set time now
        time t= new time();
        double distance=0; // in m
        distance = Math.sqrt(((l.la-50)*(l.la-50)+(l.lo-50)*(l.lo-50))*10000); // scale *1000 m 1 km
        double speed=100; //in mps
        double totalseconds=0; //s

        try{
            totalseconds=distance/speed; //s
        }catch(ArithmeticException e){System.out.println(e);}    
        
        int hours = (int)totalseconds / 3600;
        int minutes = (int)(totalseconds % 3600) / 60;
        int seconds = (int)totalseconds % 60;
        System.out.printf("The package will reach the destination at : %02d:%02d:%02d (hh:mm:ss)\n", hours, minutes, seconds); 
        t.hours=hours;
        t.minutes=minutes;
        t.seconds=seconds;
        return t;
    }
}