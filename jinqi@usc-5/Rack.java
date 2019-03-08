// Name: jinqi
// USC NetID: jinqi
// CS 455 PA4
// Fall 2018

import java.util.ArrayList;
import java.util.* ;
/**
   A Rack of Scrabble tiles
 */

public class Rack {
	
	// private variable used as parameter in the following funcion
	// unique : a string to store all the unique letters
	// mult : the corresponding appearance times of each letter from unique.  
	
	 private String unique = "" ;
	 private int[] mult ;

   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset
      @author Claire Bono
    */
  
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      return allCombos;
   }
   
   // function: to return all the subsets
   // parameters: the inputs string
  
   public  ArrayList<String> getSubsets(String input){
	   preprocess(input) ;
	   return allSubsets(unique , mult , 0 ) ;
   }
   
   // function: preparation word on the string, construct the unique and mult variable
   // parameters: the inputs string

   public void preprocess(String input) {
	   
	   char[] temp = input.toCharArray();
	   
	   // delete all other symbols
	   
	   String word = "" ;
	   for (int i =0 ; i < temp.length ; i++ ) {
		   if (( temp[i] >= 'a' && temp[i] <= 'z') || ( temp[i] >= 'A' && temp[i] <= 'Z'))
			   word = word + temp[i] ;		   
	   }
	   
	   // construct a map to count letters and frequency
	   
	   Map < Character, Integer> map = new HashMap<>() ;
	   char[] letters = word.toCharArray();
	   for (int i = 0 ; i < word.length() ; i++) {
		   if ( map.containsKey( letters[i] )){
			   int val = map.get(letters[i] ) ;
			   val++ ;
			   map.put( letters[i], val ) ;	   
		   }
		   else {
			   map.put( letters[i], 1) ;   
		   }
	   }
	   
	   // construct unique and mult based on the map
	   
	   int count = 0 ;   
	   mult = new int [map.size()] ;
	   for ( Character ch : map.keySet() ) {
		   unique += String.valueOf (ch) ;
		   mult[ count++ ] = map.get (ch) ;
	   }
	   
   }
}
