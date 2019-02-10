package templates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SentenceUtilsTest	{
	
	private static List<SentenceUtils> slist = new ArrayList<SentenceUtils>();
	
	public static void main(String[] args)	{
		
		System.out.println("\n----------------------------------------------\n");
		System.out.println("COP3330 Sentence Utility Program by Dustin Ehling");
		System.out.println("Input file name:" + args[0]);
		
		try	{
			File file = new File( args[0] );
			Scanner scanner = new Scanner(file);
			
			int lines_count = 0;
			while( scanner.hasNextLine() )	{
				String s = scanner.nextLine();
			
			if(s.length()==0)
				continue;
				
			else{
				lines_count++; 
				SentenceUtils obj= new SentenceUtils(s);
				slist.add(obj);
			}
			}	
			System.out.println("Number of sentences: "+lines_count);
			
			int count=0;
			for(SentenceUtils obj:slist){
				System.out.println("\nSentence "+count+":");
				System.out.println("------------");

			obj.report();
			count++;
			}
			scanner.close();
		}
		catch (FileNotFoundException e)	{
			System.out.println("File not found!");
			e.printStackTrace();
		}
	}
}
