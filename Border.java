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
/**
 * The Border Class. Creates a text border on the screen.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class Border extends Component {
  /**
   * The class constructor. This class's primary purpose is to draw a text border onto the screen.
   */
  public Border(int ypos) {
    this.setSize(952, 101);
    this.setBounds(60,ypos,952,101);
  }
  /**
   * The main graphics method to draw the border onto the screen.
   */
  public void paint (Graphics g) {
    super.paint(g);
    try{
      BufferedImage image = ImageIO.read(new File("Border.png"));
      g.drawImage(image, 0,0,952,101,null,null);
    }
    catch (Exception e){
      System.out.println(e);
    }  
  }
}