import greenfoot.*;
public class EnemyOneLifeDecorator extends EnemyLifeDecorator
{
    GreenfootSound death = new GreenfootSound("death.mp3");
    public EnemyOneLifeDecorator(EnemyLifeComponent c) {
        super(c);
        // System.out.println("c. strategy: " + ((Enemy)c).getStrategy());
    }

    public void act() {
        super.act();
        actMore();
    }


    private void actMore() {
        if(!getWorld().getObjects(Laser.class).isEmpty()){
            // Actor laser = enemy.getOneIntersectingObject(Laser.class);
            Actor laser = getOneIntersectingObject(Laser.class);
            if (laser!=null){
                getWorld().removeObject(laser);

                makeBomb(getX()+10,getY());

                dropPowerup();

                death.play();
                Fighter.score = Fighter.score +50;

                getWorld().removeObject(this);
            }
        }

        if(getWorld()!=null&&getWorld().getObjects(Fighter.class)!=null){
            Actor fighter = getOneIntersectingObject(Fighter.class);
            if(fighter!=null&&!(Station.cheaton)){
                // getWorld().removeObject(fighter);
                ((Fighter)fighter).takeHit();
                getWorld().removeObject(this);
            }
        }

        if(Station.gameover){
            setImage("invis.png");
        }
    }



}
