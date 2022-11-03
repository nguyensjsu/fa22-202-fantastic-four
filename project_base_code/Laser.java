import greenfoot.*;  
public class Laser extends Actor
{
    public Laser(){
        getImage().scale(10,20);
    }
    public void act() 
    {
        setLocation(getX(),getY()-20);
        behavior();
    }    
    public void behavior(){
        if(getY()==0){
            getWorld().removeObject(this);
        }
    }         
}