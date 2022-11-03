import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Gover extends Actor
{
    GreenfootSound fire = new GreenfootSound("gameover.mp3");
    public int time;
    public void act() 
    {
        timeInc();
    }    
    public void timeInc(){
        fire.playLoop();
        if(Station.level>0){
            time++;
            if(time==31){
                time=0;
            }
        }
        if(time==15){
            setImage("goverred.png");
            }
        if(time==30){
            setImage("goverwhite.png");
        }
    }
}
