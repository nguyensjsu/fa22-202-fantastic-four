import greenfoot.*;

public class PowerupFS2 extends Powerup
{
    private int direction_timer = 0;
    private int direction;

    public PowerupFS2(){
        setImage("poseidon.png");
        getImage().scale(20,20);
        setRotation(0);

        setDirection();
    }

    public void activate(Fighter f){
        f.currentPU.pickupFS2();
    }

    @Override
    public void move(){
        int x_speed = Station.level;
        int y_speed = Station.level;

        direction_timer += Greenfoot.getRandomNumber(20);
        if(direction_timer > 600 || this.isAtEdge()) {
            changeDirection();
        }

        setLocation(getX()+(x_speed * direction), getY()+y_speed);
    }

    private void changeDirection(){
        direction *= -1;
        direction_timer = 0;
    }

    private void setDirection(){
        int num = Greenfoot.getRandomNumber(20);
        if(num % 2 == 0){
            direction = 1;
        }
        else{
            direction = -1;
        }
    }
}