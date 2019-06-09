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
 * The MainMenu Class. A JPanel that displays all menu-related text on screen.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class MainMenu extends JPanel {
  /*
   * The class constructor. Creates and draws all relevant images.
   */
  public MainMenu() {
    this.setLayout(null);
    this.setPreferredSize(new Dimension(1080,720));
    this.setSize(1080,720);
    this.add(new MenuScreen("mainMenu"));
  }
}