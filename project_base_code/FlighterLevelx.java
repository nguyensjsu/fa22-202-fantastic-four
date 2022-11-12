import greenfoot.*;
public class FlighterLevelx extends Actor implements LaserStrategy{
    @Override
    public void doOperation(int offset, Fighter fighter) {
        LaserLeft laserLeft = new LaserLeft();
        LaserRight laserRight = new LaserRight();
        fighter.getWorld().addObject(laserLeft,fighter.getX()-offset,fighter.getY()-38);
        fighter.getWorld().addObject(laserRight,fighter.getX()+offset,fighter.getY()-38);
    }
}