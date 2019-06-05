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
  TextBox textbox;
  /*
   * The class constructor. Creates a BufferedImage of the text box and places it at the bottom of the screen.
   */
  public VisualNovel(JPanel panel) {
    this.panel = panel;
    textbox = new TextBox();
    panel.add(textbox);
    
    Person p1 = new Person(2,"angry");
    panel.add(p1);
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
    panel.setComponentZOrder(textbox,panel.getComponents().length - 1);
    return panel;
  }
}