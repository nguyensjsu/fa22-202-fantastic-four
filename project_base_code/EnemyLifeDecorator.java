import greenfoot.*;
public class EnemyLifeDecorator extends Actor implements EnemyLifeComponent
{
    protected EnemyLifeComponent component;
    int time = 0;
    private int speed = 1;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public EnemyLifeDecorator(EnemyLifeComponent c) {
        component = c;
        if (c instanceof Zako) {
            setImage(new GreenfootImage("zako.png"));
            getImage().scale(35,30);
        }

        if (c instanceof Goei) {
            setImage(new GreenfootImage("Goei.png"));
            getImage().scale(35,35);
        }

        if (c instanceof Boss) {
            setImage(new GreenfootImage("boss.png"));
        }
    }

    public void act() {
        component.act();
        time++;
        if(time==61){
            time=0;
        }
        ((Enemy)component).getStrategy().move(this, time, speed);
    }

    protected void makeBomb(int xcord, int ycord){
        Bomb bomb = new Bomb();
        getWorld().addObject(bomb,xcord,ycord);
    }
    public void dropPowerup(){
        LootManager.getInstance().dropLoot(this);
    }
}
