import greenfoot.*;
import java.lang.Math;

public class LootManager
{
	private static LootManager instance;

	private int empty_chance = 8;

	private LootManager(){};

	public static synchronized LootManager getInstance(){
		if(instance == null){
			instance = new LootManager();
		}
		return instance;
	}

	public void dropLoot(Actor dropper){
		World world = dropper.getWorld();
		int x = dropper.getX();
		int y = dropper.getY();

		Powerup loot = selectLoot();

		if(loot != null){
			world.addObject(loot, x, y);
		}
	}

	private Powerup selectLoot(){

		int ceiling = 4 + empty_chance;
		int roll = Greenfoot.getRandomNumber(ceiling);

		//System.out.println("roll: " + roll);

		switch(roll){
		case 0:
			return new PowerupLife();
		case 1:
			return new PowerupShield();
		case 2:
			return new PowerupFS1();
		case 3:
			return new PowerupFS2();
		default:
			return null;
		}
	}
}