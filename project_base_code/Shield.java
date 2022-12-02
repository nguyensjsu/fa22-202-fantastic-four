import greenfoot.*;

public class Shield implements IDamageTarget{
    private Fighter fighter;
    public IDamageTarget next;
    private boolean active = false;

    public void activate(){
        active = true;
    }

    public void deactivate(){
        active = false;
    }

    public Shield(Fighter f ){
        this.fighter = f;
    }

    public void setNext(IDamageTarget n){
        this.next = n;
    }
    public void takeHit(){
        if(!active){
            next.takeHit();
        }
    }
}