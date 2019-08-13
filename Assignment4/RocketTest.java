import blobz.SandBox;
import blobz.SandBoxMode;
import blobz.BlobGUI;

//implements the BlobGUI interface
public class RocketTest implements BlobGUI {

    private static SandBox sb;

    public static void main(String[] args) {
        // Run constructor for the RocketTest.
        new RocketTest();
    }

    public RocketTest() {
        // Create sandbox object and FLOW setting
        sb = new SandBox();
        sb.setSandBoxMode(SandBoxMode.FLOW);

        //Frames to 15
        sb.setFrameRate(15);

        // Initiate the sandbox.
        sb.init(this);
    }

    @Override
    public void generate () {

        // Create  the rocket. Based on Rocket class specifications. 
    	// You can hard code this thru trial and error (300, 300, sb) is close.
        int xcoord = sb.getPanelBounds().width/2;
        int ycoord = sb.getPanelBounds().height/2;

        // Add it to the sandbox for play and movement testing.
        sb.addBlob(new Rocket(xcoord,ycoord ));
    }
}
