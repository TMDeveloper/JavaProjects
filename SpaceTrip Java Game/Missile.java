import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/** 
 * @author Vasilis Bilbilis 
 * @version 1.0 Version
 */

public class Missile extends SmoothMover
{    
    /** A missile looses one life each act, and will disappear when life = 0 */
    private int life = 55;
    private int movingSpeed = 15;
    private Counter counter;
            
    public Missile()
    {
        move(movingSpeed);
    }
        
    public void act()
    {
        if(life <= 0) 
        {
            getWorld().removeObject(this);
        } 
        else 
        {
            life--;
            move(movingSpeed);
            checkMeteorHit();
        }
    }
    
    private void checkMeteorHit()
    {
        Meteor meteor = (Meteor) getOneIntersectingObject(Meteor.class);
        if (meteor != null)
        {
            getWorld().removeObject(this);
            meteor.hit();
        }
    }
}