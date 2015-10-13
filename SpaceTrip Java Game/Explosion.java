import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Explosion extends Actor
{
    /** How many images should be used in the animation of the explostion */
    private final static int IMAGE_COUNT= 45;
    
    /** 
     * The images in the explosion. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    /** Current size of the explosion */
    private int imageNo = 0;
    
    /** How much do we increment the index in the explosion animation. */
    private int increment=1;
    
    /**
     * Create a new explosion.
     */
    public Explosion() 
    {
        initializeImages();
        setImage(images[0]);
        Greenfoot.playSound("SpaceShipCrash.wav");
    }    
    
    /** 
     * Create the images for explosion.
     */
    public synchronized static void initializeImages() 
    {
        if(images == null) {
            GreenfootImage baseImage = new GreenfootImage("explosion.png");
            images = new GreenfootImage[IMAGE_COUNT];
            for (int i = 0; i < IMAGE_COUNT; i++)
            {
                int size = (i+1) * ( baseImage.getWidth() / IMAGE_COUNT );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    public void act()
    { 
        setImage(images[imageNo]);

        imageNo += increment;
        if(imageNo == IMAGE_COUNT) {
            getWorld().removeObject(this);
        }
        
        if(imageNo < 0) {
            getWorld().removeObject(this);
        }
    }
}