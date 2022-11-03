import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cheat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cheat extends Actor
{
    private int time;
    public Cheat(){
    }
    public void act() 
    {
        timeInc();
    }    
    public void timeInc(){
        if(Station.level>0){
            time++;
            if(time==31){
                time=0;
            }
        }
        if(time==15){
            setImage("cheatred.png");
        }
        if(time==30){
            setImage("cheatgreen.png");
        }
    }   
}
