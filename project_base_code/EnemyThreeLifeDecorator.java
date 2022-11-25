import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class EnemyThreeLifeDecorator extends EnemyLifeDecorator
{
    private int life = 9;
    private int lastKillTime = -1;
    private int time = -1;
    GreenfootSound death = new GreenfootSound("death.mp3");
    public EnemyThreeLifeDecorator(EnemyLifeComponent c) {
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

                    if (life == 6) {
                        // change appearance.
                        if (component instanceof Boss) {
                            // could use a different pic to show different level of boss
                            // will still use the same for now
                            //setImage(new GreenfootImage("boss2.png"));
                            setImage(new GreenfootImage("boss.png"));
                            // getImage().scale(35,30);
                        }

                    }
                    if (life == 3) {
                        // change appearance.
                        if (component instanceof Boss) {
                            // could use a different pic to show different level of boss
                            // will still use the same for now
                            //setImage(new GreenfootImage("boss3.png"));
                            setImage(new GreenfootImage("boss.png"));
                            // getImage().scale(35,30);
                        }
                    }
                    getWorld().removeObject(laser);
                    if (life == 0) {
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
                // getWorld().removeObject(this);
            }
        }

        if(Station.gameover){
            setImage("invis.png");
        }
    }
}
