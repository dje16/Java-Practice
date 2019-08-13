package asteroidgame;

import blobz.PolyBlob;
import blobz.BlobAction;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.KeyEvent;
import blobz.BlobProximity;
import blobz.BlobUtils;
import blobz.SandBox;

//extend PolyBlob and implement BlobAction and Blob Proximity
public class Rocket extends PolyBlob implements BlobAction,BlobProximity {
	
	//The Rocket class should also have these instance variables:
	//private double angle = 0.0; private final double delta = 0.15;
	//and private final double speed = 5.0; . 
	private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    
    SandBox mySandBox;

    // Create rocket using setPolygon.Change point to see effects (Part E)
    private Point [] p = {
            new Point(10, 0),
            new Point(-10, -5),
            new Point(-5, 0),
            new Point(-10, 5),
    };
    //constructor should take two input integer arguments x and y
    public Rocket(int xcoord, int ycoord,SandBox sb) {

       //use super for stationary PolyBlob
        super(xcoord, ycoord, 0); //or (300,300,0)
        mySandBox = sb;
        angle = 0;
        setPolygon( p );
        //Rocket is red on Webcources but you can set to any color here
        setColor( Color.blue );
        
    }
    //Since the Rocket class implements the BlobAction interface, 
    //the Rocket class must have a public void keyAction(KeyEvent e) method. 
    //This method should have separate processing blocks for handling key 
    //codes 37 (left arrow), 38 (up arrow), and 39 (right arrow).
    @Override
    public void keyAction( KeyEvent e ) {
    	
    	//The variable "angle" keeps track of the orientation of your rocket. 
    	//It is initially set to zero (in step E, above), which represents pointing 
    	//to the right as you look at the screen. Turning to the right will involve 
    	//adding "delta" to the current angle. Turning to the left will involve subtracting 
    	//delta from the current angle. You will need to  add or subtract 2*PI as appropriate to
    	//keep the current angle within the range from 0 to 2*PI. Each time a key is press, you must
    	//determine what the new angle should be, and then you should update the rocket's orientation using 
    	//the setAngle() method.
    	
        // Left Arrow: Update angle counterclockwise.
    	if ( e.getKeyCode() == 37 ) {
            if ( angle - delta < 2*Math.PI ) {
                angle = angle - delta + 2*Math.PI;
                super.setAngle(angle);
            }
            else {
                angle = angle - delta;
                super.setAngle(angle);
            }
        }

        // Up Arrow: Update x and y location.
        else if ( e.getKeyCode() == 38 ) {
            Point p = super.getLoc();
            p.x = p.x + (int) Math.round(speed * Math.cos(angle));
            p.y = p.y + (int) Math.round(speed * Math.sin(angle));
            super.setLoc(p.x, p.y);
        }

        // Right Arrow: Update angle clockwise.
        else if ( e.getKeyCode() == 39 ) {
            if ( angle + delta > 2*Math.PI ) {
                angle = angle + delta - 2*Math.PI;
                super.setAngle(angle);
            }
            else {
                angle = angle + delta;
               super.setAngle(angle);
            }
        }
        else if ( e.getKeyCode() == 32 ) {
        	launch(mySandBox);
        	BlobUtils.playSound(); //Omit this is deprecated and unneeded
        }
    }
	public void launch(SandBox sb) {
		  Missle missle = new Missle(getLoc().x,getLoc().y,angle);
	       sb.addBlob(missle);
	}
}
