import greenfoot.*; 
public class MyWorld extends World
{
    public String[] images = {"blue.png","orange.png","pink.png","purple.png","teal.png","tan.png","white.png","yeller.png","red.png"};
    public int[] xcord = {74,177,288,27,132,479,144,408,19,80,264,380,406,491,18,85,165,206,296,106,49,25,13,78,89,145,138,167,221,234,245,371,449,347,299,379,440,291,462,393,282,338,448,318,398,456};
    public int[] ycord = {11,26,41,58,54,71,99,83,121,152,124,113,129,152,214,227,187,206,191,262,276,343,472,407,447,336,458,416,470,334,270,182,185,227,294,276,302,379,356,402,438,417,427,481,475,480};
    public MyWorld()
    {    
        super(500, 500, 1);
        makeActors();
    }
    
    public enum SCREENS 
    {
        MENU,
        GAME,
        LEADERBOARD
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
    
    
}