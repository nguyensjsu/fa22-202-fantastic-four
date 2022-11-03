import greenfoot.*;
public class Box extends Actor
{
    public String[] images = {"blue.png","orange.png","pink.png","purple.png","teal.png","tan.png","white.png","yeller.png","red.png"};
    int fmount=0;
    public Box(String image){
        setImage(image);
    }
    public void act() 
    {
        movement();
        topReset();
        randomBlink();;
    }    
        public void randomBlink(){
        int ranNum = Greenfoot.getRandomNumber(1000);
        if(((ranNum)%50)==0){
            setImage("black.png");
            setImage(images[Greenfoot.getRandomNumber(9)]);
        }
    }
    public void movement(){
        setLocation(getX(),getY()+2);
    }
    public void topReset(){
        if(getY()==499){
            setLocation(getX(),0);
            setImage(images[Greenfoot.getRandomNumber(9)]);
        }
    }
}

