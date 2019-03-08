import java.util.* ;
import java.io.* ;
import java.io.FileNotFoundException;

/*
 The main function to get all the anagrams and corresponding scores of the strings in the input file 
*/

public class WordFinder{
	
	// the private variable
    // dic : a AnagramDictionary to get all the anagrams of the string 
	// map : a hashmap to store the string and its score 
	
	private static AnagramDictionary dic ;
	private static Map <String , Integer> map ;
	
	// main function
	public static void main(String[] args) {
		
		// do the exception if happens, throw exception and exit 
		
		String filename = "" ;
		try {
			
		// user define input file
			
		if(args.length >=1 ) {
			dic = new AnagramDictionary (args[0]) ;
			filename = args[0] ;
		}
		
		// default input file
		
		else {
			dic = new AnagramDictionary ("sowpods.txt") ;
		    filename = "sowpods.txt" ;
		}
		}
		catch (FileNotFoundException e ) {
			System.out.println ( filename + "does not exist!") ;
			return ;
		}
		
		System.out.println("Type . to quit.") ;
		Scanner in = new Scanner (System.in) ;
		
		while(true) {
			System.out.print ( "Rack? " ) ;
			
			// next input 
			
			String input = in.next() ;
			
			// the end of the input 
			
			if ( input.equals("."))
				break ;
			
			// initial the rack 
			
			Rack rack = new Rack() ;
			
			// call the getSubsets in Rack to obtain all the subset of a string
			
			ArrayList<String> result = rack.getSubsets(input) ;
			
			// call the helper function to get map contains strings and scores
			
			calScore(result) ;
			
			// sort the map based on score and alphabet order by constructing comparator
			
		    ArrayList<Map.Entry<String , Integer>> l = new ArrayList<>(map.entrySet()) ;
		    Collections.sort(l, new Comparator<Map.Entry<String , Integer>>(){
		         //override
		         public int compare(Map.Entry<String , Integer> e1 , Map.Entry<String , Integer> e2){
		        	 if (e1.getValue() == e2.getValue() )
		        		 return e1.getValue().compareTo(e2.getValue()) ;
		        	 else 
		        		 return e2.getValue().compareTo(e1.getValue());
		         } 
		      });
		    
		    // result output
		    
			System.out.println("We can make " + l.size()+ " words from "+ "\"" + input + "\"") ;
			if(l.size() > 0) {
				System.out.println("All of the words with their scores (sorted by score): ") ;
				for (Map.Entry<String , Integer> curr : l ) {
					System.out.println(curr.getValue() + ": " + curr.getKey() ) ;
				}	
			}
		}
	}
	
	// a helper function to calculate  scores 
	// parameter: the subsets returned from Rack
	
	private static void calScore (ArrayList<String> result) {
		
		// initial  the score table 
		
		ScoreTable table = new ScoreTable() ;
		
		// initial the map 
		
		map = new TreeMap<>() ;
		
		// iterate all the result, find the anagrams of the string and iterate all the  anagrams, calculate score and put into the map
		
		for (String str : result) {
			ArrayList<String> list = dic.getAnagramsOf(str) ;
			for (String s : list ) {
				int val = table.calculateScore(s) ;
				map.put(s , val ) ;
			}
		}
	}
	
}