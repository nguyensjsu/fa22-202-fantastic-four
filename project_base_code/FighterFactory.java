import greenfoot.*;
interface FighterFactory
{
    public static int getScore();
    public static void setScore(int s);
    public void lifePlus();
    public void lifeMinus();
    public void setFS(FireSupportStrat f);
    public void setPuState(String s);
    public void setPuTimer(int i);
}
