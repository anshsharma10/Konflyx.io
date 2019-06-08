import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*; 
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Component;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.*;
import java.util.Timer;
/*
 * The VisualNovel class. Creates a simple visual novel system for the driver and level classes to use. Contains methods
 * used for the visual novel.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.30
 */
public class PracticeRoom {
  /*
   * The JPanel to work with.
   */
  JPanel panel;
  TextBox textbox;
  String words[] = new String [1000];
  /*
   * The class constructor. Creates a BufferedImage of the text box and places it at the bottom of the screen.
   */
  public PracticeRoom(JPanel panel) {
    File file = new File("Practice Room Words\\PRWords.txt"); 
    try{ 
      BufferedReader bufread = new BufferedReader(new FileReader(file)); 
      String line;
      for (int i = 0; i < 1000; i++){
        words [i] = bufread.readLine();
      }
      this.panel = panel;
      textbox = new TextBox();
      panel.add(textbox);
      addText();
    }   
    catch (IOException e){ 
    }
  }
  /*
   * Adds text to the screen using the Text and Letter classes, with a character and their respective emotion displayed.
   * @return The JPanel after text is added.
   */
  public void addText () {
    Text line1;
    Text line2;
    long startTime = System.currentTimeMillis();
    
    line1 = new Text (null,  30,50,  true,  false,  false,  50,  20, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
    line2 = new Text (null,  30,50,  true,  false,  false,  50,  100, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
    
    TimerTask repeatedTask = new TimerTask() {
      boolean count = true;
      public void run() {
        if (count){
          line1.draw();
          line2.draw();
        }
        count = false;
        //System.out.print(line1.finishedLine());
        if (0.20*60*1000<(System.currentTimeMillis() - startTime)){
          line1.erase();
          line2.erase();
          cancel(); 
        }
      }
    };
    Timer timer = new Timer("Timer");
    timer.scheduleAtFixedRate(repeatedTask, 0, 10);
    
  }
  /*
   * Returns the current JPanel.
   * @return the JPanel.
   */
  public JPanel getPanel() {
    panel.setComponentZOrder(textbox,panel.getComponents().length - 1);
    return panel;
  }
}