import greenfoot.*;

public class Hull implements IDamageTarget{
    private Fighter fighter;

    public Hull(Fighter f ){
        this.fighter = f;
    }

    public void takeHit(){
        this.fighter.lifeMinus();
    }
}