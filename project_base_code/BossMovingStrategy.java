import greenfoot.*;

public class BossMovingStrategy implements EnemyMovingStrategy
{
    boolean movecheck;
    public void move(Actor actor, int time) {
        if(actor.getX()<=130){
            movecheck=false;
        }
        if(movecheck==false){
            actor.move(2);
        }
        if(actor.getX()>=427){
            movecheck=true;
        }
        if(movecheck){
            actor.move(-2);
        }

        if(time==30){
            makeLaser(actor, actor.getX()-50,actor.getY()+75);
        }
        if(time==15){
            makeBomb(actor, actor.getX()+50,actor.getY()+75);
        }
    }

    public void makeBomb(Actor actor, int xcord, int ycord){
        Bomb bomb = new Bomb();
        actor.getWorld().addObject(bomb,xcord,ycord);
    }
    public void makeLaser(Actor actor, int xcord, int ycord){
        Blaser laser = new Blaser();
        actor.getWorld().addObject(laser,xcord,ycord);
        laser.setRotation(180);
        if(laser.getY()==200){
            laser.setRotation(261);
        }
    }
}
