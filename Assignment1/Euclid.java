package euclid;

import java.util.Scanner;

public class euclid {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		/*Input*/
		System.out.print("Euclid's Algorithm by <Dustin Ehling> " );
		System.out.print("\nEnter an integer: " );
		int x = scan.nextInt();
		System.out.print("\nEnter an integer: " );
		int y = scan.nextInt();
		scan.close();	
		
		/*Long way as detailed in Assignment 1 slides*/
		int q = x/y;
		int r = x%y;
		int z = y%r;
		int s = r%z;
		
		/*Output*/
		System.out.println("Input(x):" + x);
		System.out.println("Input(y):" + y);
		System.out.println("Input(q):" + q);
		System.out.println("Input(r):" + r);
		System.out.println("Input(z):" + z);
		System.out.println("Input(s):" + s);
		
		System.out.println("GCD of the numbers is " + FindGCD(x, y));
	}
	/*Shorter way that just calculates the GCD of the input*/
	public static int FindGCD(int x, int y) {
		
		if(y == 0) 
			return x;
		
		else return FindGCD(y, x%y);
	}		
	
}
