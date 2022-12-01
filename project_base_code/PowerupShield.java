import greenfoot.*;

public class PowerupShield extends Powerup
{
    public PowerupShield(){
        setImage("shield.png");
        getImage().scale(20,20);
        setRotation(0);
    }

    public void activate(Fighter f){
        f.currentPU.pickupShield();
    }
}