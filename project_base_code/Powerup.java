import greenfoot.*;

public abstract class Powerup extends Actor
{
	public void act(){
		move();
		behavior();
	}

	public void move(){
		int speed = Station.level * 2;
		setLocation(getX(),getY()+speed);
	}

	public void behavior(){
		Actor fighter = getOneIntersectingObject(Fighter.class);

		// going out of bounds
		if(getY() == 499){
			getWorld().removeObject(this);
		}
		// when colliding with fighter
		else if(fighter != null){
			activate((Fighter)fighter);
			getWorld().removeObject(this);
		}
	}

	// each powerup affects fighter differently
	abstract void activate(Fighter f);
}