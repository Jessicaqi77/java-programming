import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;


public class CoinSimComponent extends JComponent{

    public static  Color Color_left = Color.RED;
    public static  Color Color_middle = Color.GREEN;
    public static  Color Color_right= Color.BLUE;
    public static  int vb= 15;
    public static  int width=55;
    CoinTossSimulator coin;
   
    // constructor
    public CoinSimComponent(int numberOfTrials) {
   
        coin = new CoinTossSimulator();
        coin.run( numberOfTrials);
    }
   
    public void paintComponent(Graphics g) {
   
       Graphics2D g2 = (Graphics2D) g;
       
       int total=coin.getNumTrials();
       int twoheads=coin.getTwoHeads();
       int twotails=coin.getTwoTails();
       int headsandtail=coin.getHeadTails();
       
       
       double scale=(double)(getHeight()-2*vb)/total;
       int bottom=getHeight()-vb;
       int left_1=getWidth()/4+20;
       int left_2=getWidth()/2+20;
       int left_3=3*getWidth()/4+20;
       
       double percent_1=(double)twoheads/total;
       double percent_2=(double)headsandtail/total;
       double percent_3=(double)twotails/total;   
       
         
       // bar para: bottom, left, width, barHeight, scale,  color,  label
       String label_1="Two Heads: "+twoheads+"("+Math.round(percent_1*100)+"%)";
       Bar left=new Bar(bottom,left_1,width,twoheads,scale,Color_left,label_1);
      
       String label_2="A Head and A Tail: "+headsandtail+"("+Math.round(percent_2*100)+"%)";
       Bar middle=new Bar(bottom,left_2,width,headsandtail,scale,Color_middle,label_2);
       
       String label_3="Two Tails: "+twotails+"("+Math.round(percent_3*100)+"%)"  ;      
       Bar right=new Bar(bottom,left_3,width,twotails,scale,Color_right,label_3);
       
       left.draw(g2);
       middle.draw(g2);
       right.draw(g2);
       
    }
                                           
     

}
