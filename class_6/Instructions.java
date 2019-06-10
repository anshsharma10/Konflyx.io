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
 * The Instructions Class. A JPanel that displays the game instructions.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class Instructions extends JPanel {
  /*
   * The class constructor. Creates and draws all relevant text.
   */
  public Instructions() {
    this.setLayout(null);
    this.setPreferredSize(new Dimension(1080,720));
    this.setSize(1080,720);
    this.add(new MenuScreen("instructions"));
    String title = "Instructions";
    Text t = new Text(null,  45, 90,  false,  true,  false, Text.centerTextXPosition(45,title.length()),  45, title, this);
    String instructions = "/In this game, you will learn about dealing with";
    String instructions2 = "/conflict with others# Each level features a";
    String instructions3 = "/different enemy, and a different challenge#";
    String instructions4 = "/To fight an enemy, pick a statement and type";
    String instructions5 = "/your sentence faster than they can type theirs#";
    String instructions6 = "/If they type first, then you will lose health#";
    String instructions7 = "/Lose all your health and you'll have to";
    String instructions8 = "/restart the level!";
    String instructions9 = "/Good luck! Press spacebar or enter to head back#";
    Text t2 = new Text(null,  20, 40,  false,  false,  false, 50,  170, instructions, this);
    Text t3 = new Text(null,  20, 40,  false,  false,  false, 50,  220, instructions2, this);
    Text t4 = new Text(null,  20, 40,  false,  false,  false, 50,  270, instructions3, this);
    Text t5 = new Text(null,  20, 40,  false,  false,  false, 50,  320, instructions4, this);
    Text t6 = new Text(null,  20, 40,  false,  false,  false, 50,  370, instructions5, this);
    Text t7 = new Text(null,  20, 40,  false,  false,  false, 50,  420, instructions6, this);
    Text t8 = new Text(null,  20, 40,  false,  false,  false, 50,  470, instructions7, this);
    Text t9 = new Text(null,  20, 40,  false,  false,  false, 50,  520, instructions8, this);
    Text t10 = new Text(null,  20, 40,  false,  false,  false, 50,  600, instructions9, this);
    t.draw();
    t2.draw();
    t3.draw();
    t4.draw();
    t5.draw();
    t6.draw();
    t7.draw();
    t8.draw();
    t9.draw();
    t10.draw();
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