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
  public String letter;
  /*
   * The index of this letter within the Text.
   */
  int index;
  
  int valX = 2;
  int valY = 2;
  int keyValue;
  int conX,conY;
  Timer idleTimer = new Timer(100, this);
  Timer introTimer = new Timer(150, this);
  String colorOfLetter = "";
  boolean lastLet = false;
  int stringSize;
  
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
    letter = let;
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
      introTimer.setInitialDelay(150*(index + 1));
      introTimer.start();
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
  
  public void actionPerformed(ActionEvent e){
    if (animateIn && introTimer.isRunning()){
      this.setVisible(true);
      idleTimer.start();
      introTimer.stop();
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
    this.setBounds(0,0,0,0);
    this.setFocusable(false);
  }
  /*
   * Returns the size of the letter, for use in the Text class.
   */
  public int getWidth() {
    return letter_sizeX;
  }
  
  public boolean finishedLine(){
    return lastLet;
  }
  
  public void keyPressed(KeyEvent e) {
    if (idleAnimation){
      keyValue = e.getKeyCode();
      if (keyValue == ((int) letter.charAt(0))){
        if (index == stringSize-1)
          lastLet = true;
        colorOfLetter = "G";
        idleAnimation = false;
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
   public void changeColour(Color clr){
   
   BufferedImage img = null; 
   File file = null; 
   
   //read image 
   try
   { 
   file = new File("textfiles\\"+letter+".png"); 
   img = ImageIO.read(file); 
   } 
   catch(IOException e) 
   { 
   System.out.println(e); 
   } 
   
   int width = img.getWidth(); 
   int height = img.getHeight(); 
   
   for (int y = 0; y < height; y++) 
   { 
   for (int x = 0; x < width; x++) 
   { 
   int p = img.getRGB(x,y); 
   if (p < 0)
   img.setRGB(x, y, clr.getRGB()); 
   } 
   } 
   
   try
   { 
   file = new File("textfiles\\"+letter + "R.png"); 
   ImageIO.write(img, "png", file); 
   } 
   catch(IOException e) 
   { 
   System.out.println(e); 
   } 
   repaint();
   }
   */
  
  
  public void keyReleased(KeyEvent e) {    
  }  
  public void keyTyped(KeyEvent e) {  
  }
}