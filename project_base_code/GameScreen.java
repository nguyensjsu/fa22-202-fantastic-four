import greenfoot.*;

public class GameScreen extends Screen 
{

    private static boolean initialized = false;
    
    /**
     * Constructor for objects of class GameScreen
     */
    public GameScreen(MyWorld world)
    {
        super(world, new GreenfootImage("wallpaper.png"));
    }

    public static void initialize() {
        initialized= false;
    }
    
    public void active()
    {
        super.active();
        act();
    }
    
    @Override
    public void act()
    {
        if (!initialized) {
            world.prepare();
            initialized = true;
        }
    }
}
