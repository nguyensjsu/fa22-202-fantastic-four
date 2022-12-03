import greenfoot.*;
public class J20Sample extends Fighter
{
    private int time;
    public static int score;
    public static int lives =3;
    public static int fighterlevel = 1;
    public static boolean makeReps;
    private int madeReps=0;
    public int madecheats =0;

    // fire support functionality
    protected int fsTime;
    protected FireSupportStrat currentFS;
    protected FireSupportStrat fsRadial;
    protected FireSupportStrat fsWave;
    protected FireSupportStrat fsNone;

    // damage handling
    protected Shield shield;
    protected Hull hull;
    protected IDamageTarget damageChain;

    // powerup implementation
    protected PuState currentPU;
    protected PuStateNone puNone;
    protected PuStateFS1 puFS1;
    protected PuStateFS2 puFS2;
    protected PuStateShield puShield;
    protected int puTimer;

    GreenfootSound fire = new GreenfootSound("fire.mp3");

    public J20Sample(){
        setPic();

        setParams();

        setPuState("none");
    }

    public int getScore() {
        return score;
    }
    
    public void setScore(int s) {
        score = s;
    }
    
    private void setPic() {
        setImage("j20.png");
        getImage().scale(50,50);
    }
    
    private void setParams(){
        this.shield = new Shield(this);
        this.hull = new Hull(this);
        this.shield.setNext((IDamageTarget)hull);
        this.damageChain = (IDamageTarget)shield;

        fsTime = 0;
        currentFS = new FireSupportStrat(this);
        fsRadial = new FsRadial(this);
        fsWave = new FsWave(this);
        fsNone = new FireSupportStrat(this);

        puNone = new PuStateNone(this);
        puFS1 = new PuStateFS1(this);
        puFS2 = new PuStateFS2(this);
        puShield = new PuStateShield(this);
        puTimer = 0;
    }

    public void act() 
    {
        movement();
        time++;
        fsTime++;
        setLivesRep();
        Bombed();
        cheatOn();
        Fighterlevel();
        powerUpCheck();
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
        if(Greenfoot.isKeyDown("d")){
            //System.out.println("pressing D");
            fireSupport();
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
        if(bomb != null){
            getWorld().removeObject(bomb);
            takeHit();
        }
        // Changed logic for Boss attacks
        // Original: all boss attacks one-shot the player
        // Modified: bomb only does 1 damage, blaser does 3
        if(blaser != null){
            getWorld().removeObject(blaser);
            takeHit();
            if(lives > 0) takeHit();
            if(lives > 0) takeHit();
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

    // Use public methods for increasing and decreasing life
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

    public void lifeMinus(){
        if(lives == 3){
            lives--;
            Fighterc lifeIcon = getWorld().getObjects(Fighterc.class).get(0);
            lifeIcon.setImage("invis.png");
            lifeIcon.setLocation(1,1);
        }
        else if(lives == 2){
            lives--;
            Fighterc lifeIcon = getWorld().getObjects(Fighterc.class).get(1);
            lifeIcon.setImage("invis.png");
            lifeIcon.setLocation(1,1);
        }
        else if(lives == 1){
            lives--;
            getWorld().removeObject(this);
        }
    }

    /***
     * Add fire support feature
     */
    public void fireSupport(){
        if(fsTime > 100){
            currentFS.boom();
            fsTime = 0;
        }
    }

    public void setFS(FireSupportStrat fs){
        currentFS = fs;
        //System.out.println(currentFS.toString());
    }

    /*** 
     * Add chain of responsibility for taking damage
     */

    

    /***
     * Add power up states to enable powerup features
     */
    public void setPuState(String arg){
        switch(arg) {
            case "none":
                currentPU = puNone;
                break;
            case "fsRadial":
                currentPU = puFS1;
                break;
            case "fsWave":
                currentPU = puFS2;
                break;
            case "shield":
                currentPU = puShield;
                break;
            default:
                currentPU = puNone;
        }
        //System.out.println("fighter.setPuState(): " + arg);
        currentPU.activate();
    }

    public void setPuTimer(int seconds){
        this.puTimer = seconds * 60;
    }

    private void powerUpCheck(){
        if(puTimer == 1){
            setPuState("none");
        }
        if(puTimer > 0){
            puTimer--;
        }
    }

    public void takeHit(){
        damageChain.takeHit();
    }
}


