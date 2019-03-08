public class ScoreTable{
	
	// private variable
	// score: the index is the corresponding didit of a letter, value is the socre 
	// size: the array size, used to initialize
	
	private int[] score ;
	private final int size = 26 ;
	
	// construct function 
	// @parameter: none
	// function: to construct the score table, easy to get a score of a particular letter
	
	public  ScoreTable() {
		score = new int[size] ;
		for (int i = 0 ; i < size ; i++) {
			if (i == ('a' - 'a') || i == ('e' - 'a') || i == ('i' - 'a') || i == ('o' - 'a') || i == ('u' - 'a') || i == ('l' - 'a')|| i == ('n' - 'a') || i == ('s' - 'a') || i == ('t' - 'a') || i == ('r' - 'a'))
				score[i] = 1 ;	
		    else if (i == ('d' - 'a') || i == ('g' - 'a'))
				score[i] = 2 ;
			else if (i == ('b' - 'a') || i == ('c' - 'a') || i == ('m' - 'a') || i == ('p' - 'a'))
				score[i] = 3 ;
			else if(i == ('f' - 'a') || i == ('h' - 'a') || i == ('v' - 'a') || i == ('w' - 'a') || i == ('y' - 'a'))
				score[i] = 4 ;
			else if(i == ('k' - 'a'))
				score[i] = 5 ;
			else if(i == ('j' - 'a') || i == ('x' - 'a'))
				score[i] = 8 ;
			else if(i == ('q' - 'a') || i == ('z' - 'a'))
				score[i] = 10 ;			
		}
	}
	
	// function: to calculate the score of the string  based on the score table
	// @parameter: the input string 
	
	public int calculateScore (String str) {
		int sum = 0 ;
		String low = str.toLowerCase();
		char[] temp = low.toCharArray() ;
		for (int i = 0 ; i < temp.length ; i++) {
			sum += score[(temp[i]-'a')] ;
		}
		return sum ;
	}
}