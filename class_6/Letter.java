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
 * @date @date 2019.06.10
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
  public String letter;
  /*
   * The index of this letter within the Text.
   */
  int index;
  /*
   * The value for idle animation movement
   */
  int valX = 2;
  /*
   * The value for idle animation movement
   */
  int valY = 2;
  /*
   * The value for input
   */
  int keyValue;
  /*
   * The constant value of original location
   */
  int conX,conY;
  /*
   * The timers for the individual animations
   */
  Timer idleTimer = new Timer(100, this);
  Timer introTimer = new Timer(GameTracker.getDifficulty(), this);
  /*
   * Each letter file has its on sufix that determines the colour
   */
  String colorOfLetter = "";
  /*
   * The status of the last letters input
   */
  boolean lastLet = false;
  /*
   * The size of the string of text
   */
  int stringSize;
  /*
   * The value of whether or not the letter was pressed
   */
  int press = 0;
  
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
   * @param num The index this letter is within the Text class.
   */
  public Letter (Color colour, int sizeX, int sizeY, boolean idleAnim, boolean inAnim, boolean outAnim, int x, int y, String let, int num, int size) {
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
    letter = let.toUpperCase();
    index = num;
    stringSize = size;
    this.setSize(letter_sizeX, letter_sizeY);
    this.setBounds(posX,posY,letter_sizeX,letter_sizeY);
    
    if (animateIn == false && idleAnimation && !(letter.equals("/")) ) {
      this.addKeyListener(this);
      this.setFocusable(true);
      idleTimer.start();
    }
    if (animateIn == true) {
      this.setVisible(false);
      introTimer.setInitialDelay(GameTracker.getDifficulty()*(index + 1));
      introTimer.start();
    }
    if (!idleAnimation && !animateIn && !animateOut  && !(letter.equals("/"))){
      this.addKeyListener(this);
      this.setFocusable(true);
    }
  }
  /*
   * Draws the letter with respective colour and size. Will animate while drawing if animateIn is on. Also calls animateIdle() if animateIdle is on.
   * @param g The graphics to draw onto.
   */
  public void paint (Graphics g) {    
    super.paint(g);
    try{
      File imageFile = new File("textfiles\\"+letter + colorOfLetter+ ".png");
      BufferedImage image = ImageIO.read(imageFile);
      g.drawImage(image, 0, 0,letter_sizeX,letter_sizeY,letter_colour,null);
    }
    catch (Exception e){
    }
  }
  
  /*
   * The action of the letter while a timer is running. (Animation)
   */
  public void actionPerformed(ActionEvent e){
    if (animateIn && introTimer.isRunning()){
      this.setVisible(true);
      introTimer.stop();
      if (index == stringSize-1)
        lastLet = true;
    }
    else if (idleAnimation && idleTimer.isRunning()){
      if(posX < conX || posX > letter_sizeX)
        valX = -valX;
      
      if(posY < conY || posY > letter_sizeY)
        valY = -valY;
      
      posY = posY + valY;
      posX = posX + valX;
      
      this.setBounds(posX,posY,letter_sizeX,letter_sizeY);
      repaint();}
    else{
      this.setBounds(conX,conY,letter_sizeX,letter_sizeY);
      idleTimer.stop();
    }
  }
  /*
   * Erases the letter. Will animate out if animateOut is on.
   */
  public void erase() {
    if (animateOut) {
      try {
        Thread.sleep(150);
        this.setBounds(0,0,0,0);
      } catch (Exception e) {
        System.out.println(e);
      }
      idleTimer.stop();
      this.setFocusable(false);
    } else
      idleTimer.stop();
    if (this.getKeyListeners().length > 0) {
      this.removeKeyListener(this);
    }
    this.setBounds(0,0,0,0);
    this.setFocusable(false);
    lastLet = false;
  }
  
  /*
   * Sends out whether or not the line of text was completed or not
   */
  public boolean finishedLine(){
    return lastLet;
  }
  
  /*
   * If idle is turned off then it can be manually turned on.
   */
  public void turnOnIdle(){
    idleAnimation = true;
    if (animateIn == false && idleAnimation && !(letter.equals("/")) ) {
      idleTimer.start();
      repaint();
    }
  }
  
  /*
   * Updates the position of a text, by moving it to a new location
   */
  public void updatePos(int x, int y){
    posX = x;
    conX = x;
    posY = y;
    conY = y;
    this.setBounds(posX,posY,letter_sizeX,letter_sizeY);
    repaint();
  }
  
  /*
   * Gets to see if the idle animation is currently running or not
   */
  public boolean getIdle () {
    return idleAnimation;
  }
  
  /*
   * Checks when a key is pressed and checks what value was press. If the value matches the letter or any of the special cases then the program continues.
   */
  public void keyPressed(KeyEvent e) {
    if (idleAnimation){
      keyValue = e.getKeyCode();
      if (keyValue == ((int) letter.charAt(0)) || (letter.equals("@") && (keyValue == ((int) "/".charAt(0)))) || (letter.equals("#") && (keyValue == ((int) ".".charAt(0)))) || (letter.equals("!") && (keyValue == ((int) "1".charAt(0))))){
        if (index == stringSize-1) {
          lastLet = true;
        }
        colorOfLetter = "G";
        idleAnimation = false;
        press = 1;
        this.removeKeyListener(this);
        this.setFocusable(false);
        repaint();
      }
      else{
        colorOfLetter = "R";
        repaint();
      }
    }
    //System.out.print(letter + idleAnimation + keyValue);
  }
  
  /*
   * Sends a value to signify whether the character was pressed or not 
   */
  public int isPressed(){
    return press;
  }
  
  public void keyReleased(KeyEvent e) {
  }
  public void keyTyped(KeyEvent e) {
  }
}
