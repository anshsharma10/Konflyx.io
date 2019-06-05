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
 * The TextBox Class. Creates a text box on the screen.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.05.22
 */
public class TextBox extends Component {
  /*
   * The class constructor. This class's primary purpose is to draw a text box onto the screen.
   */
  public TextBox() {
    this.setSize(1080, 200);
    this.setBounds(0,520,1080,200);
  }
  /*
   * The main graphics method to draw the box onto the screen.
   */
  public void paint (Graphics g) {
    super.paint(g);
    try{
      BufferedImage image = ImageIO.read(new File("TextBox.png"));
      g.drawImage(image, 0,0,1080,200,null,null);
    }
    catch (Exception e){
      System.out.println(e);
    }  
  }
}