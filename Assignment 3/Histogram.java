package histogram;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Histogram extends javax.swing.JFrame {
   
   private static final long serialVersionUID = 1L;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSplitPane jSplitPane1;
   private javax.swing.JButton loadButton;
   private javax.swing.JPanel mainPanel;
   private javax.swing.JTextField numField;
   private javax.swing.JButton showButton;
   private javax.swing.JTextArea sourceArea;
   private javax.swing.JPanel topPanel;
   private HistogramPanel outPanel;
   
   // declare the extra variables that are required
   String textfile = "";
   int numSentences = 0;

   public Histogram() {
      initComponents();
      this.setTitle("COP3330 Sentence Histograms by <Dustin Ehling>");
   }

   private void initComponents() {
      topPanel = new javax.swing.JPanel();
      loadButton = new javax.swing.JButton();
      showButton = new javax.swing.JButton();
      numField = new javax.swing.JTextField();
      mainPanel = new javax.swing.JPanel();
      jSplitPane1 = new javax.swing.JSplitPane();
      jScrollPane1 = new javax.swing.JScrollPane();
      sourceArea = new javax.swing.JTextArea();
      outPanel = new HistogramPanel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      topPanel.setBackground(new java.awt.Color(230, 240, 255));
      topPanel.setPreferredSize(new java.awt.Dimension(686, 40));

      loadButton.setText("Load File");
      loadButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            loadButtonActionPerformed(evt);
         }
      });
      topPanel.add(loadButton);

      showButton.setText("Show Histo for Sentence");
      showButton.setEnabled(false);
      showButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            showButtonActionPerformed(evt);
         }
      });
      topPanel.add(showButton);

      numField.setColumns(3);
      numField.setEnabled(false);
      numField.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            numFieldActionPerformed(evt);
         }
      });
      topPanel.add(numField);

      getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);
      
      mainPanel.setLayout(new javax.swing.BoxLayout(
            mainPanel, javax.swing.BoxLayout.X_AXIS));
      jScrollPane1.setVerticalScrollBarPolicy(
            javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      sourceArea.setColumns(20);
      sourceArea.setLineWrap(true);
      sourceArea.setRows(5);
      jScrollPane1.setViewportView(sourceArea);

      jSplitPane1.setLeftComponent(jScrollPane1);

      outPanel.setBackground(new java.awt.Color(230, 230, 230));
      outPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
         public void componentResized(java.awt.event.ComponentEvent evt) {
            outPanelComponentResized(evt);
         }
      });

      javax.swing.GroupLayout outPanelLayout = new javax.swing.GroupLayout(outPanel);
      outPanel.setLayout(outPanelLayout);
      outPanelLayout.setHorizontalGroup(
         outPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 128, Short.MAX_VALUE)
      );
      outPanelLayout.setVerticalGroup(
         outPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 256, Short.MAX_VALUE)
      );

      jSplitPane1.setRightComponent(outPanel);
      mainPanel.add(jSplitPane1);
      getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);
      pack();
   }

   private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
	   // launch a JFileChooser dialog
       JFileChooser fc = new JFileChooser();
       int i = fc.showOpenDialog(this);
      
       if (i == JFileChooser.APPROVE_OPTION){
           // get file
           File file = fc.getSelectedFile();
           textfile = outPanel.readFile(file);
         
           // set the text of the sourceArea to the String that is returned from 
           // outPanel's readFile method using the selected file as input
           sourceArea.setText(textfile);
           // enable the showButton GUI variable
           showButton.setEnabled(true);
           // enable the numField text field GUI variable
           numField.setEnabled(true);
         
           String array[] = textfile.split("\\n");
           String lastStatement = array[array.length - 1];
           String lastLineNumber = lastStatement.substring(0,
                   lastStatement.indexOf(" :"));
          
           numSentences = Integer.parseInt(lastLineNumber);
       }
       // else do nothing
   }

   private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
       int inputValue = 1;
       // retrieve the String value that is in the numField textField
       if (numField.getText().equals("")){
           JOptionPane.showMessageDialog(null, "An integer was not input");
       }
       // if the value retrieved cannot be parsed as an integer, display a JOptionPane message dialog stating:
       else{
           try{
               inputValue = Integer.parseInt(numField.getText());
               // invoke showHisto method with "true"
               outPanel.showHisto(inputValue, true);              
           }
           catch (NumberFormatException nfe){
               JOptionPane.showMessageDialog(null,"Text field is not an integer");
           }
       }
   }

   private void numFieldActionPerformed(java.awt.event.ActionEvent evt) {
      showButtonActionPerformed( evt );
   }

   private void outPanelComponentResized(java.awt.event.ComponentEvent evt) {
      outPanel.showHisto();
   }

   public static void main(String args[]) {
      
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : 
                  javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } 
      catch (ClassNotFoundException | InstantiationException | 
               IllegalAccessException | 
               javax.swing.UnsupportedLookAndFeelException ex) {
         
         java.util.logging.Logger.getLogger(Histogram.class.getName())
               .log(java.util.logging.Level.SEVERE, null, ex);
      }

      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Histogram().setVisible(true);
         }
      });
   }
}
