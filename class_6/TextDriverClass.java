    
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
   * The gameplay object to work with.
   */
  Gameplay game;
  /*
   * The tree the gameplay object will use.
   */
  int gameTree = 1;
  /*
   * The first String option for the game tree.
   */
  String gameTree1;
  /*
   * The main menu to work with.
   */
  MainMenu mainMenu;
  /*
   * The stage selection menu to work with.
   */
  StageSelect stageSelect;
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

    setSize(1080,720);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(1080,720));

    //Run nextStage() for ansh's changes
    //nextStage();

    JPanel panel = new JPanel();
    panel.setLayout(null);
    add(panel);

    /*
     Text t = new Text (new Color (25,25,25),  40,40,  false,  false,  true,  50,  20, "TEST", panel);
     Text t2 = new Text (null,  20,40,  true,  false,  false,  20,  540, "/TEST ONE/TEST TWO", panel);
     Text t2 = new Text (null,  20,40,  true,  false,  false,  20,  540, "/TEST ONE/TEST TWO", panel); */
    PracticeRoom pr = new PracticeRoom(panel);

    //Do all of this shit for Braulio's changes
    /*
     panel = new JPanel();
     panel.setLayout(null);
     panel.setPreferredSize(new Dimension(1080,720));
     panel.setSize(1080,720);
     pack();
     add(panel);
     PracticeRoom pr = new PracticeRoom(panel);
     panel.repaint();
     this.setVisible(true);
     this.pack();
     */

  }
  /*
   * Moves on to the next stage of the game. Each stage and what they do are as follows:
   * 0: The main menu of the game.
   * 1: The stage selection of the game. Creates a particular stage and maxstage depending on what the user wants.
   * 2: The instructions.
   * 3: The high scores.
   * 4: The tutorial.
   * 5: The practice room.
   * 6: The visual novel for level 1.
   * 7: The tree selection for level 1.
   * 8: The gameplay for level 1.
   * 9: The visual novel for level 2.
   * 10: The tree selection for level 2.
   * 11: The gameplay for level 2.
   * 12: The visual novel for level 3.
   * 13: The tree selection for level 3.
   * 14: The gameplay for level 3.
   * 15: The visual novel ending.
   */
  public void nextStage() {
    if (stage == 0) {
      mainMenu = new MainMenu();
      add(mainMenu);
      ts = new TextSelector(mainMenu, "", new String[]{"New Game", "Stage select", "Instructions", "High Scores", "Exit"});
      mainMenu.getPanel();
      mainMenu.repaint();
      this.addKeyListener(this);
      this.setFocusable(true);
      this.requestFocus();
    } else if (stage == 1) {
      stageSelect = new StageSelect();
      add(stageSelect);
      ts = new TextSelector(stageSelect, "", new String[]{"Tutorial", "Level 1", "Level 2", "Level 3"});
      stageSelect.getPanel();
      stageSelect.repaint();
      this.addKeyListener(this);
      this.setFocusable(true);
      this.requestFocus();
    } else if (stage == 6) {
      vn = new VisualNovel("level1");
      vn.setLayout(null);
      vn.setPreferredSize(new Dimension(1080,720));
      add(vn);
      vn.addText();
      timer.start();
    } else if (stage == 7) {
      panel = new JPanel();
      panel.setLayout(null);
      panel.setPreferredSize(new Dimension(1080,720));
      panel.setSize(1080,720);
      pack();
      add(panel);
      background = new Background(1);
      panel.add(background);
      ts = new TextSelector(panel, "A hot dog is...", new String[]{"A sandwich","Not a sandwich"});
      gameTree1 = "A sandwich";
      Component[] components = panel.getComponents();
      for (int i = 0; i < components.length; i++) {
        if (components[i] instanceof Letter)
          panel.setComponentZOrder(components[i],0);
        else if (components[i] instanceof Border)
          panel.setComponentZOrder(components[i],1);
        else if (components[i] instanceof Background)
          panel.setComponentZOrder(components[i],2);
      }
      panel.repaint();
      this.addKeyListener(this);
      this.requestFocus();
    } else if (stage == 8) {
      game = new Gameplay(1, gameTree);
      game.setLayout(null);
      game.setPreferredSize(new Dimension(1080,720));
      add(game);
      game.next();
      game.requestFocus();
      timer.start();
    }
    setVisible(true);
    this.pack();
    System.out.println(stage);
  }
  /*
   * Runs when the timer is activated. Checks if the visual novel or game is completed, then advances a stage.
   */
  public void actionPerformed(ActionEvent e) {
    if (vn != null && vn.isComplete() == true) {
      remove(vn);
      timer.stop();
      stage++;
      nextStage();
    } else if (game != null && game.isComplete() == true) {
      remove(game);
      timer.stop();
      stage++;
      nextStage();
    }
  }

  /*
   * Method that runs if a key is pressed. Changes text selector.
   */
  public void keyPressed(KeyEvent e) {
    int keyValue = e.getKeyCode();
    if (keyValue == 87 || keyValue == 38 && (stage == 0 || stage == 7)) {
      ts.moveUp();
    }
    else if (keyValue == 83 || keyValue == 40 && (stage == 0 || stage == 7)) {
      ts.moveDown();
    }
    else if (keyValue == 10 || keyValue == 32 && stage == 7) {
      ts.cleanUp();
      if (ts.getSelection().equals(gameTree1))
        gameTree = 1;
      else
        gameTree = 2;
      this.removeKeyListener(this);
      remove(panel);
      stage++;
      nextStage();
    } else if (keyValue == 10 || keyValue == 32 && stage == 0) {
      ts.cleanUp();
      if (ts.getSelection().equals("New Game"))
        stage = 4;
      else if (ts.getSelection().equals("Stage Select"))
        stage = 1;
      else if (ts.getSelection().equals("Instructions"))
        stage = 2;
      else if (ts.getSelection().equals("High Scores"))
        stage = 3;
      else if (ts.getSelection().equals("Exit"))
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
      this.removeKeyListener(this);
      remove(mainMenu);
      nextStage();
    } else if (keyValue == 10 || keyValue == 32 && stage == 1) {
      ts.cleanUp();
      if (ts.getSelection().equals("Tutorial")) {
        stage = 4;
      }
      else if (ts.getSelection().equals("Level 1")) {
        stage = 6;
      }
      else if (ts.getSelection().equals("Level 2")) {
        stage = 9;
      }
      else if (ts.getSelection().equals("Level 3")) {
        stage = 12;
      }
      this.removeKeyListener(this);
      remove(mainMenu);
      nextStage();
    }
  }
  /*
   * Method that runs if a key is released.
   */
  public void keyReleased(KeyEvent e) {
  }
  /*
   * Method that runs if a key is typed.
   */
  public void keyTyped(KeyEvent e) {
    //panel = t2.draw();
    //panel = t.draw();

    panel = pr.getPanel();
    setVisible(true);
    this.pack();

    /*try {
     Thread.sleep(3000);
     panel = t.erase();
     } catch (Exception e) {
     System.out.println(e);
     }
     }*/

  }

  public static void main (String[] args) {

    TextDriverClass driver = new TextDriverClass();

  }
}