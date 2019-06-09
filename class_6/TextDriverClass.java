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
 * The TextDriverClass Class. Creates an example of the use of the Text and Letter classes.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.05.22
 */
public class TextDriverClass extends JFrame{
  /*
   * The panel to work with.
   */
  JPanel panel;
  /*
   * The current game mode. 0 is visual novel, 1 is text selection, and 2 is gameplay. For use in keylistening.
   */
  int gameMode = 1;
  /*
   * The visual novel to work with.
   */
  VisualNovel vn;
  /*
   * The TextSelector to work with.
   */
  TextSelector ts;
  /*
   * Class constructor
   */
  public TextDriverClass () {
    
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    Gameplay game = new Gameplay(1);
    game.setLayout(null);
    game.setPreferredSize(new Dimension(1080,720));
    add(game);
    game.next();
    
    setVisible(true);
    this.pack();
    
  }
  
  public static void main (String[] args) {
    
    TextDriverClass driver = new TextDriverClass();
    
  }
}
