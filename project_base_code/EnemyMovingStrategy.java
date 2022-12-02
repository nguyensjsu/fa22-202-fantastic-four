import greenfoot.*;

/**
 * Strategy Pattern.
 *
 * @author  l
 * @version  20221111
 */
public interface EnemyMovingStrategy
{
    void move(Actor actor, int time, int speed);
}
