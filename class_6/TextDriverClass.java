import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Component;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.*;
/*
 * The TextDriverClass Class. Creates an example of the use of the Text and Letter classes.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.05.22
 */
public class TextDriverClass extends JFrame {
  /*
   * The frame to contain all GUI.
   */
  //public JFrame frame;
  /*
   * The Panel to contain all GUI.
   */
  //public JPanel panel;
  /*
   * Class constructor
   */
  public TextDriverClass () {
    
    setSize(1080,720);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(1080,720));
    
    JPanel panel = new JPanel();
    panel.setLayout(null);
    add(panel);  
    
    //Text t = new Text (new Color (25,25,25),  40,40,  false,  false,  true,  50,  20, "TEST", panel);  
    //Text t2 = new Text (null,  20,40,  true,  false,  false,  20,  540, "/TEST ONE/TEST TWO", panel); 
    
    PracticeRoom pr = new PracticeRoom(panel);
    
    //panel = t2.draw();     
    //panel = t.draw();
    
    panel = pr.getPanel();
    setVisible(true);
    this.pack();
    
    /*try {
      Thread.sleep(3000);
      panel = t.erase();
    } catch (Exception e) {
      System.out.println(e);
    }*/
    
  }
  /*
   * The main method that runs the Text and Letter classes.
   */
  public static void main (String[] args) {
    
    TextDriverClass driver = new TextDriverClass();
    
  }
}