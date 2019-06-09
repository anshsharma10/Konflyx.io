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
 * The GameTracker class. Controls difficulty and tracks WPM. Static, because all game information is stored in the class itself.
 * @author Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class GameTracker {
  /*
   * The difficulty of the game, represented by milliseconds taken for an enemy to type one letter. Modified
   * depending on the answer the player has picked to type, as well as difficulty chosen.
   */
  static int difficulty;
  /*
   * Returns the difficulty.
   * @return The difficulty.
   */
  public static int getDifficulty() {
    return difficulty;
  }
  /*
   * Sets the difficulty, depending on an input option.
   * @param difficulty the difficulty to set.
   */
  public static void setDifficulty(int gameDifficulty) {
    difficulty = gameDifficulty;
  }
}