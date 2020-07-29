# Assignment 3 - JAVA Programming

For this assignment, you will be furnished with the skeleton structure of a Swing GUI application for displaying letter occurrence histograms for sentences in a selected text file.

## Input Files

The input file format is the same as for Program 2. For details please see that assignment.

## Program Operation

When the program is launched from the command line, a GUI must appear with your name housed in the header. When the "Load File" button is pressed, a file chooser should appear. When a properly formatted input file is selected and opened, the sentences in the file will be numbered and displayed in the left panel, as shown here. When the "Show Histo for Sentence" button is pressed, or when the cursor is in the textfield and the Enter key is pressed, the program should attempt to parse an integer from the text field. If there is no value or the value cannot be parsed as an integer, the program should present the JOptionPane message shown here. If the value in the text field can be parsed as an integer, but the integer value is less than zero or greater than the greatest sentence index, the program presents the JOptionPane message shown here. However, if the value can be parsed as an integer within range, then the program should compute the letter occurrence histogram for the sentence and display it graphically in the right pane, as shown here. The histogram display methods should be developed so that when the GUI window is resized, the histogram display automatically refreshes and resizes to fit within the available space, as shown below.

## Specific Requirements

A. Your name must appear in the title bar of the GUI window. This should be done in the Histogram class constructor.

B. You must write the code for the Histogram class's loadButtonActionPerformed( ActionEvent evt ) method. This event handler must take the following actions when the "Load File" button is pressed:

    1. Launch a JFileChooser dialog
    2. The file chooser must open to the current user folder, as shown in lecture
    3. Do not use a file filter with the file chooser
    4. If the selected file is not null:
        a. Set the text of the sourceArea (a GUI variable in the Histogram class) to the String that is returned from outPanel's readFile method using the selected file as input         (outPanel is also a GUI variable in the Histogram class).
        b. Enable the numField text field GUI variable
        c. Set the text in numField to an empty string
        d. enable the showButton GUI variable
    5. But if the selected file returned from the file chooser is null, do nothing
    6. You should be aware that JComponents such as JButtons and JTextfields have the instance method setEnabled(boolean b), such that if b is true, then the component is              enabled (i.e., active), but if b is false, then the component is grayed out (i.e., inactive).
    7. You should also know that JTextfields also have instance method getText() to retrieve the string in the text field, and instance method setText( String s ) to sets the          string in the text field to the string argument.

C.  You must write the code for the Histogram class's showButtonActionPerformed( ActionEvent evt ) method. This event handler must take the following actions when the "Show Histo for Sentence" button is pressed:

    1. Retrieve the String value that is in the numField textField.
    2. If the value retrieved cannot be parsed as an integer, display a JOptionPane message dialog stating, "Text field is not an integer".
    3. If the value retrieved can be parsed as an integer, the program should invoke outPanel's showHisto method using the parsed integer as the first argument and "true"              (without the quotation marks) as the second argument. You do not need to test whether the integer is within the proper range, since the skeleton code that is provided to        you already knows how to handle out of range value by popping up the out-of-range JOptionPane message, so you do not need to program this. If the integer value is within        range and your code for the HistogramPanel class is implemented properly, a letter histogram for the selected sentence will display in the right-hand panel of the GUI            with 10% margins on all sides
D. You must write the code for the HistogramPanel class's drawLines( Graphics gc ) method. This method must:

    1. Draw the x- and y- coordinate axis lines for the histogram as shown in figure above. Please note that the x-axis line is the red line that appears at the bottom of all          the histogram bars and the y-axis line is the red line that appears next to the leftmost histogram bar. The axis lines are not the red lines shown above that surround the        entire image.
    2. Do not hard code any fixed values for the size of the output panel outPanel on which you will draw the axes. Instead, use this.getHeight() and this.getWidth() to obtain          the current height and width of outPanel. This will allow your axes to adjust automatically when the window is resized.

E. You must write the code for the HistogramPanel class's drawHisto( Graphics gc ) method. This method must:

    1. Draw blue rectangle histogram bars for the letter counts
    2. The height of each bar must be in proportion to the count it represents
    3. The tallest bar will be for the largest letter count value
    4. The height of the tallest bar should be equal to: 80% of this.getHeight()
    5. The width of each histogram bar should be equal to: (1/26) * ( 80% of this.getWidth())
    6. Don’t worry about zero-height rectangles (they will display correctly)
