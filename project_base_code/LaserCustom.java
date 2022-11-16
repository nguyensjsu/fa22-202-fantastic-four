import greenfoot.*;  

public class LaserCustom extends Laser 
{
	private int velocityX;
	private int velocityY;

	public LaserCustom(int x, int y){
		super();
		setImage("orange.png");
		getImage().scale(8,8);
		this.velocityX = x;
		this.velocityY = y;
	}

	@Override
	public void act(){
		move();
		behavior();
	}

	@Override
	public void behavior(){
		if(this.isAtEdge()){
			getWorld().removeObject(this);
		}
	}

	private void move(){
		setLocation(getX() + velocityX, getY() - velocityY);
	}
}