// This is a class for the player character
class Player   
{
  
  color c;
  float xpos, ypos, radius;
  
  Player(float x, float y, float r)  // constructor with key details of player
  {
    c = color(0,255,0);
    xpos = x;
    ypos = y;
    radius = r;
  }
  
  void display()    // function to display player
  {
    noStroke();
    fill(c);
    ellipse(xpos, ypos, radius, radius);
  }
  
  void move()    // function for player's movements along the x-axis
  {
    if (key == CODED)
    {
      if (keyCode == LEFT)  // if statement to control player's left movement at specific speed 
        xpos -=7;        
          if (xpos < 0)    // if statement to have player loop from left to right side of window
            xpos = 0;
     else if (keyCode == RIGHT)  // if statement to control player's right movement at specific speed
       xpos +=7;
         if (xpos > width)     // if statement to have player loop around from right to left side of window
           xpos = width;
     else if (keyCode == UP)
       ypos -= 7;
         if (ypos < 0)
           ypos = 0;
     else if (keyCode == DOWN)
       ypos += 7;
         if (ypos > height)
           ypos = height;
    }
  }
}
  