package asteroidgame;

import blobz.BlobUtils;
import blobz.PolyBlob;
import java.awt.Point;
import java.util.Random;


public class Asteroid extends PolyBlob{
	
	private static final Random random = new Random();
	
	public Asteroid(int idx, int jdx, double rot) {
		
		super(-100,-100,rot);
		super.setDelta(idx,jdx);
		
		int numSides = 5 + random.nextInt(5);
		
		int[] vertex = new int[numSides];
		for(int i=0; i <numSides; i++) {
			vertex[i] = 5 + random.nextInt(11);
		}
		
		Point[] p = new Point[numSides];
		double region = (2*Math.PI) / numSides;
		double[] angle = new double[numSides];
		for( int i = 0; i < numSides; i++) {
			angle[i] = (i*region)+(Math.random()*region);
			p[i] = BlobUtils.rotatePoint(vertex[i], angle[i]);
		}
		
		setPolygon(p);
	}
}
