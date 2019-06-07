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
 * The VisualNovel class. Creates a simple visual novel system for the driver and level classes to use. Contains methods
 * used for the visual novel.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.30
 */
public class VisualNovel {
  /*
   * The JPanel to work with.
   */
  JPanel panel;
  /*
   * The TextBox to work with.
   */
  TextBox textbox;
  /*
   * The Person to work with.
   */
  Person person;
  /*
   * The background to work with.
   */
  Background background;
  /*
   * The class constructor. Creates the visual novel.
   */
  public VisualNovel(JPanel panel) {
    this.panel = panel;
    textbox = new TextBox();
    panel.add(textbox);
    
    Person p1 = new Person(3,"happy");
    panel.add(p1);
    
    Background b1 = new Background(2);
    panel.add(b1);
    
    Text t = new Text (new Color (25,25,25),  40,40,  false,  false,  true,  50,  20, "TEST", panel);  
    Text t2 = new Text (null,  20,40,  true,  false,  false,  20,  540, "/TEST ONE/TEST TWO", panel);  
    panel = t2.draw();     
    panel = t.draw();
    
    panel = t2.draw();     
    panel = t.draw();
    

    try {
      Thread.sleep(3000);
      panel = t.erase();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  /*
   * Adds a background to the JPanel.
   * @param The background int to add.
   * @return The JPanel after text is added.
   */
  public void addBg (int bg) {
    background = new Background(bg);
  }
  /*
   * Adds text to the screen using the Text and Letter classes, with a character and their respective emotion displayed.
   * @return The JPanel after text is added.
   */
  public void addText () {
    
  }
  /*
   * Returns the current JPanel.
   * @return the JPanel.
   */
  public JPanel getPanel() {
    Component[] components = panel.getComponents();
    for (int i = 0; i < components.length; i++) {
      if (components[i] instanceof TextBox)
        panel.setComponentZOrder(textbox,1);
      else if (components[i] instanceof Person)
        panel.setComponentZOrder(components[i],2);
      else if (components[i] instanceof Background)
        panel.setComponentZOrder(components[i],3);
      else if (components[i] instanceof Letter)
        panel.setComponentZOrder(components[i],0);
    }
    return panel;
  }
}