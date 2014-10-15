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

Particle[] starz;
public void setup()
{
	size(1000, 900);
	background(0);
	starz = new Particle[50];
	for (int i = 0; i < starz.length - 5; i++)
	{
		starz[i] = new NormalParticle();
	}
	starz[starz.length-1] = new OddballParticle();
	starz[starz.length-2] = new OddballParticle();
	starz[starz.length-3] = new OddballParticle();
	starz[starz.length-4] = new OddballParticle();
	starz[starz.length-5] = new OddballParticle();
}
public void draw()
{
	if ((int)((NormalParticle)starz[0]).dX == 500)
	{
		background(0);
	}
	if ((int)((OddballParticle)starz[49]).dXX == 500)
	{
		background(0);
	}
	for (int i = 0; i < starz.length; i++)
	{
		starz[i].move();
		starz[i].show();
	}
}
class NormalParticle implements Particle
{
	double dX, dY, dTheta, dSpeed;
	NormalParticle()
		{
			dX = 500;
			dY = 500;
			dTheta = Math.random()*2*Math.PI;
			dSpeed = Math.random()*11;
		}
	public void move()
		{
			dX = dX + Math.cos(dTheta)*dSpeed;
			dY = dY + Math.sin(dTheta)*dSpeed;
			dTheta += 0.01f;
		}
	public void show()
	{
		stroke(0, 153, 0);
		fill(0, 255, (int)(Math.random()*256));
		ellipse((float)dX, (float)dY, 10, 10);
	}
}
interface Particle
{
	public void move();
	public void show();
}

class OddballParticle implements Particle
{
	double dXX, dYY, dThetaO, dSpeedO;
	OddballParticle()
	{
		dXX = 500;
		dYY = 500;
		dThetaO = Math.random()*2*Math.PI;
		dSpeedO = Math.random()*11;
	}
	public void move()
	{
		dXX = dXX + (int)(Math.random()*5)-2;
		dYY = dYY + Math.cos(dThetaO)*dSpeedO;
		dThetaO += 0.05f;
	}
	public void show()
	{
		stroke(0, 0, 255);
		fill((int)Math.random()*256, 192, 192);
		ellipse((float)dXX, (float)dYY, 15, 15);
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
