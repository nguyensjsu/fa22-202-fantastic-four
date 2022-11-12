import greenfoot.*;  
public class LaserRight extends Laser
{
    public LaserRight(){
        getImage().scale(10,20);
    }
    public void act() 
    {
        setLocation(getX()+2,getY()-20);
        behavior();
    }
    public void behavior(){
        if(getY()==0){
            getWorld().removeObject(this);
        }
    }         
}