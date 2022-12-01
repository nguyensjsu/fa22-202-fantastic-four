import greenfoot.*;

public abstract class PuState implements IPowerupState{

    protected Fighter fighter;

    public PuState(Fighter f){
        this.fighter = f;
    }

    public abstract activate();

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