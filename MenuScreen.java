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
 * The MenuScreen Class. Creates a menu screen image.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class MenuScreen extends Component {
  /**
   * The menu to draw.
   */
  String menu;
  /**
   * The class constructor. This class's primary purpose is to create a menu screen image.
   */
  public MenuScreen(String menu) {
    this.menu = menu;
    this.setBounds(0,0,1080,720);
    this.setSize(1080,720);
  }
  /**
   * The main graphics method to draw the border onto the screen.
   */
  public void paint (Graphics g) {
    super.paint(g);
    try{
      BufferedImage image = ImageIO.read(new File("menus/" + menu + ".png"));
      g.drawImage(image, 0,0,1080,720,null,null);
    }
    catch (Exception e){
      System.out.println(e);
    }  
  }
}