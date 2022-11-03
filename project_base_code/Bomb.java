import greenfoot.*;  
public class Bomb extends Actor
{
    public Bomb(){
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
            setLocation(getX(),getY()+(5));
        }
        if(Station.level==2){
            setLocation(getX(),getY()+(7));
        }
        if(Station.level==3){
            setLocation(getX(),getY()+(3));
        }
    }
}
