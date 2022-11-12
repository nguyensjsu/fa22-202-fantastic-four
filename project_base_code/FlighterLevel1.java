import greenfoot.*;
public class FlighterLevel1 extends Actor implements LaserStrategy{
    
    @Override
    public void doOperation(int offset, Fighter fighter) {
        Laser laser = new Laser();
        fighter.getWorld().addObject(laser,fighter.getX(),fighter.getY()-38);
    }
}