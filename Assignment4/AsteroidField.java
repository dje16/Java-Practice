import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;

public class AsteroidField implements BlobGUI {
	
	private static SandBox sb;
	private static final Random random = new Random();
	private static int numAsteroids;
	
	public AsteroidField(int num) {
		
		numAsteroids = num;
		sb = new SandBox();
		sb.setSandBoxMode(SandBoxMode.FLOW);
		sb.setFrameRate(15);
		sb.init(this);
	}
	
	public static void main(String[] args) {
		
		new AsteroidField(Integer.parseInt(args[0]));
	}
	
	@Override
	public void generate() {
		
		//Create the asteroids
		for(int i=0;i < numAsteroids; i++) {
			
			//Velocity
			int ranDelX = 0;
			while(ranDelX == 0) {
				ranDelX = -3 + random.nextInt(7);
			}
			int ranDelY = 0;
			while(ranDelY == 0) {
				ranDelY = -3 + random.nextInt(7);
			}
			
			//Clockwise or Counterclockwise
			double rot = .1;
			int b = random.nextInt(2);
			if(b==0) {
				rot = -rot;
			}
			
			//Create asteroid and add it to the sandbox
			Asteroid asteroid = new Asteroid(ranDelX, ranDelY, rot);
			sb.addBlob(asteroid);
		}
	}
}
