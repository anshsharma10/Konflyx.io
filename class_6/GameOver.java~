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
 * The GameOver Class. Creates a game over screen image.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class GameOver extends JPanel implements ActionListener{
  /*
   * Checks to see if the continue text has been typed.
   */
  javax.swing.Timer continueTimer = new javax.swing.Timer(150,this);
  /*
   * The boolean that indicates that the player wishes to continue.
   */
  boolean cont = false;
  /*
   * The game over text to type.
   */
  Text gameOverText;
  /*
   * The class constructor. This class's primary purpose is to create a game over screen.
   */
  public GameOver() {
    this.setBounds(0,0,1080,720);
    this.setSize(1080,720);
    this.setLayout(null);
    add(new BlackScreen());
    gameOverText = new Text(null,  90, 180,  true,  false,  false, 120,  200, "/Game over", this);
    Text supText = new Text(null,  30, 60,  false,  false,  false, 45,  400, "/Take a deep breath and try again.", this);
    gameOverText.draw();
    supText.draw();
    gameOverText.focusLetter();
  }
  /*
   * Checks if the text has been fully typed.
   */
  public void actionPerformed(ActionEvent e) {
    gameOverText.focusLetter();
    if (gameOverText.finishedLine())
      cont = true;
  }
  /*
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
  /*
   * Returns whether or not the user has chosen to continue.
   * @return Whether or not the user has chosen to continue.
   */
  public boolean contGame() {
    return cont;
  }
}