import greenfoot.*;  
public class LaserLeft extends Laser
{
    public LaserLeft(){
        getImage().scale(10,20);
    }
    public void act() 
    {
        setLocation(getX()-2,getY()-20);
        behavior();
    }
    public void behavior(){
        if(getY()==0){
            getWorld().removeObject(this);
        }
    }         
}