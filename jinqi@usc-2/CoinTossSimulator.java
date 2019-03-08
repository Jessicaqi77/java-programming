// Name:
// USC NetID:
// CS 455 PA1
// Fall 2018

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
import java.util.Random;
import java.util.Scanner;

public class CoinTossSimulator {
   
   int total;
   int twoheads;
   int twotails;
   int headandtail;
   private Random r1;
   private Random r2;
   
   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      
      total=0;
      twoheads=0;
      twotails=0;
      headandtail=0;
      r1=new Random();
      r2=new Random();
       
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      
      
      for (int i=0;i<numTrials;i++){
         int sum=0;
         
         sum=r1.nextInt(2)+r2.nextInt(2);
         
         if(sum==0){
            
            twoheads++;
         }
         
         if (sum==1){
            
            headandtail++;
         }
         
         if(sum==2){
            
            twotails++;
         }  
      }
      
      total+= numTrials;
 
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return total; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoheads ; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twotails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headandtail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      total=0;
    
      twoheads=0;
    
      twotails=0;
    
      headandtail=0;

   }

}
