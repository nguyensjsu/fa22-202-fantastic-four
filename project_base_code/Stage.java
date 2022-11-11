import greenfoot.*;
public class Stage extends Actor
{
    public String[] images ={"stage1.png","stage2.png","stage3.png","stage4.png","stage5.png"};
    public Stage(){
        setImage("invis.png");
    }
    public void act()
    {
        // do not show stage.
        // setStageImg();
    }
    /*
    public void setStageImg(){
        int level = Station.level;
        if(Station.level>0){
            setImage(images[level-1]);
            getImage().scale(80,15);
        }
    }
    */
}