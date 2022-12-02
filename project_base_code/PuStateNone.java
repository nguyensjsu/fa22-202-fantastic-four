import greenfoot.*;

public class PuStateNone extends PuState{
    private Fighter fighter;
    //GreenfootSound sound_effect = new GreenfootSound("powerdown.wav");

    public PuStateNone(Fighter f){
        this.fighter = f;
    }

    public void activate(){
        this.fighter.setImage("fighter.png");
        this.fighter.getImage().scale(50,50);
        //sound_effect.play();
        this.fighter.shield.deactivate();
        this.fighter.setFS(this.fighter.fsNone);
        this.fighter.setPuTimer(0);
    }

    public void expire(){
        this.fighter.setPuState("none");
    }

    public void pickupFS1(){
        this.fighter.setPuState("fsRadial");
    }

    public void pickupFS2(){
        this.fighter.setPuState("fsWave");
    }

    public void pickupShield(){
        this.fighter.setPuState("shield");
    }
}