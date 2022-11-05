<<<<<<< HEAD
import greenfoot.*;
public class Score extends Actor
{
    private int lastScore;
    public Score(){
        test();
    }
    public void act() 
    {
        if(lastScore != Fighter.score){
            test();
            lastScore = Fighter.score;
        }            
    }    
    public void test(){
        //GreenfootImage[] digitImage= {image1,image2,image3,image4,image5,image6,image7,image8,image9,image0};
        String numberString = ""+Fighter.score; //"convert" score int to string
        int digitCount = numberString.length(); 
        GreenfootImage[] digitImages = new GreenfootImage[digitCount]; //creates array of int length
        int textImageWidth = 0; //digit image width sum
        //for each digit create image object and add to array, add width to above int
        for (int i=0; i<digitCount; i++)
        {
            digitImages[i] = new GreenfootImage(""+numberString.charAt(i)+".png");
            textImageWidth += digitImages[i].getWidth();
        }
        GreenfootImage textImage = new GreenfootImage(textImageWidth, digitImages[0].getHeight()); //create image
        int drawPosition = 0; //x position for each digit
        for (int i=0; i<digitImages.length; i++)
        {
            textImage.drawImage(digitImages[i], drawPosition, 0); //add image digit image to final image
            drawPosition += digitImages[i].getWidth();//add to x postion so images don't overlap
        }
        setImage(textImage);
    }
}
=======
import greenfoot.*;
public class Score extends Actor
{
    private int lastScore;
    public Score(){
        test();
    }
    public void act() 
    {
        if(lastScore != Fighter.score){
            test();
            lastScore = Fighter.score;
        }            
    }    
    public void test(){
        //GreenfootImage[] digitImage= {image1,image2,image3,image4,image5,image6,image7,image8,image9,image0};
        String numberString = ""+Fighter.score; //"convert" score int to string
        int digitCount = numberString.length(); 
        GreenfootImage[] digitImages = new GreenfootImage[digitCount]; //creates array of int length
        int textImageWidth = 0; //digit image width sum
        //for each digit create image object and add to array, add width to above int
        for (int i=0; i<digitCount; i++)
        {
            digitImages[i] = new GreenfootImage(""+numberString.charAt(i)+".png");
            textImageWidth += digitImages[i].getWidth();
        }
        GreenfootImage textImage = new GreenfootImage(textImageWidth, digitImages[0].getHeight()); //create image
        int drawPosition = 0; //x position for each digit
        for (int i=0; i<digitImages.length; i++)
        {
            textImage.drawImage(digitImages[i], drawPosition, 0); //add image digit image to final image
            drawPosition += digitImages[i].getWidth();//add to x postion so images don't overlap
        }
        setImage(textImage);
    }
}
>>>>>>> 1361153b5f101c364e745cd82527e23f2b9dcddd
