// This is a class for the Enemies 
class Bad
{
  color c;
  float xpos, ypos, yspeed, radius;
  
  // constructor for enemy details
  Bad(float y, float s, float r)    
  {
    c = color(255,0,0);
    xpos = (random(width));
    ypos = y;
    yspeed = s;
    radius = r;
  }
  
  // function to display enemies 
  void display()
  {
    stroke(0);
    fill(c);
    ellipse(xpos, ypos, radius, radius);
  }
  
  // function to have enemies move up and down window 
  void move()
  {
    ypos += yspeed;
    if (ypos > height)
    {
      ypos = 0;
      xpos = (random(width));
    }
  }
    
}