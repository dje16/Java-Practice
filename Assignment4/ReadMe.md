# Assignment 4 - JAVA Programming

## Part 1

### Overview

For this program, you will use inheritance to develop an Asteroid class that satisfies certain requirements. You will also develop a separate AsteroidField test driver class to create a field of asteroids. Your test driver will use the "Blobz.jar" external JAR file discussed in lecture to display your asteroid field in a dynamic simulation context. The output of the program should appear as shown below, with the asteroids all flowing across the field of view in all directions. When the asteroids move offscreen, they will reappear near the opposite corners as described for the "flow" mode.

### Specific Requirements

A. Create an Asteroid.java class file in your project for your program. This class must satisfy the following requirements:

  1. it must extend the PolyBlob class, so that it inherits from PolyBlob, which in turn inherits from Blob. The class will will have only a constructor and no other methods.
  2. the constructor must take these three input parameters as arguments:
  
    a. an int that represents the x-component of the asteroid's velocity vector
    b. an int that epresents the y-component of the asteroid's velocity vector
    c. a double that represents the angular rotation rate. 
    
  3. the constructor must set the asteroid to start at the offscreen location (-100, -100), since we will be using "flow" mode, as discussed in lecture.
  4. the constructor must also initialize the asteroid's velocity vector with the velocity component values that the constructor receives as input.
  5. the constructor must create a random simple polygon (no lines crossing) shape for the asteroid that has between 5 and 9 sides and is between 10 and 30 pixels in diameter,        as discussed in lecture. When displayed, the shape must not have any lines that cross.

B. Create a separate AsteroidField.java test driver class to create a field of asteroids. This class must satisfy the following requirements:

  1. it must implement the BlobGUI interface, as explained in lecture.
  2. it must have a one-line main() method that instantiates the class, as follows:
      ```
      public static void main ( String [] args) {
        new AsteroidField ();
      }
      ```
  3. the constructor for the class must perform the following actions:
  
    a. create a sandbox object
    b. set the sandbox to "flow" mode
    c. set the sandbox to run at 15 frames per second
    d. initialize the sandbox by passing "this" (the AsteroidField object) to the sandbox's init() method.
    
  4. the class must contain a generate() method, which is required by the BlobGUI interface. The generate() method must perform the following actions:
  
    a. it must create 10 asteroids using the velocity components and rotational values described
    b. it must randomly choose x and y velocity components for each asteroid, where the x and y components are chosen independently of each other and where each of these                values is an integer that may range from -3 to +3, but where zero values are disallowed
    c. it must randomly choose a rotation value of either -.1 or +.1 for each asteroid, with equal probability. Values in between -.1 and +.1 are not permitted
    d. it must add each asteroid to the sandbox

## Part 2

### Overview
For this program, you will implement an interface that will allow you to move around a rocket of your own design. You will need to implement your own classes for the rocket and a test driver, but you will also be able to use the same Blobz.jar external JAR file as previously, which contains useful utilities for creating a graphics context and for supporting your calculations. The only output of the program should be your rocket displayed in the sandbox, and you should be able to move it around using the up, left, and right arrow keys on your keyboard.

### Specific Requirements

1. The Rocket class must extend the PolyBlob class and also implement the BlobAction interface. Both of these are in the Blobz.jar file and should be imported into your program from the blobz package.

2. The first statement in your Rocket constructor should be: "super(0,0,0);" This will create a stationary PolyBlob in the upper left corner of the sandbox. Then, use the Rocket's setLoc() method, which is inherited from Blob, to set the location to the input location specified by the input parameters to the constructor. The constructor should have 3 input parameters: an int x-coordinate, an int y-coordinate, and the sandbox that your RocketTest test driver instantiated.

3. Your rocket shape will be defined by the polygon you set using the setPolygon() method. You can create your shape on paper and then use those values to initialize the coordinates of the Point[] array that you will pass to setPolygon(). Remember, the coordinates are relative to the origin, which is point (0,0).

4. Since the Rocket class implements the BlobAction interface, the Rocket class must have a public void keyAction(KeyEvent e) method. This method should have separate processing blocks for handling key codes 37 (left arrow), 38 (up arrow), and 39 (right arrow).

5. The Rocket class should also have these instance variables: private double angle = 0.0; private final double delta = 0.15; and private final double speed = 5.0; .

6. The rocket shape that you specify can have as many vertices as you wish. However, no value in the polygon arrays can be less than -10 or greater than +10. Also, when your rocket is first placed in the sandbox, it should be oriented so that the direction of forward motion is to the right as one looks at the screen. This is the direction that should correspond to the initial value of angle = 0.0.

7. The variable "angle" keeps track of the orientation of your rocket. It is initially set to zero, which represents pointing to the right as you look at the screen. Turning to the right will involve adding "delta" to the current angle. Turning to the left will involve subtracting delta from the current angle. You will need to add or subtract 2*PI as appropriate to keep the current angle within the range from 0 to 2*PI. Once you determine what the new angle should be, you should update the rocket's orientation using the setAngle() method.

8. The forward motion block of your keyAction() method should retrieve the current x and y coordinates of your rocket's location, then adjust the locations using the "speed" configuration parameter and the current value of "angle" (which was set to 0.0 initially in the rocket class constructor), and finally should update the location of the rocket using the setLoc() method.

9. The RocketTest class must implement the BlobGUI interface and should have a main() method that contains only the line "new RocketTest()". This is a call to the constructor for the class.

10. The constructor for the RocketTest class should take no input parameters, but it should perform the following actions: (a) create a sandbox; (b) set the sandbox to be in "flow" mode; (c) set the frame rate to 15 frames per second; and (d) pass a reference to itself to the sandbox by running the sandbox's init() method, for example, "sb.init(this)", where "sb" represents the sandbox instance you have created.

11. The RocketTest class should also have a generate() method, which it is required to have since it implements the BlobGUI interface. This generate method will be called every time the user presses the "Start New Game" button on the GUI. The generate() method should instantiate a new Rocket at the location that is at the center of the sandbox. There are several ways to do this. One way to do this is to hard-code the location of the center knowing that the sandbox is 600 x 600 pixels in size. Also, don't forget that the Rocket constructor should have three input parameters, as described in step 2 above in this section. Once the rocket is instantiated, the generate() method should then add it to the sandbox using your sandbox's addBlob() method.

## Part 3

### Overview

For this assignment, you will complete development of the COP3330 Asteroid Game by:

    A. Add a new Missile class
    B. Extend the Rocket class to launch missiles and make sounds
    C. Implement a interface that will allow the simulation engine to keep score and detect collisions 
       between asteroids and your rocket, and between asteroids and missiles.

### Specific Requirments

A. Add a new Missile class:

  The Missile class should extend the Blob class (not PolyBlob) and also implement the BlobProximity interface. 
  Use a "speed" value of 5 (which should be a double) for calculating velocity components, as described in the 
  preview lecture. Also use a fixed blob diameter of 5 pixels. The Missile constructor should take three arguments: 
  the x and y locations of the missile's current location (both integers) and the direction (angle) in which the 
  missile is moving (a double). Please note that there are no methods o implement for the BlobProximity interface. 
  The Missile class should have only a constructor.

B. Modify the Rocket class as follows:

  1. The Rocket class should now also implement the BlobProximity interface in addition to implementing the BlobAction 
  interface and extending the PolyBlob class.
  2. Add a third input argument for the Rocket constructor. This argument will be of type SandBox. This value will need 
  to be saved as a static variable. You will need this reference in order to be able to launch missiles by adding them to 
  the program's sandbox.
  3. Add another block of code in the keyAction() method for processing spacebar key events (key code 32). This block should 
  run the new "launch" instance method described below and then run the BlobUtils playSound() static method to make ound when launched.
  4. Add a new "launch(Sandbox sb)" method to launch the missile. This method is called from the keyAction() method as described above. 
  The launch() method will calculate the        start point for the missile to be 5 pixels ahead of the rocket and have it move in the 
  same direction as the current rocket orientation. The method will then instantiate he Missile and add it to the sandbox, just as we 
  do for asteroids and the rocket.

C. Develop the AsteroidGame class as follows:

  1. AsteroidGame must implement the BlobGUI interface so it can respond to presses of the "Start New Game" button.
  2. AsteroidGame must have a one-line main() method that instantiates the class, as follows:
      ```
      public static void main( String[] args) {
         new AsteroidGame( Integer.parseInt( args[ 0 ]));
      }
      ```
