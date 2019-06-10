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
/**
 * The GameOver Class. Creates a game over screen image.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class GameOver extends JPanel implements KeyListener{
  /**
   * The boolean that indicates that the player wishes to continue.
   */
  boolean cont = false;
  /**
   * The game over text to type.
   */
  Text gameOverText;
  /**
   * The class constructor. This class's primary purpose is to create a game over screen.
   */
  public GameOver() {
    this.setBounds(0,0,1080,720);
    this.setSize(1080,720);
    this.setLayout(null);
    add(new BlackScreen());
    gameOverText = new Text(null,  90, 180,  false,  true,  false, 120,  200, "/Game over", this);
    Text supText = new Text(null,  30, 60,  false,  true,  false, 45,  400, "/Take a deep breath and try again.", this);
    gameOverText.draw();
    supText.draw();
    this.addKeyListener(this);
  }
  /**
   * Reorders all layers.
   */
  public void getPanel() {
    Component[] components = this.getComponents();
    for (int i = 0; i < components.length; i++) {
      if (components[i] instanceof Letter)
        this.setComponentZOrder(components[i],0);
      else if (components[i] instanceof BlackScreen)
        this.setComponentZOrder(components[i],1);
    }
  }
  /**
   * Returns whether or not the user has chosen to continue.
   * @return Whether or not the user has chosen to continue.
   */
  public boolean contGame() {
    return cont;
  }
  
  /**
   * Method that runs if a key is pressed. Sets continue to true.
   */
  public void keyPressed(KeyEvent e) {
          int keyValue = e.getKeyCode();
      if (keyValue == 10 || keyValue == 32) {
        cont = true;
        this.removeKeyListener(this);
      }
  }
  /**
   * Method that runs if a key is released.
   */
  public void keyReleased(KeyEvent e) {
  }
  /**
   * Method that runs if a key is typed.
   */
  public void keyTyped(KeyEvent e) {
  }
}