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
   * The class constructor. This class's primary purpose is to draw a character onto the screen.
   * @param getFile The file to retrieve the character image from.
   */
  public Person(int enemy, String emotion) {
    try {
      File imageFile = new File("enemy" + enemy + "files" + "/" + emotion + ".png");
      image = ImageIO.read(imageFile);
      this.setSize(image.getWidth(), image.getHeight());
      this.setBounds(540 - image.getWidth()/2,-20,image.getWidth(),image.getHeight());
      
    }
    catch (Exception e) {
    }
  }
  
  /*
   * The main graphics method to draw the person onto the screen.
   */
  public void paint (Graphics g) {
    g.drawImage(image, 0, 0,image.getWidth(),image.getHeight(),null,null);
  }
}