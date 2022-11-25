import greenfoot.*;
public class Fighter extends Actor
{
    private int time;
    public static int score;
    public static int lives =3;
    public static int fighterlevel = 1;
    public static boolean makeReps;
    private int madeReps=0;
    public int madecheats =0;
    GreenfootSound fire = new GreenfootSound("fire.mp3");
    public Fighter(){
        getImage().scale(50,50);
    }
    public void act()
    {
        movement();
        time++;
        setLivesRep();
        Bombed();
        cheatOn();
        Fighterlevel();
    }
    public void Fighterlevel(){
        if(score >= 700){
            fighterlevel = 2;
        }
        else if(score >=1500){
            fighterlevel = 3;
        }
        if(getWorld() != null){
            getWorld().showText("Level: "+String.valueOf(fighterlevel), 320, 15);
        }

    }
    public void fire(){
        if(time>40){
            if(score >= 0){
                Laser laser = new Laser();
                getWorld().addObject(laser,getX(),getY()-38);
                time=0;
            }
            if(score >= 700){
                Laser laser = new Laser();
                getWorld().addObject(laser,getX()-15,getY()-38);
                getWorld().addObject(laser,getX()+15,getY()-38);
                time=0;
            }
            if(score >= 1500){
                Laser laser = new Laser();
                getWorld().addObject(laser,getX()-30,getY()-38);
                getWorld().addObject(laser,getX()+20,getY()-38);
                getWorld().addObject(laser,getX()+50,getY()-38);
                time=0;
            }
        }
        fire.play();
        if(Station.cheaton){
            if(time>1){
                if(score >= 0){
                    Laser laser = new Laser();
                    getWorld().addObject(laser,getX(),getY()-38);
                    time=0;
                }
                if(score >= 700){
                    Laser laser = new Laser();
                    getWorld().addObject(laser,getX()-15,getY()-38);
                    getWorld().addObject(laser,getX()+15,getY()-38);
                    time=0;
                }
                if(score >= 1500){
                    Laser laser = new Laser();
                    getWorld().addObject(laser,getX()-30,getY()-38);
                    getWorld().addObject(laser,getX()+20,getY()-38);
                    getWorld().addObject(laser,getX()+50,getY()-38);
                    time=0;
                }
            }
        }
    }
    public void movement(){
        if(Station.level==1||Station.level==2){
            movementmodi(0,0,8,8);
        }else{
            movementmodi(4,4,4,4);
            if(Station.level==3){
                getImage().scale(25,25);
            }
        }
        if(Greenfoot.isKeyDown("f")){
            fire();
        }
        if(getWorld()!=null&&getWorld().getObjects(Fighterc.class)!=null){
            Actor fighterc = getOneIntersectingObject(Fighterc.class);
            if(fighterc!=null){
                setLocation(53,getY());
            }
        }
        if(getX()<24){
            setLocation(24,getY());
        }
        if(getX()>476){
            setLocation(476,getY());
        }
    }
    public void movementmodi(int up,int down,int left,int right){
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-up);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+down);
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+right,getY());
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-left,getY());
        }
    }
    public void Bombed(){
        Actor bomb = getOneIntersectingObject(Bomb.class);
        Actor blaser = getOneIntersectingObject(Blaser.class);
        if(bomb!=null&&lives==3){
            lives=2;
            getWorld().removeObject(bomb);
            getWorld()  .getObjects(Fighterc.class).get(0).setImage("invis.png");
            getWorld()  .getObjects(Fighterc.class).get(0).setLocation(1,1);
        }else if(bomb!=null&&lives==2){
            lives=1;
            getWorld().removeObject(bomb);
            getWorld().getObjects(Fighterc.class).get(1).setImage("invis.png");
            getWorld().getObjects(Fighterc.class).get(1).setLocation(1,1);
        }else if(bomb!=null&&lives==1){
            lives=0;
            getWorld().removeObject(bomb);
            getWorld().removeObject(this);
        }
        if(Station.level==3){
            if(blaser!=null||bomb!=null){
                getWorld()  .getObjects(Fighterc.class).get(0).setImage("invis.png");
                getWorld().getObjects(Fighterc.class).get(1).setImage("invis.png");
                getWorld().removeObject(this);
            }
        }
    }
    public void setLivesRep(){
        int level = Station.level;
        if(level>0){
            if(madeReps<2&&makeReps){
                for(int f=0;f<1;f++){
                    Fighterc fighterc = new Fighterc();
                    Fighterc fighterc2 = new Fighterc();
                    getWorld().addObject(fighterc,220,10);
                    getWorld().addObject(fighterc2,255,10);
                    madeReps=2;
                }
                makeReps=false;
            }
        }
    }
    public void setLevel(int level){
        Station.level=level;
    }
    public void cheatOn(){
        if(Greenfoot.isKeyDown("shift")&&Greenfoot.isKeyDown("b")){
            Station.cheaton =true;
            lives=100;
            if(madecheats<1){
                cheam();
            }
        }
    }
    public void cheam(){
        Cheat cheat = new Cheat();
        getWorld().addObject(cheat,43,32);
        madecheats++;
    }

    public void lifePlus(){
        if (lives < 3){
            lives++;
            if (lives == 3){
                Fighterc lifeCount = getWorld().getObjects(Fighterc.class).get(0);
                lifeCount.setImage("fighter.png");
                lifeCount.getImage().scale(25,25);
                lifeCount.setLocation(220,10);
            }
            if (lives == 2){
                Fighterc lifeCount = getWorld().getObjects(Fighterc.class).get(1);
                lifeCount.setImage("fighter.png");
                lifeCount.getImage().scale(25,25);
                lifeCount.setLocation(255,10);
            }
        }
    }

    public void decreaseLife() {
        if(lives==3){
            lives=2;
            getWorld()  .getObjects(Fighterc.class).get(0).setImage("invis.png");
            getWorld()  .getObjects(Fighterc.class).get(0).setLocation(1,1);
        }else if(lives==2){
            lives=1;
            getWorld().getObjects(Fighterc.class).get(1).setImage("invis.png");
            getWorld().getObjects(Fighterc.class).get(1).setLocation(1,1);
        }else if(lives==1){
            lives=0;
            getWorld().removeObject(this);
        }
    }
}
