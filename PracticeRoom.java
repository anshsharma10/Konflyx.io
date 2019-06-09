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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*
 * The VisualNovel class. Creates a simple visual novel system for the driver and level classes to use. Contains methods
 * used for the visual novel.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.30
 */
public class PracticeRoom implements KeyListener{
  /*
   * The JPanel to work with.
   */
  JPanel panel;
  TextBox textbox;
  String words[] = new String [1000];
  Text startLine;
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
      
    }
    catch (IOException e){ 
    }
    startLine = new Text (null,  40,100,  false,  false,  false,  75,  400, "/PRESS ENTER TO START", panel);
    this.panel = panel;
    textbox = new TextBox();
    panel.add(textbox);
    startLine.draw();
    panel.addKeyListener(this);
    panel.setFocusable(true);
  }
  /*
   * Adds text to the screen using the Text and Letter classes, with a character and their respective emotion displayed.
   * @return The JPanel after text is added.
   */
  
  public void addText () {
    long startTime = System.currentTimeMillis();
    
    TimerTask repeatedTask = new TimerTask() {      
      int firstY = 340;
      int secondY = 400;
      
      boolean drawLine = true;
      
      Text line1 = new Text (null,  25,50,  true,  false,  false,  20,  firstY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line2 = new Text (null,  25,50,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line3 = new Text (null,  25,50,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line4 = new Text (null,  25,50,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line5 = new Text (null,  25,50,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line6 = new Text (null,  25,50,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line7 = new Text (null,  25,50,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line8 = new Text (null,  25,50,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      
      
      public void run() {
        if (drawLine){
          line1.draw();
          line2.draw();
          drawLine = false;
        }
        
        if(line1.finishedLine()){
          line1.erase();
          line2.updateLetPos(20,firstY);
          line2.turnOnIdleAnim();
          line3.draw();
        }
        
        if(line2.finishedLine()){
          line2.erase();
          line3.updateLetPos(20,firstY);
          line3.turnOnIdleAnim();
          line4.draw();
        }
        
        if(line3.finishedLine()){
          line3.erase();
          line4.updateLetPos(20,firstY);
          line4.turnOnIdleAnim();
          line5.draw();
        }
        
        if(line4.finishedLine()){
          line4.erase();
          line5.updateLetPos(20,firstY);
          line5.turnOnIdleAnim();
          line6.draw();
        }
        
        if(line5.finishedLine()){
          line5.erase();
          line6.updateLetPos(20,firstY);
          line6.turnOnIdleAnim();
          line7.draw();
        }
        
        if(line6.finishedLine()){
          line6.erase();
          line7.updateLetPos(20,firstY);
          line7.turnOnIdleAnim();
          line8.draw();
        }
        
        if (0.50*60*1000<(System.currentTimeMillis() - startTime)){
          line1.erase();
          line2.erase();
          line3.erase();
          line4.erase();
          line5.erase();
          line6.erase();
          line7.erase();
          line8.erase();
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
  public void keyPressed(KeyEvent e) {
    int keyValue = e.getKeyCode();
    if (keyValue == 10){
      panel.setFocusable(false);
      startLine.erase();
      addText();
    }
  }
  public void keyReleased(KeyEvent e) {    
  }  
  public void keyTyped(KeyEvent e) {  
  }
}