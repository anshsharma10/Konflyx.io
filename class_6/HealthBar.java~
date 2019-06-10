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
 * The HealthBar Class. Creates a health bar on the screen with associated health.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class HealthBar extends Component {
  /*
   * The displayed health in the health bar. Maximum is 100.
   */
  int health;
  /*
   * The class constructor. Sets health.
   * @param health The current health of the user.
   */
  public HealthBar(int health) {
    this.setSize(97, 701);
    this.setBounds(970,7,97,701);
    this.health = health;
  }
  /*
   * The main graphics method to draw the health bar onto the screen.
   */
  public void paint (Graphics g) {
    super.paint(g);
    try{
      BufferedImage image = ImageIO.read(new File("HealthBar.png"));
      g.setColor(Color.red);
      g.fillRect(72,7 + (int)(650-(650.0/100)*health),20,(int)((650.0/100)*health));
      g.drawImage(image, 0,0,97,701,null,null);
    }
    catch (Exception e){
      System.out.println(e);
    }  
  }
  /*
   * Increments the health bar.
   * @param health The value to increase or decrease by.
   */
  public void incrementHealth (int modifier) {
    this.health += modifier;
    repaint();
  }
    /*
   * Returns the health.
   * @return The current health.
   */
  public int getHealth () {
    return health;
  }
}