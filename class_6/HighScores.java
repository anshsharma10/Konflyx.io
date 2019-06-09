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
 * The HighScores Class. A JPanel that displays the previous high scores.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class HighScores extends JPanel {
  /*
   * The class constructor. Creates and draws all relevant text.
   */
  public HighScores() {
    this.setLayout(null);
    this.setPreferredSize(new Dimension(1080,720));
    this.setSize(1080,720);
    this.add(new MenuScreen("highScores"));
    String title = "High Scores";
    Text t = new Text(null,  45, 90,  false,  true,  false, Text.centerTextXPosition(45,title.length()),  45, title, this);
    String highScores = "Enter high scores here";
    Text t2 = new Text(null,  20, 40,  false,  false,  false, 50,  170, highScores, this);
    t.draw();
    t2.draw();
    getPanel();
  }
  /*
   * Reorders the current JPanel to account for layers.
   */
  public void getPanel() {
    Component[] components = this.getComponents();
    for (int i = 0; i < components.length; i++) {
      if (components[i] instanceof Letter)
        this.setComponentZOrder(components[i],0);
      else if (components[i] instanceof Border)
        this.setComponentZOrder(components[i],1);
      else if (components[i] instanceof MenuScreen)
        this.setComponentZOrder(components[i],components.length - 1);
    }
  }
}