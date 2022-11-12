import greenfoot.*;
public class LaserContext extends Actor {
    private LaserStrategy laserStrategy;
  
    public LaserContext(LaserStrategy laserStrategy){
       this.laserStrategy = laserStrategy;
    }
  
    public void executeStrategy(int offset, Fighter fighter){
       laserStrategy.doOperation(offset, fighter);
    }
}