import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/** 
 * @author Vasilis Bilbilis 
 * @version 1.0 Version
 */

public class ScoreBoard extends Actor
{
    public static final float fontSize = 38.0f;
    public static final int width = 400;
    public static final int height = 300;
    private GreenfootImage scoreBoard = new GreenfootImage("ScoreBoard.png");
    
    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {
        makeImage("Game Over", "Your Score is: ", score, "You can do better,", "Try Again!");
    }

     public ScoreBoard(int score, String title)
    {
        makeWinnerImage(title, "Your Score is: ", score, "You can always try again for a better score!");
    }
    
    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score, String message1, String message2)
    {
        scoreBoard.scale(width, height);
        Font font = scoreBoard.getFont();
        font = font.deriveFont(fontSize);
        scoreBoard.setFont(font);
        scoreBoard.setColor(Color.WHITE);
        scoreBoard.drawString(title, 100, 70);
        scoreBoard.drawString(prefix + score, 35, 130);
        scoreBoard.drawString(message1, 50, 200);
        scoreBoard.drawString(message2, 120, 250);
        setImage(scoreBoard);
    }
    
    private void makeWinnerImage(String title, String prefix, int score, String message)
    {
        scoreBoard.scale(500, 280);
        Font font = scoreBoard.getFont();
        font = font.deriveFont(22.0f);
        scoreBoard.setFont(font);
        scoreBoard.setColor(Color.WHITE);
        scoreBoard.drawString(title, 75, 70);
        scoreBoard.drawString(prefix + score, 140, 150);
        scoreBoard.drawString(message, 50, 200);
        setImage(scoreBoard);
    }
}
