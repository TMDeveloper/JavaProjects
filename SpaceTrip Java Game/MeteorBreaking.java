import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/** 
 * @author Vasilis Bilbilis 
 * @version 1.0 Version
 */

public class MeteorBreaking extends SmoothMover
{    
    private int life = 50;
    private double exactX;
    private double exactY;
    
    public MeteorBreaking()
    {     
        GreenfootImage img = getImage();
        int width = Greenfoot.getRandomNumber(30) + 1;
        int height = Greenfoot.getRandomNumber(30) + 1;
        img.scale (width, height);
        
        setRotation (Greenfoot.getRandomNumber(360));
    }
    
    public void act() 
    {       
        exactX = getExactX();
        exactY = getExactY();
        
        if(life <= 0) 
        {
            getWorld().removeObject(this);
        } 
        else 
        {
            life--;
            move(10);
        }
    }
}
