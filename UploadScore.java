import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Component;
import java.awt.Color;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
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
public class UploadScore extends JPanel implements KeyListener{
  /**
   * The boolean that indicates that the player uploaded their score.
   */
  boolean done = false;
  /**
   * The intitials the user will type.
   */
  String initials;
  /**
   * The score the user has.
   */
  int score;
  /**
   * The class constructor. This class's primary purpose is to create a game over screen.
   */
  public UploadScore(int score) {
    this.score = score;
    this.setBounds(0,0,1080,720);
    this.setSize(1080,720);
    this.setLayout(null);
    add(new BlackScreen());
    initials = "";
    Text goodJobText = new Text(null,  90, 180,  false,  true,  false, 120,  200, "/Good job!", this);
    Text supText = new Text(null,  30, 60,  false,  true,  false, 135,  400, "/Input your initials below:", this);
    goodJobText.draw();
    supText.draw();
    this.addKeyListener(this);
    this.setFocusable(true);
    this.requestFocus();
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
        this.setComponentZOrder(components[i],components.length - 1);
    }
  }
  /**
   * Returns whether or not the user has uploaded their score.
   * @return Whether or not the user has uploaded their score.
   */
  public boolean isDone() {
    return done;
  }
  
  /**
   * Method that runs if a key is pressed. Allows the user to type in their initials, then saves the score to a file if it is high enough to be a high score.
   * @param KeyEvent the key event.
   */
  public void keyPressed(KeyEvent e) {
    int keyValue = e.getKeyCode();
    if (initials.length() < 3) {
      initials += Character.toString((char)keyValue);
      Text t = new Text(null, 70, 140, false, false, false, 380 + 70*initials.length(), 480, Character.toString((char)keyValue), this);
      t.draw();
      getPanel();
    }
    else if ((keyValue == 10 || keyValue == 32) && initials.length() == 3) {
      try {
        Scanner scan = new Scanner(new File("highScores.txt")); 
        ArrayList <String> initialsArr = new ArrayList<String>();
        ArrayList <Integer> scores = new ArrayList<Integer>();
        for (int i = 0; i < 10 && scan.hasNextLine(); i++) {
          String line = scan.nextLine();
          initialsArr.add(line.substring(0,3));
          scores.add(Integer.parseInt(line.substring(3)));
        }
        
        System.out.println(initialsArr);
        System.out.println(scores);
        for (int i = 9; i >= 0; i--) {
          if (i == 9 && score > scores.get(i)){
            initialsArr.set(i,initials);
            scores.set(i,score);
          } else if (score > scores.get(i)) {
            initialsArr.remove(i+1);
            scores.remove(i+1);
            initialsArr.add(i,initials);
            scores.add(i,score);
          }
          System.out.print(i);
        }
        System.out.println(initialsArr);
        System.out.println(scores);
        File printScores = new File("highScores.txt");
        PrintWriter printWriter = new PrintWriter(printScores);
        for (int i = 0; i < 10; i++) {
          printWriter.println(initialsArr.get(i) + scores.get(i));
        }
        printWriter.close();
        this.removeKeyListener(this);
        done = true;
      }     catch (Exception ex) {
        System.out.println(ex);
      }
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