import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/** 
 * @author Vasilis Bilbilis 
 * @version 1.0 Version
 */

public class GamePlayInfo extends Actor
{
    public static final float fontSize = 22.0f;
    public static final int width = 580;
    public static final int height = 380;
    private GreenfootImage GamePlayInfo = new GreenfootImage("ScoreBoard.png");
    
    /**
     * Create a score board for the final result.
     */
    public GamePlayInfo()
    {
        makeImage("Hi, this is SpaceTrip game!", "Use the UP, DOWN, RIGHT and LEFT buttons in" + "\n" + "order to move your spacecraft and SPACE to fire" + "\n" + "missiles and destroy as many meteorites you can"+ "\n" + "in one minute." + "\n" + "\n" +"     You are only one step away from having fun!" + "\n" + "\n" + "             Press <ENTER> to start the game!");
    }
    
    public GamePlayInfo(String aTitle, String aMessage)
    {
        String title = aTitle;
        String message = aMessage;
        makeImageLevel2(title, message);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String message)
    {
        GamePlayInfo.scale(width, height);
        Font font = GamePlayInfo.getFont();
        font = font.deriveFont(fontSize);
        GamePlayInfo.setFont(font);
        GamePlayInfo.setColor(Color.WHITE);
        GamePlayInfo.drawString(title, 170, 60);
        GamePlayInfo.drawString(message, 50, 120);
        setImage(GamePlayInfo);
    }
    
    private void makeImageLevel2(String title, String message)
    {
        GamePlayInfo.scale(500, 200);
        Font font = GamePlayInfo.getFont();
        font = font.deriveFont(fontSize);
        GamePlayInfo.setFont(font);
        GamePlayInfo.setColor(Color.WHITE);
        GamePlayInfo.drawString(title, 70, 60);
        GamePlayInfo.drawString(message, 45, 120);
        setImage(GamePlayInfo);
    }
}
