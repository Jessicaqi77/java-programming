// Name: jinqi
// USC NetID: 
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.*;
import java.util.*;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
	
	// private variable: a HashMap  key is the word itself and the value is the anagrams list of the word 
	
	private Map<String , ArrayList<String>> anaMap ;
	
   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
	   anaMap = new HashMap<>() ;
	   File input = new File(fileName) ;
	   Scanner scanner = new Scanner(input) ;
	   
	   // construct the map key is the string, value is the list of its anagrams
	   
	   while(scanner.hasNext()) {
		   String in = scanner.next();
		   String word = preprosess(in) ;
		   if ( anaMap.containsKey(word)) {
			   anaMap.get(word).add(in) ;
		   }
		   else {
			   ArrayList<String> list = new ArrayList<>() ;
			   list.add(in) ;
			   anaMap.put(word, list) ;
		   }
	   }
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
	   String word = preprosess (s) ;
	   ArrayList<String> result = new ArrayList<>() ;
	   if( ! anaMap.containsKey(word) )
		   return result ;
	   else {
		   result = anaMap.get(word) ;
		   return result ;	   
	   }
   }
   
   // function: a helper function to do some preparation work on the string, delete strange character and sort based on the alphabet order
   // parameter: input string
   
   private String preprosess (String in) {
	   char[] temp = in.toCharArray();
	   
	   // delete all other symbols
	  
	   String word = "" ;
	   for (int i =0 ; i < temp.length ; i++ ) {
		   if (( temp[i] >= 'a' && temp[i] <= 'z') || ( temp[i] >= 'A' && temp[i] <= 'Z'))
			   word = word + temp[i] ;		   
	   }
	   
	   // sort characters based on alphabet order
	   
	   char[] wordArr = word.toCharArray();
	   Arrays.sort(wordArr);
	   String wordSorted = new String (wordArr) ;
	   return wordSorted ;
   }
 
}
