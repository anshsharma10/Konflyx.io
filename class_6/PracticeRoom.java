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
  /*
   * Whether or not the room is complete.
   */
  boolean completed = false;
  /*
   * Whether or not the typing section is complete.
   */
  boolean done = false;
  Background bg;
  TextBox tb;
  Text startLine;
  Text wpm;
  Text wpmavg;
  String words[] = new String [1000];
  /*
   * The class constructor. Creates the practiceroom, adding all relevant images.
   */
  public PracticeRoom(JPanel panel) {
    File file = new File("Practice Room Words\\PRWords.txt");     
    done = false;
    completed = false;
    try{ 
      BufferedReader bufread = new BufferedReader(new FileReader(file)); 
      String line;
      for (int i = 0; i < 1000; i++){
        words [i] = bufread.readLine();
      }      
    }catch (IOException e){ 
    }
    
    this.panel = panel;
    bg = new Background(4);
    panel.add(bg);
    tb = new TextBox();
    panel.add(tb);
    displayStart();
  }
  /*
   * Adds text to the screen using the Text and Letter classes, with a character and their respective emotion displayed.
   * @return The JPanel after text is added.
   */
  public void addText () {
    long startTime = System.currentTimeMillis();
    
    TimerTask repeatedTask = new TimerTask() {      
      int firstY = 580;
      int secondY = 640;
      int charPress;
      
      boolean drawLine = true;
      
      Text line1 = new Text (null,  25,45,  true,  false,  false,  20,  firstY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line2 = new Text (null,  25,45,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line3 = new Text (null,  25,45,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line4 = new Text (null,  25,45,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line5 = new Text (null,  25,45,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line6 = new Text (null,  25,45,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line7 = new Text (null,  25,45,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      Text line8 = new Text (null,  25,45,  false,  false,  false,  20,  secondY, "/" + (words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase() + " " +(words[(int)(Math.random()*999)]).toUpperCase(), panel);
      
      public void run() {
        panel = getPanel();
        if (drawLine){
          line1.draw();
          line2.draw();
          drawLine = false;
        }
        
        if(line1.finishedLine()){
          line3.draw();
          line1.erase();
          line2.updateLetPos(20,firstY);
          line2.turnOnIdleAnim();
        }
        
        if(line2.finishedLine()){
          line4.draw();
          line2.erase();
          line3.updateLetPos(20,firstY);
          line3.turnOnIdleAnim();
        }
        
        if(line3.finishedLine()){
          line5.draw();
          line3.erase();
          line4.updateLetPos(20,firstY);
          line4.turnOnIdleAnim();
        }
        
        if(line4.finishedLine()){
          line6.draw();
          line4.erase();
          line5.updateLetPos(20,firstY);
          line5.turnOnIdleAnim();
        }
        
        if(line5.finishedLine()){
          line7.draw();
          line5.erase();
          line6.updateLetPos(20,firstY);
          line6.turnOnIdleAnim();
        }
        
        if(line6.finishedLine()){
          line8.draw();
          line6.erase();
          line7.updateLetPos(20,firstY);
          line7.turnOnIdleAnim();
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
          charPress+=line1.pressCount();
          charPress+=line2.pressCount();
          charPress+=line3.pressCount();
          charPress+=line4.pressCount();
          charPress+=line5.pressCount();
          charPress+=line6.pressCount();
          charPress+=line7.pressCount();
          charPress+=line8.pressCount();
          cancel(); 
          WPM(charPress);
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
  public void WPM(int charPr){
    wpm = new Text (null,  35,80,  false,  false,  false,  280,  225, "/WPM = " + (charPr*2)/5, panel);
    wpm.draw();
    wpmavg = new Text (null,  35,80,  false,  false,  false,  280,  350, "/AVG WPM = 40", panel);
    wpmavg.draw();
    done = true;
    panel = getPanel();
    panel.setFocusable(true);
    panel.requestFocus();
  }
  /*
   * Returns whether or not the practice room has been completed.
   * @return The completion.
   */
  public boolean isComplete() {
    return completed;
  }
  
  public void displayStart(){
    startLine = new Text (null,  30,80,  false,  false,  false,  290,  430, "/PRESS ENTER TO START", panel);
    startLine.draw();
    panel = getPanel();
    panel.addKeyListener(this);
    panel.setFocusable(true);
  }
  
  public JPanel getPanel() {
    panel.setComponentZOrder(bg,panel.getComponents().length - 1);
    panel.setComponentZOrder(tb,panel.getComponents().length - 2);
    return panel;
  }
  
  /*
   * Removes all relevant images from the panel.
   */
  public void cleanUp() {
    System.out.println("complete: " + completed);
    panel.remove(bg);
    panel.remove(tb);
    wpm.erase();
    wpmavg.erase();
  }
  
  public void keyPressed(KeyEvent e) {
    int keyValue = e.getKeyCode();
    if (keyValue == 10){
      if(done == true){
        System.out.println("done");
        wpm.erase();
        wpmavg.erase();
        completed = true;
        panel.removeKeyListener(this);
      } else {
      panel.setFocusable(false);
      startLine.erase();
      addText();
      }
    }
  }
  public void keyReleased(KeyEvent e) {    
  }  
  public void keyTyped(KeyEvent e) {  
  }
}