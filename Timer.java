// This is a class for the timer
class Timer
{
  float Time;
  
  Timer(float set)  // constructor
  {
    Time = set;
  }
  
  float getTime()  // returns the current time
  {
    return(Time);
  }
  
  void setTimer(float set)  // set the timer 
  {
    Time = set;
  }
  
  void count() // update timer 
  {
    Time += 1/frameRate;
  }
}