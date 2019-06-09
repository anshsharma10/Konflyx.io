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
 * The Letter class. Creates a letter using JFrame to easily create sentences.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.22
 */
public class Text{
  /*
   * The colour of the text.
   */
  Color text_colour;
  /*
   * The size of the text.
   */
  int text_sizeX;
  int text_sizeY;
  /*
   * Whether or not the text will animate when on screen.
   */
  boolean idleAnimation;
  /*
   * Whether or not the text will animate into the scene.
   */
  boolean animateIn;
  /*
   * Whether or not the text will animate out of the scene.
   */
  boolean animateOut;
  /*
   * The horizontal position of the bottom-leftmost part of the text on the screen, in pixels.
   */
  int posX;
  /*
   * The vertical position of the bottom-leftmost part of the text text on the screen, in pixels.
   */
  int posY;
  /*
   * An ArrayList containing each letter in the text.
   */
  ArrayList <Letter> textList;
  /*
   * The JPanel to add the text to.
   */
  JPanel panel;
  int contSize;
  /*
   * The class constructor. Creates a Text object with all variables set. Additionally, creates an ArrayList of Letters, one Letter for each letter in the contents String.
   * @param colour The text's colour.
   * @param size The text's size.
   * @param idleAnim Whether or not the text animates on screen.
   * @param inAnim Whether or not the text animates into the screen.
   * @param outAnim Whether or not the text animates out of the screen.
   * @param x The horizontal position of the text.
   * @param y The vertical position of the text.
   * @param contents The contents of the text.
   * * @param panel The panel to add the text to.
   */
  public Text (Color colour, int sizeX, int sizeY, boolean idleAnim, boolean inAnim, boolean outAnim, int x, int y, String contents, JPanel panel) {
    text_colour = colour;
    text_sizeX = sizeX;
    text_sizeY = sizeY;
    idleAnimation = idleAnim;
    animateIn = inAnim;
    animateOut = outAnim;
    posX = x;
    posY = y;
    contSize = contents.length();
    textList = new ArrayList <Letter> ();
    this.panel = panel;
    
    for (int i = 0; i < contents.length(); i++) {
      if (i > 0 && (contents.substring(i,i+1)).equals("/")){
        posY+=text_sizeY;
        posX-=(i-1)*text_sizeX;
      }
      textList.add(new Letter(text_colour, text_sizeX, text_sizeY, idleAnimation, animateIn, animateOut, posX + (i-1)*text_sizeX, posY, contents.substring(i,i+1), i, contSize));
    }
  }
  /*
   * Draws the text with respective colour and size by calling draw() on each letter within the letters ArrayList.
   * Will animate while drawing if animateIn is on. Also calls animateIdle() if animateIdle is on.
   */
  public JPanel draw () {
    for (Letter lett: textList){
      panel.add(lett);
    }
    return panel;
  }
  /*
   * Erases the text by calling erase() on each letter within the letters ArrayList.
   * Will animate out if animateOut is on.
   */
  public JPanel erase() {
    for (Letter lett: textList){
      lett.erase();
    }
    panel.repaint();
    return panel;
  }
  
  public void focusLetter() {
    for (Letter letter : textList) {
      if (letter.getIdle()) {
        letter.requestFocus();
        break;
      }
    }
  }
  
  public void turnOnIdleAnim() {
    for (Letter lett: textList){
      lett.turnOnIdle();
    }
  }
  
  public void updateLetPos(int x, int y) {
    int count = -1;
    for (Letter lett: textList){
      lett.updatePos(x + count*text_sizeX ,y);
      count++;
    }
  }
  
  public boolean finishedLine(){
    return textList.get(contSize-1).finishedLine();
  }
  
  /*
   * Returns the required x position of a given text length to center the text.
   * @param size The horizontal size of each text's letter.
   * @param length The length of the text, in characters.
   * @return The required x position to center the text.
   */
  public static int centerTextXPosition (int size, int length) {
    return (1080 - size*length)/2;
  }
}
