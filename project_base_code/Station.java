import greenfoot.*;
import java.io.*;  
public class Station extends Actor
{
    public int fmount=1;
    public static int level=0;
    GreenfootSound stheme = new GreenfootSound("stheme.mp3");
    GreenfootSound slevel = new GreenfootSound("levelstart.mp3");
    public boolean makeZako1;
    public boolean makeGoei1;
    public int goeismadeat1;
    public boolean makeGoei2;
    public static boolean gameover;
    public boolean makeBoss;
    public static boolean cheaton;
    public Station(){
        //getImage().scale(100,100);
    }
    public void act()
    {
        menuAway();
        levelCommands();
        changeLevel();
        gameOver();
    }    
    public void menuAway(){
        Object menu = getWorld().getObjects(Menu.class);
        if( (!getWorld().getObjects(Menu.class).isEmpty()&&(menu!=null))&&(Greenfoot.isKeyDown("space"))){
            getWorld().removeObjects(getWorld().getObjects(Zako.class));
            removeMenu();
            //stheme.play();
            makeFighter();
            level=1;
            level1Truths();
            Fighter.makeReps=true;
            cheaton=false;
            Fighter.lives=3;
            Fighter.score=0;
        }
    }   
    public void removeMenu(){
        if(!getWorld().getObjects(Menu.class).isEmpty()){
           getWorld().removeObjects(getWorld().getObjects(Menu.class));
        }
    }
    public void makeFighter(){
        if(fmount>0){
            Fighter fighter = new Fighter();
            getWorld().addObject(fighter,250,470);
            Fighter.lives=3;
            fmount = fmount -1;
            Score score = new Score();
            getWorld().addObject(score,473,10);
        }   
    }
    public void makeZako(int xcord,int ycord){
        Zako zako = new Zako();
        getWorld().addObject(zako,xcord,ycord);
    }
    public void makeBoss(int xcord,int ycord){
        Boss boss = new Boss();
        getWorld().addObject(boss,xcord,ycord);
        boss.health=30;
    }
    public void makeGoei(int xcord,int ycord){
        Goei goei = new Goei();
        getWorld().addObject(goei,xcord,ycord);
        goeismadeat1++;
    }
    public void level1Truths(){
        makeZako1=true;
        makeGoei1=true;
        makeBoss=true;
    }
    public void changeLevel(){
        if(level==1){
            if((getWorld().getObjects(Zako.class).isEmpty())&&(getWorld().getObjects(Goei.class).isEmpty()) ){
                makeGoei2=true;
                level=2;
                makeZako1=true;
                makeGoei1=true;
                goeismadeat1=0;
                slevel.play();
            }
        }
    }
    public void gameOver(){ 
        if(level>0&&getWorld().getObjects(Fighter.class).isEmpty()){
            if(getWorld().getObjects(Gover.class).size()<1){
                Gover gover = new Gover();
                getWorld().addObject(gover,250,250);
                gameover=true;
            }
        }
    }
    public void levelCommands(){
       if((level==1)){
           if(makeZako1){
               for(int x=0;x<5;x++){
                   makeZako(150+(x*50),50);
                   makeZako(150+(x*50),100);
               }
               makeZako1=false;
           }
        }
       if((level==1)){
           if((makeGoei1)&&(goeismadeat1<8)){
               for(int x=0;x<8;x++){
                   makeGoei(75+(x*50),135);
               }
               makeGoei1=false;
           }      
       }       
       if((level==2)){
           if((makeGoei1)&&(goeismadeat1<16)){
               for(int x=0;x<8;x++){
                   makeGoei(75+(x*50),135);
               }
               for(int x=0;x<8;x++){
                   makeGoei(75+(x*50),175);
               }
               makeGoei1=false;
           }     
       } 
       if(level==2){
           if(makeZako1){
               for(int x=0;x<5;x++){
                   makeZako(150+(x*50),50);
                   makeZako(150+(x*50),100);
               }
               makeZako1=false;
           }
       }
       if(level==2){
            if((getWorld().getObjects(Zako.class).isEmpty())&&(getWorld().getObjects(Goei.class).isEmpty()) ){
                makeGoei2=true;
                level=3;
                makeZako1=true;
                makeGoei1=true;
                goeismadeat1=0;
                slevel.play();
            }
       }
       if(level==3){
           if(makeBoss){
               for(int x=0;x<1;x++){
                   makeBoss(250,70);
               }
               getWorld().removeObjects(getWorld().getObjects(Bomb.class));
               makeBoss=false;
           }
       }
    }

}

    

