import greenfoot.*;
import java.util.ArrayList;

public class MenuScreen extends Screen implements IDisplayComponent
{
    private Button startButton;
    private Button lbButton;
    private Button exitButton;
    private Label screenTitle;
    private MenuScreenGlyphFactory menuScreenGlyphFactory; 
    private final ArrayList<IDisplayComponent> components;
    /**
     * Constructor for objects of class MenuScreen
     */
    public MenuScreen(MyWorld world)
    {
        super(world, new GreenfootImage("wallpaper.png"));
        components = new ArrayList<>();
        menuScreenGlyphFactory = MenuScreenGlyphFactory.getInstance(world);
        startButton = menuScreenGlyphFactory.startButton;
        lbButton = menuScreenGlyphFactory.lbButton;
        exitButton = menuScreenGlyphFactory.exitButton;
    }
    
    public void addSubComponent( IDisplayComponent c ) {
        components.add(c);
    };
    
    public void removeSubCompnent( IDisplayComponent c ) {
        components.remove(c);
    };
    
    public void display(){
        for (IDisplayComponent dc : components) 
            dc.display();
    };
    public void setLocation(int x, int y){
    // do nothing
    }; 
    
    public void active()
    {
        super.active();

        addSubComponent(startButton);
        addSubComponent(lbButton);
        addSubComponent(exitButton);  
        display();
        act();
    }

    @Override
    public void act()
    {       
         if(Greenfoot.mouseClicked(startButton)){
                startButton.onClick();
        }
        if(Greenfoot.mouseClicked(lbButton)){
               world.getScoreBoard().drawNewScore("Your new score is: " + String.valueOf(world.getCounter().getValue()), 200, 20, new Color(0x0, 0x0, 0x0), 25);
               world.getScoreBoard().drawScores();
               lbButton.onClick();
        }
        if(Greenfoot.mouseClicked(exitButton)){
                Greenfoot.stop();
        }
    }
}
