import greenfoot.*;

/**
 *  enemy move downwards.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EnemyMovingDown implements EnemyMovingStrategy
{

    public void move(Actor actor, int time) {
        int movepov = 3;
        int ym = 5 * 2;
        int moveneg = -3;
        int yp = 10 * 2;

        if(Station.level>0){
            if(time==30){
                // Move this actor the specified distance in the direction it is currently facing.
                actor.move(movepov);
                if(actor.getWorld()!=null && actor.getWorld().getObjects(Zako.class)!=null){
                    actor.setLocation(actor.getX(),actor.getY()-ym);
                }
                // actor.getImage().scale(40,35);
            }
            if(time==60){
                actor.move(moveneg);
                if(actor.getWorld()!=null && actor.getWorld().getObjects(Zako.class)!=null){
                    actor.setLocation(actor.getX(), actor.getY()+yp);
                }
                // actor.getImage().scale(35,30);
            }
        }

    }
}
