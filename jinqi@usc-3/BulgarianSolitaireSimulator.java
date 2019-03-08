// Name:jinqi@usc.edu
// USC NetID: 3991265704
// CSCI455 PA2
// Fall 2018


/**
   * function: It is used to test the funtion of the BulgarianSolitaireSimulator.java
   * It has two different styles, random and user input.
*/
import java.util.*;

public class BulgarianSolitaireSimulator {
/**
   * main function
   * when run it, input -u or -s to step into user or random play modle 
   * when done  and finish 
       
*/
   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;
      
      SolitaireBoard board;
      ArrayList <Integer> list= new ArrayList<Integer>();
      
      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }
/**      
    * choose user input model
*/   
      if(userConfig == true){   
         board=new SolitaireBoard(input_init(list));
         inputplay(board);     
      }
/**      
    * choose random play  model
*/
      if(singleStep==true){   
         board = new SolitaireBoard();        
         randomplay(board);  
      }       
   }
   
/**      
   * function: check the user input number list is valid or not(errorchecking)
   * return true if the number list is valid otherwise it will return false
   * @param ArrayList <Integer> list  which is the user input number list
   
*/
   private static boolean isvalid( ArrayList <Integer> list){
   
        int sum=0;
        for(int i=0;i<list.size();i++){
           int temp=list.get(i);
           if(temp<=0 || temp>SolitaireBoard.CARD_TOTAL )
              return false;  
           sum+=temp;
        } 
      if(sum!=SolitaireBoard.CARD_TOTAL)
         return false;
      return true;
      
   }
   
/**      
    *  funtion: prompt user to input number list
    *  use errorchecking function to check if it is a valid list
    *  it will output eror info and ask user to input again until the number list is valid
    *  @param ArrayList <Integer> list which is uesd to store the input number list
    *  return the vaild ArrayList
*/  
      
  private static ArrayList<Integer> input_init(ArrayList <Integer> list){ 
         
         System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
         System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
         System.out.println("Please enter a space-separated list of positive integers followed by newline:");
         Scanner input= new Scanner(System.in);
         String in = input.nextLine();
         Scanner index = new Scanner(in);
         while(index.hasNextInt()) {      
            list.add(index.nextInt());
         }       
         while(!isvalid(list)){  
           System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45" );
           System.out.println("Please enter a space-separated list of positive integers followed by newline:");   
           list.clear();
           in = input.nextLine();
           index = new Scanner(in);     
            while(index.hasNextInt()) {    
            list.add(index.nextInt());  
            }         
         }   
         return list;
  }
   
/**      
    * functon:  step into the random play modle
    * Type return key between each step
    * @param SolitaireBoard Board
*/ 
   private static void randomplay(SolitaireBoard Board) {
      
      System.out.println("Initial configuration: "+ Board.configString());
      int count=1;
      Scanner in = new Scanner(System.in);    
      while(!Board.isDone()){       
         Board.playRound();
         System.out.println("[" + count + "] " + "Current configuration: " +Board.configString());
         System.out.println("Type return to continue");
         count++;
         in.nextLine();       
      }      
      System.out.println("Done!"); 
   }
   
/**      
    *function: step into the random play modle
    @param SolitaireBoard Board
*/      
   
   private static void inputplay(SolitaireBoard Board) {
      
      System.out.println("Initial configuration: "+ Board.configString());
      int count=1;   
      while(!Board.isDone()){
         Board.playRound();
         System.out.println("[" + count + "] " + "Current configuration: " +Board.configString());
         count++;
   }
      System.out.println("Done!");
   }
   
}
