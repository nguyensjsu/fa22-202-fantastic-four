import greenfoot.*;  
import java.util.concurrent.TimeUnit;

public class FsRadial extends FireSupportStrat implements ITimerObserver
{
    private int x;
    private int y;
    private Box container;

    GreenfootSound wail = new GreenfootSound("firesupport.wav");
    GreenfootSound explode = new GreenfootSound("explode.wav");

    public FsRadial(Fighter f){
        super(f);
    };

    @Override
    public void boom(){
        resume();
        /*
        generateCoords();
        this.container = new Box("big_bomb.png");
        this.container.getImage().scale(20,20);

        World w = this.fighter.getWorld();
        w.addObject(this.container, x, 0);
        */
        /*
        wail.play();
        
        World w = this.fighter.getWorld();
        Timer t = new Timer(1);
        t.addObserver(this);
        w.addObject(t,1,1);
        t.start();
        */
    }


    /*
    public void act(){
        if(this.container.getY() == y && this.fighter != null){
            World w = this.fighter.getWorld();
            w.removeObject(this.container);
            resume();
        }
    }
    */

    public void resume(){
        if(wail.isPlaying()){
            wail.stop();
        }
        if(fighter != null){
            explode.play();
            addShraps();
        }
    }

    private void generateCoords(){
        this.x = Greenfoot.getRandomNumber(300) + 100;
        this.y = Greenfoot.getRandomNumber(300) + 100;
    }


    private void addShraps(){
        World w = this.fighter.getWorld();
        generateCoords();

        Laser shot1 = new LaserCustom(0, 30);
        Laser shot2 = new LaserCustom(30, 0);
        Laser shot3 = new LaserCustom(0 , -30);
        Laser shot4 = new LaserCustom(-30 , 0);
        Laser shot5 = new LaserCustom( 21, 21);
        Laser shot6 = new LaserCustom( 21, -21);
        Laser shot7 = new LaserCustom( -21, -21);
        Laser shot8 = new LaserCustom( -21, 21);

        if(this.fighter != null){
            w.addObject(shot1, x, y);
            w.addObject(shot2, x, y);
            w.addObject(shot3, x, y);
            w.addObject(shot4, x, y);
            w.addObject(shot5, x, y);
            w.addObject(shot6, x, y);
            w.addObject(shot7, x, y);
            w.addObject(shot8, x, y);
        } 
    }
}