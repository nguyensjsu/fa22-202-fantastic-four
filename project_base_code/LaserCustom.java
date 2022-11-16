import greenfoot.*;  

public class LaserCustom extends Laser 
{
	private int velocityX;
	private int velocityY;
	private int startX;
	private int startY;

	public LaserCustom(){
		super();
	}

	public LaserCustom(int x, int y){
		super();
		setImage("orange.png");
		getImage().scale(8,8);
		setVelocity(x, y);
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

	private void setVelocity(int x, int y){
		this.velocityX = x;
		this.velocityY = y;
	}

	private void setStart(int x, int y){
		this.startX = x;
		this.startY = y;
	}
}