import greenfoot.*;

/**
 *  Enemy moving vertically down to bottom
 *
 */
public class EnemyMovingDown implements EnemyMovingStrategy
{

    public void move(Actor actor, int time, int speed) {
        int movepov = 3 * speed;
        int ym = 5 * 2 * speed;
        int moveneg = -3 * speed;
        int yp = 10 * 2 * speed;

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
