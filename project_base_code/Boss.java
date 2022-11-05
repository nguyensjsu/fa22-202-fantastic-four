import greenfoot.*; 
public class Boss extends Actor
{
    public static int health=30;
    public void act() 
    {
        movement();
        timeInc();
        health();
    }    
    boolean movecheck;
    private int time;
    public void health(){
        Actor laser = getOneIntersectingObject(Laser.class);
        if(laser!=null){
            health=health-1;
        }
        if(health<=0){
            getWorld().removeObject(this);
        }
    }
    public void movement(){
        if(getX()<=130){
            movecheck=false;
        }
        if(movecheck==false){
            move(2);
        }
        if(getX()>=427){
            movecheck=true;
        }
        if(movecheck){
            move(-2);
        }
        if(time==30){
            makeLaser(getX()-50,getY()+75);
        }
        if(time==15){
            makeBomb(getX()+50,getY()+75);
        }
    }
    public void timeInc(){
        if(Station.level==3){
            time++;
            if(time==31){
                time=0;
            }
        }
    }
    public void makeBomb(int xcord, int ycord){
        Bomb bomb = new Bomb();
        getWorld().addObject(bomb,xcord,ycord);
    }
    public void makeLaser(int xcord, int ycord){
        Blaser laser = new Blaser();
        getWorld().addObject(laser,xcord,ycord);
        laser.setRotation(180);
        if(laser.getY()==200){
            laser.setRotation(261);
        }
    }
}
