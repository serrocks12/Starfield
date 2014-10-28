import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle [] myParticle = new Particle[50]; //your code here

public void setup()
{
	background(0);
	size(500,500);
	for (int nI = 0; nI < 50; nI++) 
	{
		if(nI == 0){myParticle[0] = new OddballParticle(250,250);}
		else if(nI == 1){myParticle[1] = new JumboParticle(250,250);}
		else{myParticle[nI] = new NormalParticle(250,250);}
		
		
	}
	
	
}
public void draw()
{
	for( int nI = 0; nI <50 ; nI++)
	{
		myParticle[nI].move();
		myParticle[nI].show();
	}
	//your code here
}
class NormalParticle implements Particle
{
	int r,g,b;
	double myX, myY;
	double dSpeed, dDirection;
	NormalParticle(int x, int y)
	{
		b = ((int)(Math.random()*266));
		g = ((int)(Math.random()*266));
		r = ((int)(Math.random()*266));
		myX = x;
		myY = y;
		dSpeed = Math.random()*10;
		dDirection = Math.PI*2*Math.random();	
			
	}
	NormalParticle()
	{
		dSpeed = Math.random()*10;
		dDirection = Math.PI*2*Math.random();	
			
	}
	public void move()
	{
 		myX += Math.cos(dDirection)*dSpeed;
 		myY += Math.sin(dDirection)*dSpeed;
	}
	public void show() 
	{
		fill(r,g,b);
		ellipse((int)myX, (int)myY, 20, 20);
	}
}

class JumboParticle extends NormalParticle
{
	JumboParticle(int x, int y)
	{
		myX = x;
		myY = y;
	}

	
	public void show()
	{
		fill(255, 0, 0);
		ellipse((int)myX, (int)myY, 55, 55);
	}
	
}


interface Particle
{
	 public void move();
	 public void show(); 
}
class OddballParticle implements Particle
{
	double myX, myY;

	OddballParticle(int x, int y)
	{
		
		myX = x;
		myY = y;
	}
	public void move() 
	{
		myX = myX + Math.random()*11-5;
		myY = myY + Math.random()*11-5;	
	}
	public void show() 
	{
		fill(22,3,144);
		rect((int)myX, (int)myY, 40, 40);
	}
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
