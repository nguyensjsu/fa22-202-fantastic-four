import greenfoot.*;

public class PuStateNone extends PuState{
    private Fighter fighter;

    public PuStateFS1(Fighter f){
        super(f);
    }

    public void activate(){
        this.fighter.shield.deactivate();
        this.fighter.setFS(this.fighter.fsNone);
        this.fighter.setPuTimer(0);
    }
}