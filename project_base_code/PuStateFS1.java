import greenfoot.*;

public class PuStateFS1 extends PuState{
    private Fighter fighter;

    public PuStateFS1(Fighter f){
        super(f);
    }

    public void activate(){
        this.fighter.shield.deactivate();
        this.fighter.setFS(this.fighter.fsRadial);
        this.fighter.setPuTimer(6);
    }
}