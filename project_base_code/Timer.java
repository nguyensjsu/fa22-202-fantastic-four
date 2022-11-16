import greenfoot.*;
import java.util.ArrayList;

public class Timer extends Actor 
{
    private int time = 0;
    private int maxTime;
    private boolean started = false;

    private ArrayList<ITimerObserver> observers = new ArrayList<ITimerObserver>();

    public Timer(int t){
        setImage("invis.png");
        setLocation(1,1);
        this.maxTime = t * 60;
    }

    public void act(){
        if(started){
            time ++;
        }
        if(time == maxTime){
            notifyObservers();
            getWorld().removeObject(this);
        }
    }

    public void addObserver(ITimerObserver o){
        this.observers.add(o);
    }

    public void notifyObservers(){
        for (ITimerObserver observer : this.observers){
            observer.resume();
        }
    }

    public void start(){
        this.started = true;
    }
}