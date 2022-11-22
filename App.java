// package Map;
import Map.*;

public class App {
    public static void main(String[] args) throws Exception {
             

        location troop=new location(63,69);
        location l=new location(3,96);
        basicmap enemy=new enemyhotspot();
        basicmap safelocation=new safelocation();
        basicmap electricity=new electricpower();
        basicmap f=new fuel();
        basicmap water=new waterresources();
        airdrop adp=new airdrop();
        time t=new time();
        
        enemy.setlocation(l,2);
        enemy.printmap();
        enemy.localmap(l);
        l=enemy.nearestlocation(troop);
        l.printlocation();
        
        safelocation.setlocation(troop,1);
        safelocation.printmap();
        safelocation.localmap(troop);
        l=safelocation.nearestlocation(troop);
        l.printlocation();

        electricity.setlocation(troop,3);
        electricity.printmap();
        electricity.localmap(troop);
        l=electricity.nearestlocation(troop);
        l.printlocation();

        f.setlocation(troop,3);
        f.printmap();
        f.localmap(troop);
        l=f.nearestlocation(troop);
        l.printlocation();

        // f.setlocation(troop,3);
        // f.printmap();
        // f.localmap(troop);
        // l=f.nearestlocation(troop);
        // l.printlocation();

        water.setlocation(troop,3);
        water.printmap();
        water.localmap(troop);
        l=water.nearestlocation(troop);
        l.printlocation();

        basicmap enemybase=new enemybase();
        enemybase.printmap();
        l=enemybase.nearestlocation(troop);
        l.printlocation();

        adp.airdroptt(troop);

        /*  
            location object saves the location (latitude,longitude) (0<=latitude<50,0<=longitude<100)
            latitude is | 
            longitude is ---
            for all the map objects
            .printmap() prints the map
            .localmap(location l) prints the objects local map of the given location
            .nearestlocation(location troop) returns nearest object of the respective class 
            airdrop
            .setlocation(location l) sets the give objects map value at location to 1
            airdropclassobject.airdroptt(location troop) prints the location and time of delivery
        */ 
    }
}
