package Map;

public class airdrop {
    public location airdroptt(location troop)
    {
        safelocation safe=new safelocation();
        location l=new location();
        l=safe.nearestlocation(troop);
        System.out.printf("The package will arrive at (%d,%d).\n\n", l.la,l.lo);
        time t= new time();
        t= gettime(l);
        enemyhotspot enemy=new enemyhotspot();
        System.out.printf("Local map of enemy hotspot:\n");
        enemy.localmap(l);
        return l;
    }
    public time gettime(location l)
    {
        // set time now
        time t= new time();
        double distance=0; // in m
        distance = Math.sqrt(((l.la-50)*(l.la-50)+(l.lo-50)*(l.lo-50))*10000); // scale *1000 m 1 km
        double speed=100; //in mps
        double totalseconds=distance/speed; //s
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
