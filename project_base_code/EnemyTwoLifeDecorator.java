import greenfoot.*;
public class EnemyTwoLifeDecorator extends EnemyLifeDecorator
{
    private int life = 2;
    private int lastKillTime = -1;
    private int time = -1;
    GreenfootSound death = new GreenfootSound("death.mp3");
    public EnemyTwoLifeDecorator(EnemyLifeComponent c) {
        super(c);
    }

    public void act() {
        time++;
        super.act();
        actMore();
    }

    private void actMore() {
        if(!getWorld().getObjects(Laser.class).isEmpty()){
            // Actor laser = enemy.getOneIntersectingObject(Laser.class);
            Actor laser = getOneIntersectingObject(Laser.class);
            if (laser!=null){
                if (time - lastKillTime > 30) {
                    life--;
                    lastKillTime = time;

                    if (life == 1) {
                        // change appearance.
                        if (component instanceof Zako) {
                            // could use a different pic to show different level of zako
                            // will still use the same for now
                            //setImage(new GreenfootImage("zako2.png"));
                            setImage(new GreenfootImage("zako.png"));
                            getImage().scale(35,30);
                        }

                        if (component instanceof Goei) {
                            // could use a different pic to show different level of goei
                            // will still use the same for now
                            //setImage(new GreenfootImage("Goei1.png"));
                            setImage(new GreenfootImage("Goei.png"));
                            getImage().scale(35,35);
                        }
                    }

                    getWorld().removeObject(laser);

                    if (life == 0) {

                        makeBomb(getX()+10,getY());

                        dropPowerup(getX(), getY()); //testing

                        death.play();
                        Fighter.score = Fighter.score + 50 + 50;

                        getWorld().removeObject(this);
                    }
                }
            }
        }

        if(getWorld()!=null&&getWorld().getObjects(Fighter.class)!=null){
            Actor fighter = getOneIntersectingObject(Fighter.class);
            if(fighter!=null&&!(Station.cheaton)){
                // getWorld().removeObject(fighter);
                ((Fighter)fighter).decreaseLife();
                getWorld().removeObject(this);
            }
        }

        if(Station.gameover){
            setImage("invis.png");
        }
    }



}
