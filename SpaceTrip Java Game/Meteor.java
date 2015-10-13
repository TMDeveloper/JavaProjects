import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/** 
 * @author Vasilis Bilbilis 
 * @version 1.0 Version
 */

public class Meteor extends SmoothMover
{
    private int size;
    private int count = 2;
    private Counter counter;
    
    /** Number of fragments that meteor leaves when explodes*/
    private static final int NUM_FRAGMENTS = 40;
    
    public Meteor(Counter scoreCounter)
    {
        this(35);
        counter = scoreCounter;
        
    }
    
    public Meteor(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    
    public Meteor(int size, Vector speed)
    {
        super(speed);
        setSize(size);
    }
    
    public Meteor(Counter scoreCounter, double force)
    {
        this(50);
        addForce(new Vector(180,force));
        counter = scoreCounter;
        
    }
    
    public void explode()
    {
        placeMeteorFragments (getX(), getY(), NUM_FRAGMENTS);
    }
    
    private void placeMeteorFragments(int x, int y, int numFragments)
    {
        for (int i=0; i < numFragments; i++) {
            getWorld().addObject ( new MeteorBreaking(), x, y );
        }
    }
        
    public void act()
    {         
        move();
        Space space = (Space) getWorld();
        if(space.getGameLevel() == 1)
        {
            addForce(new Vector(180,0.1));
        }
        else
        {
            addForce(new Vector(180,0.2));
        }
        
        makeFire();
        MeteorAtEdge();
    }

    /**
     * Set the size of this Meteor. Note that stability is directly
     * related to size. Smaller Meteors are less stable.
     */
    public void setSize(int size) 
    {
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }
    
    /**
     * Hit this Meteor dealing the given amount of damage.
     */
    public void hit() 
    {
            Greenfoot.playSound("GrenadeExplosion.wav");
            explode();
            counter.add(30);
            getWorld().removeObject(this);
       
    }
    
    public void MeteorAtEdge()
    {
        if(getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }
        
    private void makeFire()
    {
        count--;
        if (count == 0) {
            getWorld().addObject ( new MeteorFire(), getX()+10, getY());
            count = 2;
        }
    }
  
}