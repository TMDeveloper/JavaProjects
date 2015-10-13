import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


public abstract class SmoothMover extends Actor
{
    private Vector movement;
    private double exactX;
    private double exactY;
    private int movingSpeed = 4;
    
    public SmoothMover()
    {
        this(new Vector());
    }
    
    /**
     * Create new thing initialised with given speed.
     */
    public SmoothMover(Vector movement)
    {
        this.movement = movement;
    }
    
    /**
     * Move in the current movement direction. Wrap around to the opposite edge of the
     * screen if moving out of the world.
     */
    public void move() 
    {
        exactX = exactX + movement.getX();
        exactY = exactY + movement.getY();
        if(exactX >= getWorld().getWidth()) {
            exactX = getWorld().getWidth();
        }
        if(exactX < 0) {
            exactX = 0;
        }
        if(exactY >= getWorld().getHeight()) {
            exactY = 0;
        }
        if(exactY < 0) {
            exactY = getWorld().getHeight() - 1;
        }
        super.setLocation((int) exactX, (int) exactY);
    }
         
    public void missileMove() 
    {
        exactX = exactX + movement.getX();
        exactY = exactY;
        if(exactX >= getWorld().getWidth()) {
            exactX = getWorld().getWidth();
        }
        if(exactX < 0) {
            exactX = 0;
        }
        super.setLocation((int) exactX, (int) exactY);
    }
    
    /**
     * Set the location from exact coordinates.
     */
    public void setLocation(double x, double y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation((int) x, (int) y);
    }
    
    /**
     * Set the location from int coordinates.
     */
    public void setLocation(int x, int y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }

    /**
     * Return the exact x-coordinate (as a double).
     */
    public double getExactX() 
    {
        return exactX;
    }

    /**
     * Return the exact y-coordinate (as a double).
     */
    public double getExactY() 
    {
        return exactY;
    }

    /**
     * Increase the speed with the given vector.
     */
    public void addForce(Vector force) 
    {
        movement.add(force);
    }
    
    /**
     * Accelerate the speed of this mover by the given factor. (Factors < 1 will
     * decelerate.)
     */
    public void accelerate(double factor)
    {
        movement.scale(factor);
        if (movement.getLength() < 0.15) {
            movement.setNeutral();
        }
    }
    
    /**
     * Return the speed of this actor.
     */
    public double getSpeed()
    {
        return movement.getLength();
    }
    
    /**
     * Stop movement of this actor.
     */
    public void stop()
    {
        movement.setNeutral();
    }
    
    /**
     * Return the current speed.
     */
    public Vector getMovement() 
    {
        return movement;
    }
}
