<<<<<<< HEAD
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
=======
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
>>>>>>> 1361153b5f101c364e745cd82527e23f2b9dcddd
}