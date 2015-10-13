import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.List;

/** 
 * @author Vasilis Bilbilis 
 * @version 1.0 Version
 */

public class Counter extends Actor
{
    private static final Color textColor = new Color(255, 255, 255);
    public static final float fontSize = 14.0f;
    private int scoreValue = 0;
    private int livesValue = 3;
    private int target = 0;
    private String score;
    private String lives;
    private int stringLength = 250;

    public Counter(String scoreText, String livesText)
    {
        score = scoreText;
        lives = livesText;
        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.setColor(textColor);
        Font font = image.getFont();
        font = font.deriveFont(fontSize);
        image.setFont(font);            
        updateImage();
    }
    
    public void act() {
        if(scoreValue < target) {
            scoreValue += 5;
            updateImage();
        }
        else if(scoreValue > target) {
            scoreValue -= 5;
            updateImage();
        }
        
        if(getWorld().getObjects(Spaceship.class).size()==0 && livesValue > 1)
        {
            livesValue--;
            List allMeteors = getWorld().getObjects(Meteor.class);
            getWorld().removeObjects(allMeteors);
            updateImage();
            Spaceship spaceship = new Spaceship();
            getWorld().addObject(spaceship, getWorld().getWidth()/12 , getWorld().getHeight()/2);
        }
        else if(getWorld().getObjects(Spaceship.class).size()==0 && livesValue == 1)
        {
            livesValue = 0;
            Space space = (Space) getWorld();
            updateImage();
            space.gameOver();
        }
    }

    public void add(int scoreText)
    {
        target += scoreText;
    }
   
    public int getScoreValue()
    {
        return scoreValue;
    }
    
    public void updateImage()
    {
        GreenfootImage Image = getImage();
        Image.clear();
        Image.drawString(score + scoreValue + "  " + lives + livesValue, 20, 12);
    }
    
}
