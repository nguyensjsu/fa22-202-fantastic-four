import greenfoot.*;

public class PuStateFS1 extends PuState{
    private Fighter fighter;
    GreenfootSound sound_effect = new GreenfootSound("powerup.wav");

    public PuStateFS1(Fighter f){
        this.fighter = f;
    }

    public void activate(){
        this.fighter.setImage("fighter_zeus.png");
        this.fighter.getImage().scale(50,50);
        sound_effect.play();
        this.fighter.shield.deactivate();
        this.fighter.setFS(this.fighter.fsRadial);
        //System.out.println("FS1: fighter set fs radial");
        this.fighter.setPuTimer(6);
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