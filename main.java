// ========= Import Images ===========
PImage playImg;
PImage introImg;

// ======= Import audio =========
import processing.sound.*;
SoundFile file; 

// Objects for the timer, player, enemies
Timer startTimer;
Player player;
Bad[] GreenBad = new Bad[4];    // array for multiple y axis enemies
xBad[] xGBad = new xBad[5];

// Game states 
int menu;
public final int INTRO = 1;
public final int PLAY = 2;
public final int GAMEOVER = 3;

// set up function that begins at the INTRO screen
void setup()
{
  size (768,432); 
  playImg = loadImage("moonSurface.png");
  introImg = loadImage("introImg.jpg");
  
  // loop to for all enemy details
  for (int i = 0; i < GreenBad.length; i++)   
    GreenBad[i] = new Bad(20+i*15, 6, 25);
  
  for (int i = 0; i < xGBad.length; i++)
    xGBad[i] = new xBad (20+i*15, 6, 25);
  
  player = new Player(250,350,25);    // player details
  startTimer = new Timer(0);         // begins timer at 0.000
  file = new SoundFile(this, "playMusic.mp3");
  file.loop();
  menu = INTRO;                      // game state will begin in INTRO variable 
}


// draw function that loops 
void draw()
{  
  // function to switch between different menus 
  switch(menu)  
  {
    // ======== main menu screen ===========
    case INTRO:  
    background(introImg);
    introScreen("WATCH OUT!", "Press y to start");
    break;
    
    // ========== game over screen ==========
    case GAMEOVER:  
      file.stop();
      background(0);
      overScreen("GAME OVER!", "Press y to try again");
      text("Your Score: ", 320, 90);
      // displays final time for score 
      text(startTimer.getTime(), 450, 90);
      break;
      
      // ========= play screen =========
    case PLAY:  
      background(playImg);
      startTimer.count();
      
      // timer position
      fill(255, 0, 0);
      text(startTimer.getTime(), 50, 40);
      
      // player movements and display
      player.move();
      player.display();
      
      if (startTimer.getTime() <= 10)
        {
          for (int i = 0; i < GreenBad.length; i++)
            {
              GreenBad[i].move();
              GreenBad[i].display();
            }
          
          for (int i = 0; i < GreenBad.length; i++)
            {
              if (dist(player.xpos, player.ypos, GreenBad[i].xpos, GreenBad[i].ypos) < ((player.radius + GreenBad[i].radius/2)))
                menu = GAMEOVER;
            }
        }
      else if ( startTimer.getTime() >= 10 && startTimer.getTime() <= 20)
        {
          for (int i = 0; i < xGBad.length; i++)
            {
              xGBad[i].move();
              xGBad[i].display();
            }
              
          for ( int i = 0; i < xGBad.length; i++)
            {
              if (dist(player.xpos, player.ypos, xGBad[i].xpos, xGBad[i].ypos) < ((player.radius + xGBad[i].radius/2)))
                menu = GAMEOVER;
            }
        }
        
      else 
         {
           for (int i = 0; i < GreenBad.length; i++)
            {
              GreenBad[i].move();
              GreenBad[i].display();
            }
          
          for (int i = 0; i < GreenBad.length; i++)
            {
              if (dist(player.xpos, player.ypos, GreenBad[i].xpos, GreenBad[i].ypos) < ((player.radius + GreenBad[i].radius/2)))
                menu = GAMEOVER;
            }
           for (int i = 0; i < xGBad.length; i++)
            {
              xGBad[i].move();
              xGBad[i].display();
            }
              
          for ( int i = 0; i < xGBad.length; i++)
            {
              if (dist(player.xpos, player.ypos, xGBad[i].xpos, xGBad[i].ypos) < ((player.radius + xGBad[i].radius/2)))
                menu = GAMEOVER;
            }
         }      
      break;
  }
}


// function to switch between different game states. 
void keyPressed()
{
  if (key == 'y' && (menu == INTRO || menu == GAMEOVER))
    {
      file.stop();
      setup();
      menu = PLAY;
    }
}


// function to display title and instructions of INTRO game states 
void introScreen(String title, String instructions)
{
  
  // draw title
  fill(255,0,0);
  textSize(60);
  textAlign(CENTER,BOTTOM);
  text(title, width/2, height/4.5);
  
  // draw instructions
  fill(0,255,0);
  textSize(32);
  text(instructions, 380, 230);
}

void overScreen(String title, String instructions)
{
  
  // draw title 
  fill(255,0,0);
  textSize(80);
  textAlign(CENTER,BOTTOM);
  text(title, width/2.15, height/1.75);
  
  // draw instructions
  fill(0, 255, 0);
  textSize(32);
  text(instructions, 370, 350);
}