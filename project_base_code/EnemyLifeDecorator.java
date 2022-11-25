import greenfoot.*;
public class EnemyLifeDecorator extends Actor implements EnemyLifeComponent
{
    protected EnemyLifeComponent component;
    int time = 0;

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
        ((Enemy)component).getStrategy().move(this, time);
    }

    protected void makeBomb(int xcord, int ycord){
        Bomb bomb = new Bomb();
        getWorld().addObject(bomb,xcord,ycord);
    }
    protected void dropPowerup(int x, int y){
        PowerupLife pu = new PowerupLife();
        getWorld().addObject(pu, x, y);
    }
}
