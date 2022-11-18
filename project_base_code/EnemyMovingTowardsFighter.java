import greenfoot.*;
import java.util.*;

public class EnemyMovingTowardsFighter implements EnemyMovingStrategy
{
    public void move(Actor actor, int time) {
        if(Station.level == 0) {
            return;
        }

        if(actor.getWorld() == null) {
            return;
        }

        // move every 0.3 seconds
        if (time % 30 != 0) {
            return;
        }
        // get the fighter
        List<Fighter> fighters = actor.getWorld().getObjects(Fighter.class);
        if (fighters.isEmpty()) {
            return;
        }

        Fighter fighter = fighters.get(0);

        int fighterX = fighter.getX();
        int fighterY = fighter.getY();


        // moving towards the fighter.
        int x = actor.getX();
        int y = actor.getY();

        int deltaX = 20;
        int deltaY = 20;

        if (x > fighterX) {
            x -= deltaX;
            if (x < fighterX) {
                x = fighterX;
            }
        }

        if (x < fighterX) {
            x += deltaX;
            if (x > fighterX) {
                x = fighterX;
            }
        }

        y += deltaY;
        actor.setLocation(x, y);
    }
}