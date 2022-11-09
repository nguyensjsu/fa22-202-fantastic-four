import greenfoot.*;

public class PowerupLife extends Powerup
{
    public PowerupLife(){
        getImage().scale(20,20);
        setRotation(0);
    }

    public void activate(Fighter f){
        f.lifePlus();
    }
}