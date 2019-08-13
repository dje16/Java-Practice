package asteroidgame;

import java.awt.Color;
import blobz.BlobProximity;
import blobz.Blob;

public class Missle extends Blob implements BlobProximity{

	//Use a "speed" value of 5 (which should be a double) for calculating velocity components
    private final double speed = 5;
    private final int size = 5;
	public Missle ( int x, int y, double angle) {

        super (x,y,Color.yellow);
        //Also use a fixed blob diameter of 5 pixels.
        setSize(size);
        
        int dx = (int) Math.round(speed * Math.cos(angle));
        int dy = (int) Math.round(speed * Math.sin(angle));
        this.setDelta(dx,dy);
        
        int xloc = getLoc().x;
        int yloc = getLoc().y;
        setLoc(xloc+(int)Math.round(speed*Math.cos(angle)),yloc+(int)Math.round(speed * Math.sin(angle)));
    }
}
