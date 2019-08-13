package asteroidgame;

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;

public class AsteroidGame implements BlobGUI {
    public static final Random random = new Random();
    public static void main( String[] args ) {
        new AsteroidGame( Integer.parseInt( args[ 0 ] ) );
    }

    //Save the input integer in a static variable
    private static int numOfAsteroids = 0;

    //Create a sandbox object
    private static SandBox sb;
    
    //Save the input integer in a static variable
    public AsteroidGame(int parseInt) {
        numOfAsteroids = parseInt;
        //Create Sandbox object
        sb = new SandBox();
        //Set to FLOW
        sb.setSandBoxMode(SandBoxMode.FLOW);
        //Set to 15 FPS
        sb.setFrameRate(15);
        //Initialize by passing "this" into method
        sb.init(this);
    }

    @Override
    public void generate() {

    	// Generate random velocities
        for(int i = 0; i < numOfAsteroids; i++) {
            int xV = random.nextInt( (3 - (-3) )+ 1) + (-3);
            int yV = random.nextInt( (3 - (-3) )+ 1) + (-3);

            while(xV == 0)
                xV = random.nextInt( (3 - (-3) )+ 1) + (-3);
            while(yV == 0)
                yV = random.nextInt( (3 - (-3) )+ 1) + (-3);

            //Rotation values, set [-.1,.1]
            double[] rotation = {-.1, .1};
            int rotationIndexLen = rotation.length;
            int index = random.nextInt(rotationIndexLen);
            double R = rotation[index];

            // Add to asteroids to the sandbox by input number
            Asteroid asteroid = new Asteroid(xV, yV, R);
            sb.addBlob(asteroid);
            //Instantiate your rocket and add it to the center of the sandbox
            int width = sb.getPanelBounds().width;
            int height = sb.getPanelBounds().height;
            Rocket r = new Rocket(width/2,height/2, sb); //add parameters
            sb.addBlob(r);
        }
    }
}

