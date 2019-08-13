package histogram;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HistogramPanel extends JPanel {
   
   private static final long serialVersionUID = 1L;
   private List<String> sents;
   private int snum;
   
   public String readFile( File file ) {
      sents = new ArrayList<>();
      snum = -1;
      clearDisplay( this.getGraphics() );
      StringBuilder sb = new StringBuilder();
      try {
         Scanner scanner = new Scanner( new FileInputStream(file));
         while( scanner.hasNextLine() ) {
            String s = scanner.nextLine().trim();
            if( s.length() > 0 ) {
               sents.add( s );
            }
         }
         scanner.close();
         
         for( int i = 0; i < sents.size(); i++ ) {
            sb.append(i + " : " + sents.get( i ) + "\n\n");
         }
      } catch (FileNotFoundException ex) {
         Logger.getLogger(HistogramPanel.class.getName()).log(Level.SEVERE, null, ex);
      }
      return sb.toString().trim();
   }
   
   @Override
   public void paintComponent( Graphics gc ) {
      super.paintComponent( gc );
      if( sents != null && snum >= 0 && snum < sents.size() ) { 
         showHisto( snum, true );
      }
   }
   
   public void showHisto() {
      this.setBackground( Color.white );
      showHisto( snum, false );
   }
   
   public void showHisto( int n, boolean b ) {            
      if( sents != null && n >= 0 && n < sents.size() ) {
         snum = n;
         Graphics gc = this.getGraphics();
         clearDisplay( gc );
         drawLines( gc );
         drawHisto( gc );
      }
      else if( b && sents != null ) {
         JOptionPane.showMessageDialog(this, "Sentence index out of range");
      }
   }
   
   private void clearDisplay( Graphics gc ) {      
      gc.setColor( Color.WHITE );
      gc.fillRect(0,0,this.getWidth(),this.getHeight());
   }
   
   private void drawLines( Graphics gc ) { 
	   // draw the x- and y- coordinate axis lines for the histogram 
       double margin = 0.1;
       int x_pos = (int) (this.getWidth()*margin);
       int y_pos = (int) (this.getHeight()*margin);
       // x and y lines need to be red, should form a box
       gc.setColor(Color.red);
       // get the line to draw position
       int lineTodraw = (int) (10-margin*10);
       // draw the x-axis line
       gc.drawLine(x_pos,y_pos,x_pos,y_pos*lineTodraw);
       // draw the y-axis line
       gc.drawLine(x_pos,y_pos*lineTodraw,x_pos*lineTodraw,y_pos*lineTodraw);
   }
   
   private void drawHisto( Graphics gc ) {
      
	   double margin = 0.1;
       int x_pos = (int) (this.getWidth()*margin);
       int y_pos = (int) (this.getHeight()*margin);
 
       int max_freq = 0, character;
       int height;
       int frequency[] = new int[26];
     
       String sentence = sents.get(snum).toLowerCase();
       for (int i = 0; i < sentence.length(); i++)
       {
           // get the character
           character = sentence.charAt(i) - 'a';
           // if the character is with in the range of 0-26, alphabet
           if (character >= 0 && character < 26)
           {
               // count the frequency of the character in the file
               frequency[character]++;
               // get the max
               max_freq = Math.max(max_freq, frequency[character]);
           }
       }

       gc.setColor(Color.blue);
       double barToStart = 0.8;
       int lineTodraw = (int) (10 - margin*10);
       // the width of each histogram bar should be equal to:
       int width = x_pos*((int) (barToStart*10))/26;
      
       for (int i = 0; i < frequency.length; i++){
           
           height = y_pos * ((int) (barToStart * 10))*frequency[i]/max_freq;
           
           gc.drawRect(x_pos+i*width,y_pos*lineTodraw-height,width,height);
       }
}

   @SuppressWarnings("unused")
private int[] scaledHisto( int[] inp ) { 
      int[] histo = new int[ inp.length ];
      int max = findMax( inp );
      
      double scaleFactor = 0.8 * this.getHeight();
      for( int i = 0; i < histo.length; i++ ) {
         double scaled =  scaleFactor * 
               ( ((double) inp[ i ] ) / max );
         histo[ i ] = (int) Math.floor(scaled);
      }
      return histo;
   }
	   
   @SuppressWarnings("unused")
private int[] rawHisto( String s ) {
      s = s.toLowerCase();
      int[] letter = new int[ 26 ];
      for( int i = 0; i < s.length(); i++ ) {
         char ch = s.charAt( i );
         if( Character.isLetter(ch) ) {
            int num = ch - 'a';
            letter[ num ]++;
         }
      }
      return letter;
   }

   private static int findMax( int[] inp ) {
      int max = inp[ 0 ];
      for( int i = 0; i < inp.length; i++ ) {
         if( inp[ i ] > max ) {
            max = inp[ i ];
         }
      }
      return max;
   }
}
