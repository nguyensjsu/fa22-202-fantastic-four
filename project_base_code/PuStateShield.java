import greenfoot.*;

public class PuStateShield extends PuState{
    private Fighter fighter;

    public PuStateShield(Fighter f){
        super(f);
    }

    public void activate(){
        this.fighter.shield.activate();
        this.fighter.setFS(this.fighter.fsNone);
        this.fighter.setPuTimer(10);
    }
}