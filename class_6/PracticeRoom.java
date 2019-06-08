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
  }   
  catch (IOException e){ 
  }
  }
  /*
   * Adds text to the screen using the Text and Letter classes, with a character and their respective emotion displayed.
   * @return The JPanel after text is added.
   */
  public void addText () {
    Text t2 = new Text (new Color (25,25,25),  40,40,  true,  false,  false,  50,  20, words[(int)(Math.random()*999)] + "hi", panel);
    t2.draw();
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