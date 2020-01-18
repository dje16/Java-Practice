# Assignment 2 - JAVA Programming

For this assignment, you will use your knowledge of arrays and ArrayLists to write a Java program 
that will input a file of sentences and output a report showing the tokens and shingles (defined below) 
for each sentence.

## Input Files

There will be one sentence on each line. The sentences may include upper and lower case letters, numbers, 
punctuation marks, and special characters. For this example, I have included a cats.txt and a text file 
containing the lyrics to carless whisper. You can create your own text file, however make sure it is not 
a rich text file (".rtf").

## Main Classes

Two main classes are included SentenceUtilsTest.java and SentenceUtils.java. Comments will be added to code.

## Output Example

```
----------------------------------------------

COP3330 Sentence Utility Program
Input file name:cats.txt
Number of sentences: 3

Sentence 0:
------------
The cat in the hat

Tokens:
0:The
1:cat
2:in
3:the
4:hat

Shingles:
'Th' 'he' 'e ' ' c' 'ca' 'at' 't ' ' i' 'in' 'n ' ' t' 'th' 'he' 'e ' ' h' 'ha' 'at' 

Sentence 1:
------------
The cat sat on the mat

Tokens:
0:The
1:cat
2:sat
3:on
4:the
5:mat

Shingles:
'Th' 'he' 'e ' ' c' 'ca' 'at' 't ' ' s' 'sa' 'at' 't ' ' o' 'on' 'n ' ' t' 'th' 'he' 'e ' ' m' 'ma' 'at' 

Sentence 2:
------------
Pigs in a blanket

Tokens:
0:Pigs
1:in
2:a
3:blanket

Shingles:
'Pi' 'ig' 'gs' 's ' ' i' 'in' 'n ' ' a' 'a ' ' b' 'bl' 'la' 'an' 'nk' 'ke' 'et'

```
