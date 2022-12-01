import greenfoot.*;

public class PuStateFS2 extends PuState{
    private Fighter fighter;

    public PuStateFS1(Fighter f){
        super(f);
    }

    public void activate(){
        this.fighter.shield.deactivate();
        this.fighter.setFS(this.fighter.fsWave);
        this.fighter.setPuTimer(6);
    }
}