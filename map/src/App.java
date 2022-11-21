class airdrop {
    location airdroptt(location troop)
    {
        basicmap safe=new safelocation();
        location l=new location();
        l=safe.nearestlocation(troop);
        System.out.printf("The package will arrive at (%d,%d).\n", l.la,l.lo);
        time t= new time();
        t= gettime(l);
        basicmap enemy=new enemyhotspot();
        System.out.printf("Local map of enemy hotspot:\n");
        enemy.localmap(l);
        return l;
    }
    time gettime(location l)
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
public class App {
    public static void main(String[] args) throws Exception {
             

        location troop=new location(25,25);
        location l=new location(15,15);
        basicmap enemy=new enemyhotspot();
        basicmap safelocation=new safelocation();
        basicmap electricity=new electricpower();
        basicmap fuel=new fuel();
        basicmap water=new waterresources();
        airdrop adp=new airdrop();
        time t=new time();
        
        // enemy.setlocation(troop,0);
        // enemy.printmap();
        // enemy.localmap(troop);
        // l=enemy.nearestlocation(troop);
        // l.printlocation();
        
        // adp.airdroptt(troop);
        
        // safelocation.setlocation(troop,1);
        // safelocation.printmap();
        // safelocation.localmap(troop);
        // l=safelocation.nearestlocation(troop);
        // l.printlocation();

        // electricity.setlocation(troop,3);
        // electricity.printmap();
        // electricity.localmap(troop);
        // l=electricity.nearestlocation(troop);
        // l.printlocation();

        // fuel.setlocation(troop,3);
        // fuel.printmap();
        // fuel.localmap(troop);
        // l=fuel.nearestlocation(troop);
        // l.printlocation();

        // fuel.setlocation(troop,3);
        // fuel.printmap();
        // fuel.localmap(troop);
        // l=fuel.nearestlocation(troop);
        // l.printlocation();

        // water.setlocation(troop,3);
        // water.printmap();
        // water.localmap(troop);
        // l=water.nearestlocation(troop);
        // l.printlocation();

        basicmap enemybase=new enemybase();
        enemybase.printmap();
        l=enemybase.nearestlocation(troop);
        l.printlocation();
    }
}
