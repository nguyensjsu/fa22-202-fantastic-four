import greenfoot.*;

public class PowerupLife extends Powerup
{
    GreenfootSound sound_effect = new GreenfootSound("heal.wav");
    public PowerupLife(){
        setImage("heart.png");
        getImage().scale(20,20);
        setRotation(0);
    }

    public void activate(Fighter f){
        f.lifePlus();
        sound_effect.play();
    }
}