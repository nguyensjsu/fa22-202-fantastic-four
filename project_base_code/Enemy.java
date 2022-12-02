import greenfoot.*;
import java.util.*;

/**
 * enemy, Zako, Goei are enimies.
 */
public class Enemy extends Actor implements EnemyLifeComponent
{
    // protected int time = 0;

    // moving strategy
    protected EnemyMovingStrategy strategy = new EnemyNotMoving();

    public EnemyMovingStrategy getStrategy() {
        return strategy;
    }

    public void changeStrategy(EnemyMovingStrategy s) {
        // System.out.println("new s: " + s);
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
    
    /*
    public void timeInc(){
        if(Station.level>0){
            time++;
            if(time==61){
                time=0;
            }
        }
    }    
    */

    public void dropPowerup(){
        LootManager.getInstance().dropLoot(this);
    }
}
