import greenfoot.*;
public class Blaser extends Actor
{
    public Blaser(){
        getImage().scale(10,20);
        setRotation(180);
    }
    public void act()
    {
        goDown();
        behavior();
    }
    public void behavior(){
        if(getY()==499){
            getWorld().removeObject(this);
        }
    }
    public void goDown(){
        if(Station.level==1){
            setLocation(getX(),getY()+(3));
        }
    }
}