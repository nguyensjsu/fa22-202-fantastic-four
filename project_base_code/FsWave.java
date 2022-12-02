import greenfoot.*;
import java.util.ArrayList;

public class FsWave extends FireSupportStrat implements ITimerObserver
{
    private ArrayList<LaserCustom> ammo = new ArrayList<LaserCustom>();
    private double interval = 0.25;
    private int ammoCount = 8;
    private int speed = 20;

    public FsWave(Fighter f){
        super(f);
    };

    @Override
    public void boom(){
        World w = this.fighter.getWorld();
        loadAmmo();
        fire();
    }

    public void resume(){
        if(ammo.size() > 0 && this.fighter != null){
            World w = this.fighter.getWorld();

            LaserCustom l = ammo.get(0);
            int x = l.getStartX();
            int y = l.getStartY();
            w.addObject(l, x, y);
            ammo.remove(0);
            fire();
        }
    }

    private void loadAmmo(){

        int distance = (int)(Math.round(500/this.ammoCount));
        int offset = (500 - (this.ammoCount*distance))/2;

        for(int i = 0; i < ammoCount; i++){
            ammo.add(new LaserCustom());
        }

        for(int i = 0; i < ammo.size(); i++ ){
            int wobble = Greenfoot.getRandomNumber(distance / 3);
            ammo.get(i).setStart( (distance*i) + offset + wobble , 500);
            ammo.get(i).setVelocity(0, this.speed);
        }
        
    }

    private void fire(){
        World w = this.fighter.getWorld();
        Timer t = new Timer(interval);
        t.addObserver(this);
        w.addObject(t,1,1);
        t.start();
    }
}