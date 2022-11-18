import greenfoot.*;
import java.util.*;

/**
 * enemy, Zako, Goei are enimies.
 */
public class Enemy extends Actor
{

    // moving strategy
    protected EnemyMovingStrategy strategy = new EnemyNotMoving();

    public void changeStrategy(EnemyMovingStrategy s) {
        strategy = s ;
    }

    public void selectRandomMoveStrategy() {
        Random random = new Random();
        int r = random.nextInt();
        if (r % 3 == 0) {
            changeStrategy(new EnemyNotMoving());
            return;
        }
        if (r % 3 == 1) {
            changeStrategy(new EnemyMovingDown());
            return;
        }
        if (r % 3 == 2) {
            changeStrategy(new EnemyMovingTowardsFighter());
            return;
        }
    }
}