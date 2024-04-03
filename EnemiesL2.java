// This is a class for the Enemies 
class xBad
{
  color c;
  float xpos, ypos, xspeed, radius;
  
  // constructor for enemy details
  xBad(float x, float s, float r)    
  {
    c = color(255,0,0);
    xpos = x;
    ypos = (random(height));
    xspeed = s;
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
    xpos += xspeed;
    if (xpos > width)
    {
      xpos = 0;
      ypos = (random(height));
    }
  }
    
}