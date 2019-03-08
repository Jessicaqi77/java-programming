import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer{
   
   public static  int Width=800;
   public static  int Height=500;
   
   
   public static void main(String[] args){
      Scanner input = new  Scanner(System.in);
      System.out.print("Enter number of trials: ");
      
      int num=input.nextInt();
   
      while(num <=0){
         
         System.out.println("ERROR: Number entered must be greater than 0.");
         System.out.print("Enter number of trials: ");
         num = input.nextInt();  
      }
   
      
      JFrame frame=new JFrame();
      frame.setSize(Width,Height);
      frame.setTitle("CoinSimulation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      CoinSimComponent component=new CoinSimComponent(num);
      frame.add(component);
      
      frame.setVisible(true);
   
   }
   



}