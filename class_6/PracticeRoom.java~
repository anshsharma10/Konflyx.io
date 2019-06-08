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
    long startTime = System.currentTimeMillis();
    int elapsedTime = 0;
    int count = 20;
    Text line1;
    Text line2;
      line1 = new Text (null,  40,40,  true,  false,  false,  50,  20, "/" + (words[(int)(Math.random()*999)]).toUpperCase(), panel);
      line1.draw();
      line2 = new Text (null,  40,40,  true,  false,  false,  50,  60, "/" + (words[(int)(Math.random()*999)]).toUpperCase(), panel);
      line2.draw();
    
    while (elapsedTime < 0.05*60*1000) {
      elapsedTime = (int)((new Date()).getTime() - startTime);
    }
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