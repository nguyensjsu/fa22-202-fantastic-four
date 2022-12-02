import greenfoot.*;
//cufepez@2ether.net\
//me280
//dir279
public class Goei extends Enemy
{
    // private int time;
    // GreenfootSound death = new GreenfootSound("death.mp3");

    public Goei(){
        getImage().scale(35,35);
    }
    public void act()
    {
        //Butterfly();
        // timeInc();
        // levelMovement();
    }   
    /*
    public void Butterfly(){
        
        if(getWorld()!=null&&getWorld().getObjects(Laser.class)!=null){
           Actor laser = getOneIntersectingObject(Laser.class);
            if(laser!=null){
                getWorld().removeObject(laser);
                if(Station.level>1){
                    makeBomb(getX()+10,getY());
                }

                dropPowerup();

                death.play();
                Fighter.score = Fighter.score +80;
                getWorld().removeObject(this);
           }
        }
        
        if(getWorld()!=null&&getWorld().getObjects(Goei.class)!=null){
            if(getWorld()!=null&&getWorld().getObjects(Fighter.class)!=null){
                Actor fighter = getOneIntersectingObject(Fighter.class);
                if(fighter!=null&&!(Station.cheaton)){
                    Fighter f = (Fighter)fighter;
                    f.takeHit();
                }
            }
        }
        if(Station.gameover){
            setImage("invis.png");            
        }
        
    }
    
    public void levelMovement(){
        if(Station.level==1){
            movementmodi(3,5,-3,12);
        }
        if(Station.level==2){
            movementmodi(5,6,-5,15);
        }
    }
    public void movementmodi(int movepov,int ym, int moveneg, int yp){
        if(Station.level>0){
            if(time==30){
                move(movepov);
                if(getWorld()!=null&&getWorld().getObjects(Goei.class)!=null){
                    setLocation(getX(),getY()-ym);
                }
                getImage().scale(40,35);
            }
            if(time==60){
                move(moveneg);
                if(getWorld()!=null&&getWorld().getObjects(Goei.class)!=null){
                    setLocation(getX(),getY()+yp);
                }
                getImage().scale(35,30);
            }    
        }
    }
    */
    /*
    public void timeInc(){
        if(Station.level>0){
            time++;
            if(time==61){
                time=0;
            }
        }
    }
    
    public void makeBomb(int xcord, int ycord){
        Bomb bomb = new Bomb();
        getWorld().addObject(bomb,xcord,ycord);
    }
    
    public void deathSound(){
        if(time==1){
            death.play();
        }
    }

    /*
    public void dropPowerup(int x, int y){
        PowerupLife pu = new PowerupLife();
        getWorld().addObject(pu, x, y);
    }
    */
}