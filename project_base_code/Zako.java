import greenfoot.*;
public class Zako extends Enemy
{
    //private boolean 
    // private int time;
    // GreenfootSound death = new GreenfootSound("death.mp3");


    public Zako(){
        getImage().scale(35,30);
    }


    public void act()
    {
        menuAnis();
        // Bee();
        //timeInc();
        // levelMovement();

    }
    public void menuAnis(){
        if (getWorld() == null) {
            return;
        }

        if(!getWorld().getObjects(Menu.class).isEmpty()){
            Actor zako1 = getWorld().getObjects(Zako.class).get(0);
            Actor zako2 = getWorld().getObjects(Zako.class).get(1);
            zako1.turn(3);
            zako2.turn(-3);
        }
    }
    /*
    public void Bee(){
        
        if(!getWorld().getObjects(Laser.class).isEmpty()){
           Actor laser = getOneIntersectingObject(Laser.class);
            if(laser!=null){
                getWorld().removeObject(laser);
                makeBomb(getX()+10,getY());

                dropPowerup(getX(), getY()); //testing
                
                death.play();
                Fighter.score = Fighter.score +50;
                
                getWorld().removeObject(this);
           }
        }
        
        if(getWorld()!=null&&getWorld().getObjects(Goei.class)!=null){
            if(getWorld()!=null&&getWorld().getObjects(Fighter.class)!=null){
                Actor fighter = getOneIntersectingObject(Fighter.class);
                if(fighter!=null&&!(Station.cheaton)){
                    getWorld().removeObject(fighter);
                }
            }
            if(Station.gameover){
                setImage("invis.png");
            }
        }
        
    }
    
    /*
    public void timeInc(){
        if(Station.level>0){
            time++;
            if(time==61){
                time=0;
            }
        }
    }
    
    public void levelMovement(){
        if(Station.level==1){
            movementmodi(3,5,-3,10);
        }
        if(Station.level==2){
            movementmodi(5,6,-5,15);
        }
    }
    public void movementmodi(int movepov,int ym, int moveneg, int yp){
        if(Station.level>0){
            if(time==30){
                // Move this actor the specified distance in the direction it is currently facing.
                move(movepov);
                if(getWorld()!=null&&getWorld().getObjects(Zako.class)!=null){
                    setLocation(getX(),getY()-ym);
                }
                getImage().scale(40,35);
            }
            if(time==60){
                move(moveneg);
                if(getWorld()!=null&&getWorld().getObjects(Zako.class)!=null){
                    setLocation(getX(),getY()+yp);
                }
                getImage().scale(35,30);
            }    
        }
    }
    */
   /*
    public void makeBomb(int xcord, int ycord){
        Bomb bomb = new Bomb();
        getWorld().addObject(bomb,xcord,ycord);
    }

    public void dropPowerup(int x, int y){
        PowerupLife pu = new PowerupLife();
        getWorld().addObject(pu, x, y);
    }
    */
}
