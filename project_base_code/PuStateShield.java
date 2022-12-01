import greenfoot.*;

public class PuStateShield extends PuState{
    private Fighter fighter;
    GreenfootSound sound_effect = new GreenfootSound("shield.wav");

    public PuStateShield(Fighter f){
        this.fighter = f;
    }

    public void activate(){
        this.fighter.setImage("fighter_shielded.png");
        this.fighter.getImage().scale(50,50);
        sound_effect.play();
        this.fighter.shield.activate();
        this.fighter.setFS(this.fighter.fsNone);
        this.fighter.setPuTimer(10);
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