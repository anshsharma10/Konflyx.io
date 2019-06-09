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
public class TextDriverClass extends JFrame implements ActionListener, KeyListener{
  /*
   * The panel to work with.
   */
  JPanel panel;
  /*
   * The background to work with.
   */
  Background background;
  /*
   * The current game mode. 0 is visual novel, 1 is text selection, and 2 is gameplay. For use in keylistening.
   */
  int gameMode = 1;
  /*
   * The gameplay object to work with.
   */
  Gameplay game;
  /*
   * The tree the gameplay object will use.
   */
  int gameTree = 1;
  /*
   * The visual novel to work with.
   */
  VisualNovel vn;
  /*
   * The TextSelector to work with.
   */
  TextSelector ts;
  /*
   * The timer used to manage gameplay.
   */
  javax.swing.Timer timer = new javax.swing.Timer(150,this);
  /*
   * The stage of the game. Each stage is a different part.
   */
  int stage = 0;
  /*
   * The maximum stage of the game. For use in stage selection from the main menu.
   */
  int maxStage = 0;
  /*
   * Class constructor
   */
  public TextDriverClass () {
    
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    nextStage();
  }
  /*
   * Moves on to the next stage of the game.
   */
  public void nextStage() {
    if (stage == 0) {
      vn = new VisualNovel("level1");
      vn.setLayout(null);
      vn.setPreferredSize(new Dimension(1080,720));
      add(vn);
      vn.addText();
      timer.start();
    } else if (stage == 1) {
      panel = new JPanel();
      panel.setLayout(null);
      panel.setPreferredSize(new Dimension(1080,720));
      panel.setSize(1080,720);
      pack();
      add(panel);
      background = new Background(1);
      panel.add(background);
      ts = new TextSelector(panel, "A hot dog is...", new String[]{"A sandwich","Not a sandwich"}); 
      Component[] components = panel.getComponents();
      for (int i = 0; i < components.length; i++) {
        if (components[i] instanceof Letter)
          panel.setComponentZOrder(components[i],0);
        else if (components[i] instanceof Border)
          panel.setComponentZOrder(components[i],1);
        else if (components[i] instanceof Background)
          panel.setComponentZOrder(components[i],2);
      }
      panel.repaint();
      this.addKeyListener(this);
      this.requestFocus();
    } else if (stage == 2) {
      game = new Gameplay(1, gameTree);
      game.setLayout(null);
      game.setPreferredSize(new Dimension(1080,720));
      add(game);
      game.next();
      game.requestFocus();
      timer.start();
    }
    setVisible(true);
    this.pack();
    System.out.println(stage);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (vn != null && vn.isComplete() == true) {
      remove(vn);
      timer.stop();
      stage++;
      nextStage();
    } else if (game != null && game.isComplete() == true) {
      remove(game);
      timer.stop();
      stage++;
      nextStage();
    }
  }
  
  /*
   * Method that runs if a key is pressed. Changes text selector.
   */
  public void keyPressed(KeyEvent e) {
    if (stage == 1) {
      int keyValue = e.getKeyCode();
      if (keyValue == 87 || keyValue == 38) {
        ts.moveUp();
      }
      else if (keyValue == 83 || keyValue == 40) {
        ts.moveDown();
      }
      else if (keyValue == 10 || keyValue == 32) {
        ts.cleanUp();
        if (ts.getSelection().equals("A sandwich"))
          gameTree = 1;
        else
          gameTree = 2;
        this.removeKeyListener(this);
        stage++;
        nextStage();
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
  
  public static void main (String[] args) {
    
    TextDriverClass driver = new TextDriverClass();
    
  }
  
}
