import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import javax.swing.*;

/** 
 * @author Vasilis Bilbilis 
 * @version 1.0 Version
 */

public class Space extends World
{
    private int startMeteors = 3;
    private boolean programIsRunning = true;
    Counter scoreCounter = new Counter("Your Score: ", "Lives left: ");
    Clock clock = new Clock(true, true, 60, "Time left:");
    private boolean gameJustStarted = true;
    private int gameLevel;
    private boolean level1Passed = false;
    private boolean gameStart = false;
    private int aCounter = 0;
    private GamePlayInfo gameInfo;
    /** If count reaches a value it stops the program execution, to avoid infinite loop */
    private int count = 0;
    GreenfootImage imageLevel1 = new GreenfootImage("space.jpg");
    GreenfootImage imageLevel2 = new GreenfootImage("SpaceHarder.jpg");
            
    public Space() 
    {
        super(900, 600, 1);
        setBackground(imageLevel1);
        gameLevel = 1;
        prepare();        
    }
    
    public Space(int keepScore, int level) 
    {
        super(900, 600, 1);
        setBackground(imageLevel2);
        scoreCounter.add(keepScore);
        gameLevel = level;
        prepare();        
    }
    
    public void act()
    {
       clock.stopClock();
       addGamePlayInfo();
       addObject(gameInfo, getWidth()/2, getHeight()/2);
       
       
       while(! "enter".equals(Greenfoot.getKey()) && gameStart == false)
       {
           count++;
           Greenfoot.delay(1);
           if(count == 1000) 
           {
               Greenfoot.stop();
               break;
           }
       }
       gameStart = true;
       removeObject(gameInfo);
       //clock.startClock();
       
       if(programIsRunning)
       {
           clock.startClock();
           checkGameState();
           aCounter++;
       }
    }
       
    private void addGamePlayInfo()
    {
        if(gameLevel == 2)
       {
           gameInfo = new GamePlayInfo("You successfully completed Level 1!", "Press <ENTER> to continue to next level!");          
       }
       else
       {
           gameInfo = new GamePlayInfo();
       }
    }
    
    public void addMeteor(int startMeteors) 
    {
            for(int i = 0; i < startMeteors; i++) 
            {
                int x = (getWidth()+ 20);
                int y = getRandomNumber(25,575);
                addObject(new Meteor(scoreCounter), x, y);
            }
    }
    
    public int getGameLevel()
    {
        return gameLevel;
    }
        
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }

    public void checkMeteorOnSpace()
    {
        int meteorsNum = getObjects(Meteor.class).size();
        if(meteorsNum == 0)
        {
            addMeteor(startMeteors);
        }
              
         if(aCounter == 1500)
        {
            startMeteors++;
        }
        
        if(aCounter == 2500)
        {
            startMeteors++;
        }
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Spaceship spaceship = new Spaceship();
        addObject(spaceship, getWidth()/12 , getHeight()/2);    
        addObject(scoreCounter, 450, 575);
        addMeteor(startMeteors);
        addObject(clock, getWidth()/2, getHeight()/12);
        //clock.startClock();
    }
    
    private void checkGameState()
    {   
        checkMeteorOnSpace();
        checkNextLevel();
    }
        
    private void checkNextLevel()
    {       
            if (gameJustStarted)
            {
                gameJustStarted = false;
            }
            else if (gameLevel==1 && clock.timeUp()) 
            {
                gameLevel = 2;
                Greenfoot.playSound("Winner.mp3");
                Greenfoot.playSound("AudienceClap.mp3");
                Greenfoot.setWorld(new Space(scoreCounter.getScoreValue(), gameLevel));
            }
            else if (gameLevel==2 && clock.timeUp())
            {
                Greenfoot.playSound("Winner.mp3");
                Greenfoot.playSound("AudienceClap.mp3");
                removeObjects(getObjects(Meteor.class));
                removeObjects(getObjects(Spaceship.class));
                programIsRunning = false;
                clock.stopClock();
                int score = scoreCounter.getScoreValue();
                Greenfoot.delay(10);
                String text = "                Congratulations!" + "\n" + "You succefully completed the game!";
                addObject(new ScoreBoard(score, text),  getWidth()/2, getHeight()/2);
                Greenfoot.stop();
            }
    }
              
     /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        removeObjects(getObjects(Meteor.class));
        removeObjects(getObjects(Spaceship.class));
        programIsRunning = false;
        clock.stopClock();
        int score = scoreCounter.getScoreValue();
        Greenfoot.delay(10);
        addObject(new ScoreBoard(score), getWidth()/2, getHeight()/2);
        Greenfoot.playSound("gameLost.mp3");
    }
}