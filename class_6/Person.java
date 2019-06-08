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
 * The Character Class. Creates a character on the screen, displaying an emotion.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.04
 */
public class Person extends Component {
  /*
   * The character image.
   */
  BufferedImage image;
  /*
   * The path to the image file.
   */
  String filePath;
  /*
   * The centered position of the image.
   */
  int centPos = 0;
  /*
   * The class constructor. This class's primary purpose is to draw a character onto the screen.
   * @param enemy The enemy to retrieve the emotion from.
   * @param emotion The particular emotion. 1 is happy, 2 is sad, 3 is angry, and 4 is sweaty.
   */
  public Person(int enemy, int emote) {
    String emotion = "";
    if (emote == 1)
      emotion = "happy";
    else if (emote == 2)
      emotion = "sad";
    else if (emote == 3)
      emotion = "angry";
    else if (emote == 4)
      emotion = "sweat";
    try {
      File imageFile = new File("enemy" + enemy + "files" + "/" + emotion + ".png");
      image = ImageIO.read(imageFile);
      this.setSize(image.getWidth(), image.getHeight());
      this.setBounds(540 - image.getWidth()/2,0,image.getWidth(),image.getHeight());
      centPos = 540 - image.getWidth()/2;
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
  
  /*
   * Moves the image to the left, right, or center, depending on input.
   * @param position Where to move the person.
   */
  public void move (String person) {
    if (person.equals("left"))
      setBounds(centPos - 330, getBounds().y, getBounds().width, getBounds().height);
    else if (person.equals("right"))
      setBounds(centPos + 200, getBounds().y, getBounds().width, getBounds().height);
    else if (person.equals("left"))
      setBounds(centPos, getBounds().y, getBounds().width, getBounds().height);
  }
    
    /*
     * The main graphics method to draw the person onto the screen.
     */
    public void paint (Graphics g) {
      g.drawImage(image, 0, 0,image.getWidth(),image.getHeight(),null,null);
    }
  }