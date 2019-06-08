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
public class TextDriverClass extends JFrame implements KeyListener{
  /*
   * The panel to work with.
   */
  JPanel panel;
  /*
   * The current game mode. 0 is visual novel, 1 is text selection, and 2 is gameplay. For use in keylistening.
   */
  int gameMode = 1;
  /*
   * The visual novel to work with.
   */
  VisualNovel vn;
  /*
   * The TextSelector to work with.
   */
  TextSelector ts;
  /*
   * Selected Text to type.
   */
  String toBeTyped;
  /*
   * Class constructor
   */
  public TextDriverClass () {
    
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    panel = new JPanel();
    panel.setLayout(null);
    panel.setPreferredSize(new Dimension(1080,720));
    add(panel);
    
    setVisible(true);
    this.pack();
    
  }
  /*
   * Method that runs if a key is pressed. Advances text in the visual novel if mode is 0, and moves the selector in TextSelection if mode is 1.
   */
  public void keyPressed(KeyEvent e) {
    if (gameMode == 0) {
      if (vn.getIndex() == vn.getLines())
        this.removeKeyListener(this);
      else {
        int keyValue = e.getKeyCode();
        if (keyValue == 10 || keyValue == 32)
          panel = vn.addText();
      }
    } else if (gameMode == 1) {
      int keyValue = e.getKeyCode();
      if (keyValue == 87 || keyValue == 38) {
        ts.moveUp();
      }
      else if (keyValue == 83 || keyValue == 40) {
        ts.moveDown();
      }
      else if (keyValue == 10 || keyValue == 32) {
        toBeTyped = ts.getSelection();
        System.out.println(toBeTyped);
        panel = ts.cleanUp();
        this.removeKeyListener(this);
      }
    }
  }
  /*
   * Method that runs if a key is released.
   */
  public void keyReleased(KeyEvent e) {
  }
  /*
   * Method that runs if a key is typed.
   */
  public void keyTyped(KeyEvent e) {
  }
  /*
   * The main method that runs the Text and Letter classes.
   */
  public static void main (String[] args) {
    
    TextDriverClass driver = new TextDriverClass();
    
  }
}
