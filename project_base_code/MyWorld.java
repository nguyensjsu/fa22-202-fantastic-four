import greenfoot.*; 
public class MyWorld extends World
{
    public String[] images = {"blue.png","orange.png","pink.png","purple.png","teal.png","tan.png","white.png","yeller.png","red.png"};
    public int[] xcord = {74,177,288,27,132,479,144,408,19,80,264,380,406,491,18,85,165,206,296,106,49,25,13,78,89,145,138,167,221,234,245,371,449,347,299,379,440,291,462,393,282,338,448,318,398,456};
    public int[] ycord = {11,26,41,58,54,71,99,83,121,152,124,113,129,152,214,227,187,206,191,262,276,343,472,407,447,336,458,416,470,334,270,182,185,227,294,276,302,379,356,402,438,417,427,481,475,480};
    
    private Screen currentScreen;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private GameOverScreen gameOverScreen;
    
    private MenuScreenGlyphFactory menuScreenGlyphFactory;
    private LeaderboardScreenGlyphFactory lbSGlyphFactory;
    private GameOverScreenGlyphFactory gOSGlyphFactory;
    
    public MyWorld()
    {    
        super(500, 500, 1);  
        //reset();
        // Create GlyphFactory for screens
        menuScreenGlyphFactory = new MenuScreenGlyphFactory(this);
        lbSGlyphFactory = LeaderboardScreenGlyphFactory.getInstance(this);
        gOSGlyphFactory = new GameOverScreenGlyphFactory(this);
        // Create screens in MyWorld
        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        gameOverScreen = new GameOverScreen(this);
        
        //scoreBoard = LocalScoreBoard.getInstance(400,300,this);
        //scoreBoard.drawNewScore("Your new score is: " + String.valueOf(this.getCounter().getValue()), 200, 20, new Color(0x0, 0x0, 0x0), 25);
        //scoreBoard.drawScores();
        
        setNextScreen(SCREENS.MENU);
    }
    
    public enum SCREENS 
    {
        MENU,
        GAME,
        LEADERBOARD
    } 
    
    protected void prepare()
    {        
        makeActors();
    }
    
    public void makeActors(){     
        for(int x=0;x<46;x++){
            Box box = new Box(images[Greenfoot.getRandomNumber(9)]);
            addObject(box,xcord[x],ycord[x]);
        }
        //
        Menu menu = new Menu();
        addObject(menu,250,250);
        //
        Zako zako1 = new Zako();
        Zako zako = new Zako();
        addObject(zako1,385,305);
        addObject(zako,112,305);
        //
        Laser laser = new Laser();
        addObject(laser,100,100);
        //
        Station station = new Station();
        addObject(station,100,100);
        Station.level=0;
        Station.gameover=false;
        //
        Stage stage = new Stage();
        addObject(stage,43,11);
    }
    
    //public LocalScoreBoard getScoreBoard(){
    //    return scoreBoard;
    //}
    
    /**
     * A method to set nextScreen and activate the Screen
     * 
     */
    public void setNextScreen(SCREENS screen)
    {
        if(currentScreen !=null)
            currentScreen.clean();
            
        switch(screen) {
            case MENU: {
                currentScreen = menuScreen; 
                break;
            }
            case GAME: {
                GameScreen.initialize();
                currentScreen = gameScreen; 
                break;
            }
            //case LEADERBOARD: {
            //    currentScreen = leaderboardScreen; 
            //    break;
            //}
            default: currentScreen = menuScreen;
        }
        currentScreen.active();
        
    }
    
    public void setGameScreen() {
        currentScreen = gameScreen;
        currentScreen.active();
    }
    
    public void stop() {
        currentScreen = gameOverScreen;
        currentScreen.active();
    }
    
    /**
     * A "Act" method in the world activate the currentScreen
     * 
     */    
    @Override
    public void act()
    {
        if(currentScreen != null) {
            currentScreen.active();
        }
    }
    
    private static void reset() {
        LocalScoreBoard.reset();
        LeaderboardScreenGlyphFactory.reset();
    }
}