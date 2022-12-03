import greenfoot.*;
import greenfoot.GreenfootSound;
import java.util.ArrayList;

public class GameOverScreen extends Screen implements IDisplayComponent 
{
    private GameOverScreenGlyphFactory gOSGlyphFactory; 
    private final ArrayList<IDisplayComponent> components;
    /**
     * Constructor for objects of class GameOverScreen
     * 
     */
    public GameOverScreen(MyWorld world)
    {
        super(world, new GreenfootImage("wallpaper.png"));
        
        components = new ArrayList<>();
        gOSGlyphFactory = GameOverScreenGlyphFactory.getInstance(world);

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
        addSubComponent(gOSGlyphFactory.screenTitle);
        addSubComponent(gOSGlyphFactory.tryAgainButton);
        addSubComponent(gOSGlyphFactory.leaderboardButton);
     
        display();
        act();
    }
    
    @Override
    public void act()
    {
    //    if(Greenfoot.mouseClicked(gOSGlyphFactory.leaderboardButton)){
    //        if (UserInfo.isStorageAvailable()) {
    //            int newScore= Fighter.score;
    //            UserInfo myInfo = UserInfo.getMyInfo();
    //            if ( newScore > myInfo.getScore()) {
    //                myInfo.setScore(newScore);
    //                myInfo.setString(0,world.gameMode);
    //                myInfo.store();  // write back to server
    //            }
    //        }
    //        world.getScoreBoard().drawNewScore("Your new score is: " + String.valueOf(world.getCounter().getValue()), 200, 20, new Color(0x0, 0x0, 0x0), 25);
    //        world.getScoreBoard().drawScores();
    //        gOSGlyphFactory.leaderboardButton.onClick();
    //    }
        if(Greenfoot.mouseClicked(gOSGlyphFactory.tryAgainButton)){
            //if (UserInfo.isStorageAvailable()) {
            //    int newScore= world.getCounter().getValue();
            //    UserInfo myInfo = UserInfo.getMyInfo();
            //    if ( newScore > myInfo.getScore()) {
            //        myInfo.setScore(newScore);
            //        myInfo.setString(0,world.gameMode);
            //        myInfo.store();  // write back to server
            //    }
            //}
            gOSGlyphFactory.tryAgainButton.onClick();
        } 
    }
}
