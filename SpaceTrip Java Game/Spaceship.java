import greenfoot.*;

/** 
 * @author Vasilis Bilbilis 
 * @version 1.0 Version
 */

public class Spaceship extends SmoothMover
{
    private static final int gunReloadTime = 30;
    private int reloadDelayCount = 30;
    private int movingSpeed = 15;
    private boolean isAnyKeyDown = false;
    private GreenfootImage SpaceshipBoost = new GreenfootImage("spaceshipBoost.png");
    private GreenfootImage SpaceshipNoBoost = new GreenfootImage("spaceshipNoBoost.png");
    
    
    public void act() 
    {      
       move();
       checkKeys();
       checkCollision();
       reloadDelayCount++;
    }
      
    private void checkKeys() 
    {                
        
        if(Greenfoot.isKeyDown("down"))
        {
          setImage (SpaceshipBoost);
          addForce(new Vector(90, 0.5));
        }
       
        else if(Greenfoot.isKeyDown("up"))
        {
           setImage (SpaceshipBoost);
           addForce(new Vector(270, 0.5));
        }   
        
        else if(Greenfoot.isKeyDown("left"))
        {        
           setImage (SpaceshipBoost);
           addForce(new Vector(180, 0.5));
        }
         
        else if(Greenfoot.isKeyDown("right"))
        {        
           setImage (SpaceshipBoost);
           addForce(new Vector(0, 0.5));
        }
               
        else
        {
            accelerate(0.8);
            setImage(SpaceshipNoBoost);
        }
                     
        if(Greenfoot.isKeyDown("space"))
        {
            fire();
        }
    }
       
     private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
           Missile missile = new Missile();
           getWorld().addObject (missile, getX(), getY());
           missile.move (movingSpeed);
           reloadDelayCount = 0;
        }
    }
    
    private void checkCollision() 
    {
        Actor a = getOneIntersectingObject(Meteor.class);
        if (a != null) 
        {
            Space space = (Space) getWorld();        
            space.addObject(new Explosion(), getX(), getY());
            space.removeObject(this);
            Greenfoot.delay(15);
        }
    }
}
