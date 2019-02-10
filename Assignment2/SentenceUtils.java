package templates;

import java.util.ArrayList;

public class SentenceUtils	{
	
	private String sentence;
	private String[] tokens;
	private String[] shingles;
	
	ArrayList<String> shinglesArrayList;
	
	public SentenceUtils( String s )	{
		
		sentence = s;
		generatetokens();
		generateshingles();
	}
	
	private void generatetokens()	{
		
		tokens = sentence.split(" ");
		
	}
	
	private void generateshingles()	{
		
		shinglesArrayList = new ArrayList<String>();
		
		for(int i = 0;i < sentence.length()-1; i++)	{
			String sh = "";
			sh += sentence.charAt(i);
			sh += sentence.charAt(i+1);
			shinglesArrayList.add(sh);
		}	
	}
	
	public void report()	{
		
		System.out.println(sentence);
		System.out.println();
		System.out.println("Tokens:");

		for(int i=0;i<tokens.length;i++){
			System.out.println(i+":"+tokens[i]);
		}
		
		System.out.println();
		System.out.println("Shingles:");

		for(String i :shinglesArrayList){
			System.out.print("\'"+i+"\'"+" ");
		}
		
	System.out.println();
	
	}
}
