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
public class Character extends Component {
  /*
   * The character image.
   */
  BufferedImage image;
  /*
   * The class constructor. This class's primary purpose is to draw a character onto the screen.
   * @param getFile The file to retrieve the character image from.
   */
  public void TextBox(String getFile) {
   // File imageFile = new File(getFile + ".png");
    //BufferedImage image = ImageIO.read(imageFile);
    //g.drawImage(image, 0, 0,letter_sizeX,letter_sizeY,letter_colour,null);
    
    this.setSize(1080, 200);
    this.setBounds(0,520,1080,200);
  }
}