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
/***
 * The Character Class. Creates a background on the screen.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.04
 */
public class Background extends Component {
  /***
   * The background image.
   */
  BufferedImage image;
  /***
   * The path to the image file.
   */
  String filePath;
  /***
   * The class constructor. This class's primary purpose is to draw a background onto the screen.
   * @param getFile The file to retrieve the background image from.
   */
  public Background(int num) {
    try {
      File imageFile = new File("backgrounds/bg" + num + ".png");
      image = ImageIO.read(imageFile);
      this.setSize(image.getWidth(), image.getHeight());
      this.setBounds(0,0,1080,720);
    }
    catch (Exception e) {
    }
  }
  
  /***
   * The main graphics method to draw the person onto the screen.
   */
  public void paint (Graphics g) {
    g.drawImage(image, 0, 0,image.getWidth(),image.getHeight(),null,null);
  }
}