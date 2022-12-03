import greenfoot.*;

public abstract class Screen  
{
    protected MyWorld world;
    protected GreenfootImage backgroundImage;

    /**
     * Constructor for objects of class Screen
     */
    public Screen(MyWorld world, GreenfootImage image)
    {
        this.world = world;
        this.backgroundImage = image;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void active()
    {
        world.setBackground(backgroundImage);
    }

    public void clean()
    {
        world.removeObjects(world.getObjects(null));
    }
    
    public abstract void act();
}
