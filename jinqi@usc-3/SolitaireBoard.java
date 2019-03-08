// Name:jinqi@usc.edu
// USC NetID:3991265704
// CSCI455 PA2
// Fall 2018

import java.util.*;

/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
  by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.
  (See comments below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   
/**
   * Representation invariant:
    1. Piles index of card from 0 to card.size()-1;
    2. The total sum of each pile should be CARD_TOTAL.
    3. Each value of pile :0<card[i]<=CARD_TOTAL;
*/

/**
   private parameter in the SolitaireBoard class
   card: an array to store how many card in each pile
   pile_num: store how many piles are currently occupied pile 
*/  
   private int[] card;
   private int pile_num;
  
/**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
*/
   public SolitaireBoard(ArrayList<Integer> piles) {
      card = new int[CARD_TOTAL+1];
      pile_num=piles.size();
      for(int i=0;i<piles.size();i++){
         card[i]=piles.get(i);
      }
      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }
    
/**
   Creates a solitaire board with a random initial configuration.
   @param: none
*/
   public SolitaireBoard() {
     
       card = new int[CARD_TOTAL+1];
       pile_num=0;
       int sum=0;
       while(sum<CARD_TOTAL){
           Random rand = new Random();
           int randNum = rand.nextInt(CARD_TOTAL-sum)+1;
           card[pile_num++]=randNum;
           sum+=randNum;
  
       }
       assert isValidSolitaireBoard();
   }
  
/**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
      @param: none
*/
   public void playRound() {
      int j=0;
      int initial_pilenum=pile_num;
      for(int i=0;i<pile_num;i++){
        if(card[i]!=1){   
           card[j++]=card[i]-1;
        }    
      }     
      card[j]=initial_pilenum;   
      pile_num=j+1;
      assert isValidSolitaireBoard();
   }
   
/**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
      @param: none
*/
   
   public boolean isDone() {
      
      int[] count= new int [NUM_FINAL_PILES+1];
      for(int i=0;i< pile_num;i++){      
         if( card[i]>0 && card[i]<=NUM_FINAL_PILES)
            count[card[i]]=1;
      }
      int check=0;
      for (int i=1;i<=NUM_FINAL_PILES;i++ ){
         if(count[i]==1)
            check++;
      }   
      if(check== NUM_FINAL_PILES)
         return true;
      return false;      
   }
   
/**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
      @param: none
*/
   public String configString() {
      
      String output=new String(Integer.toString(card[0]));;
      for (int i=1;i<pile_num;i++){
         output=output+ " " + Integer.toString(card[i]);
      
      }
      assert isValidSolitaireBoard(); 
      return output;   
   }
   
   
/**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
      @param: none
      using "assert" in other method to check if it is a valid number list
      in the command line -ea to enable 'assert'
*/
   private boolean isValidSolitaireBoard() {
      
      if(pile_num>CARD_TOTAL)
         return false;
      int sum=0;
      for (int i=0;i<pile_num;i++){
         if (card[i]<=0 || card[i]>CARD_TOTAL)
            return false;
         sum+=card[i];
      }      
      if(sum!=CARD_TOTAL)
         return false;
      return true;  
   }
   
}
