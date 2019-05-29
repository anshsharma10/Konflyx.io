import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Component;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.image.*;
/*
 * The Letter class. Creates a letter using JFrame to easily create sentences.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.22
 */
public class Letter extends Component implements ActionListener,KeyListener{
  /*
   * The colour of the letter.
   */
  Color letter_colour;
  /*
   * The size of the letter.
   */
  int letter_sizeX;
  int letter_sizeY;
  /*
   * Whether or not the letter will animate when on screen.
   */
  boolean idleAnimation;
  /*
   * Whether or not the letter will animate into the scene.
   */
  boolean animateIn;
  /*
   * Whether or not the letter will animate out of the scene.
   */
  boolean animateOut;
  /*
   * The horizontal position of the bottom-leftmost part of the letter on the screen, in pixels.
   */
  int posX;
  /*
   * The vertical position of the bottom-leftmost part of the letter on the screen, in pixels.
   */
  int posY;
  /*
   * The String value of the letter to represent.
   */
  String letter;
  
  int valX = 2;
  int valY = 2;
  int keyValue;
  int conX,conY;
  Timer tm = new Timer(100, this);
  
  /*
   * The class constructor. Creates a Letter object with all variables set.
   * @param colour The letter's colour.
   * @param size The letter's size.
   * @param idleAnim Whether or not the letter animates on screen.
   * @param inAnim Whether or not the letter animates into the screen.
   * @param outAnim Whether or not the letter animates out of the screen.
   * @param x The horizontal position of the letter.
   * @param y The vertical position of the letter.
   * @param let The letter to represent.
   */
  public Letter (Color colour, int sizeX, int sizeY, boolean idleAnim, boolean inAnim, boolean outAnim, int x, int y, String let) {
    letter_sizeX = sizeX;
    letter_sizeY = sizeY;
    letter_colour = colour;
    idleAnimation = idleAnim;
    animateIn = inAnim;
    animateOut = outAnim;
    posX = x;
    posY = y;
    conX = x;
    conY = y;
    letter = let;
    this.setSize(letter_sizeX, letter_sizeY);
    this.setBounds(posX,posY,letter_sizeX,letter_sizeY);
    this.addKeyListener(this);
    this.setFocusable(true);
    tm.start();
  }
  /*
   * Draws the letter with respective colour and size. Will animate while drawing if animateIn is on. Also calls animateIdle() if animateIdle is on.
   * @param g The graphics to draw onto.
   */
  public void paint (Graphics g) {
    super.paint(g);
    try{
      File imageFile = new File(letter + ".png");
      BufferedImage image = ImageIO.read(imageFile);
      g.drawImage(image, 0, 0,letter_sizeX,letter_sizeY,letter_colour,null);
    }
    catch (Exception e){
    }  
  }
  
  public void actionPerformed(ActionEvent e){
    if (idleAnimation){
      if(posX < conX || posX > letter_sizeX)
        valX = -valX;
      
      if(posY < conY || posY > letter_sizeY)
        valY = -valY;
      
      posY = posY + valY;
      posX = posX + valX;
      this.setBounds(posX,posY,letter_sizeX,letter_sizeY);
      repaint();}
    else{
      tm.stop();
    }
  }
  
  /* 
   * Erases the letter. Will animate out if animateOut is on.
   */
  public void erase() {
    if (animateOut) {
      try {
        Thread.sleep(100);
        this.setBounds(0,0,0,0);
      } catch (Exception e) {
        System.out.println(e);
      }
    } else
      this.setBounds(0,0,0,0);
  }
  /*
   * Returns the size of the letter, for use in the Text class.
   */
  public int getWidth() {
    return letter_sizeX;
  }
  
  public void keyPressed(KeyEvent e) {  
    keyValue = e.getKeyCode();  
    if (keyValue)
  }
  
  public void keyReleased(KeyEvent e) {    
  }  
  public void keyTyped(KeyEvent e) {  
  }
}