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
 * The Gameplay class. Manages the game, switching between typing, display of text to type, and letting the user choose what they want to type.
 * used for the visual novel.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class Gameplay extends JPanel implements ActionListener, KeyListener {
  /*
   * The TextBox to work with.
   */
  TextBox textbox = new TextBox();
  /*
   * The background to work with.
   */
  Background background = new Background(1);
  /*
   * The person to work with.
   */
  Person person = new Person(1,1);
  /*
   * The healthBar to work with.
   */
  HealthBar healthBar = new HealthBar(100);
  /*
   * The name of the person speaking. For use in visual novel text.
   */
  Text visualNovelSpeaker;
  /*
   * The text spoken to be displayed. For use in visual novel text.
   */
  Text visualNovelText;
  /*
   * The ArrayList of instructions to be carried out by the Gameplay class.
   */
  ArrayList <String> instructions = new ArrayList<String>();;
  /*
   * The current index in the game. Each portion of the game has its own line.
   */
  int index = 0;
  /*
   * The total number of lines in the current game script.
   */
  int lines = 0;
  /*
   * What the Gameplay class is currently handling. 0 is visualnovel-style text which the user advances through,
   * 1 is prompting the user to select text, and 2 is prompting the user to type text.
   */
  int mode = 0;
  /*
   * Whether or not this part of the game is fully completed.
   */
  boolean completed = false;
  /*
   * The text the enemy will type.
   */
  String enemyText;
  /*
   * The text the player will type.
   */
  String playerText;
  /*
   * The question to ask the user.
   */
  String question;
  /*
   * The list of possible Strings the user will type.
   */
  ArrayList <String> responses = new ArrayList <String>();
  /*
   * The correct response to type, as an index in the responses variable. All incorrect responses typed will make the enemy type faster.
   */
  int correctResponse;
  /*
   * The TextSelector for use when the player chooses what text they want to type.
   */
  TextSelector ts;
  /*
   * The Text objects the enemy and player will type respectively.
   */
  Text enemyTextObj, playerTextObj;
  /*
   * The timer used to track typing.
   */
  javax.swing.Timer typeTimer = new javax.swing.Timer(150, this);
  /*
   * Whether the last line is in visual novel or typing mode.
   */
  int lastLine;
  /*
   * The location of the second argument tree.
   */
  int treeLoc = 0;
  /*
   * The class constructor. Creates the visual novel.
   */
  public Gameplay(int script, int tree) {
    generateScript(script, tree);
    index = 0;
    completed = false;
    this.addKeyListener(this);
    this.setFocusable(true);
    this.add(healthBar);
  }
  /*
   * Searches through the list of scripts for a script with this particular gameplay, then loads each line from this script into the instructions.
   * The formatting for scripts can be found inside any gameplay script file located in /scripts.
   * @param script The particular script to search for.
   */
  public void generateScript (int script, int tree) {
    File scriptList = new File("scripts/gameplay" + script + "tree" + tree + ".txt");
    try {
      Scanner scan = new Scanner(scriptList); 
      background = new Background(Integer.parseInt((scan.nextLine().substring(11))));
      person = new Person(Integer.parseInt((scan.nextLine().substring(7))),1);
      for (int i = 0; i < 10; i++)
      {
        scan.nextLine(); 
      }
      String line = "";
      while (scan.hasNextLine()) {
        line = scan.nextLine(); 
        if (line.charAt(1) == '%') {
          instructions.add(line);
          lines++;
        }
      }
      if (line.substring(0,1) == "0")
        lastLine = 0;
      else
        lastLine = 1;
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
  /*
   * Removes the background from the JPanel, then adds it again to manage layers.
   * @param The background int to add.
   */
  public void addBg () {
    this.remove(background);
    this.add(background);
  }
  /*
   * Removes the textbox from the JPanel, then adds it again to manage layers.
   */
  public void addTextBox () {
    this.remove(textbox);
    this.add(textbox);
  }
  /*
   * Removes the health bar from the JPanel, then adds it again to manage layers.
   */
  public void addHealthBar () {
    this.remove(healthBar);
    this.add(healthBar);
  }
  /*
   * Follows the next instruction. If the instruction is a visual novel instruction (starts with 0) then sets the mode to 0 and displays text, waiting for the
   * space or enter key to be pressed. If the instruction is a selector (starts with 1), then it will set the mode to 1, take the enemy's text to type,
   * possible responses, question, and best possible response, and create a text selector, waiting for the user to make a selection. If the user selects 
   * the wrong answer, then the enemy's speed will be increased. Whether or not the right answer is selected, the user will have to type out the sentence.
   * The game will create the sentence to type.
   * @return The JPanel after text is added.
   */
  public void next () {
    if (completed == false) {
      String line = instructions.get(index);
      if (line.charAt(0) == '0') {
        mode = 0;
        if (!(line.substring(2,3).equals(" ") && line.substring(4,5).equals(" ")))
          person = new Person(Integer.parseInt(line.substring(2,3)),Integer.parseInt(line.substring(4,5)));
        else
          person = null;
        visualNovelSpeaker = new Text (null,  13, 26,  false,  false,  false,  38,  539, line.substring(6,6 + line.substring(6).indexOf("%")), this);
        visualNovelText = new Text (null,  18, 36,  false,  false,  false,  20,  575, line.substring(6 + line.substring(6).indexOf("%")), this);
        addBg();
        if (person != null)
          this.add(person);
        addTextBox();
        addHealthBar();
        visualNovelSpeaker.draw();
        visualNovelText.draw();
        getPanel();
        index++;
      }
      else if (line.charAt(0) == '1') {
        mode = 1;
        enemyText = line.substring(2,2 + line.substring(2).indexOf("%"));
        line = line.substring(2 + line.substring(2).indexOf("%"));
        correctResponse = Integer.parseInt(line.substring(1,2));
        line = line.substring(3);
        question = line.substring(0,line.indexOf("%"));
        line = line.substring(line.indexOf("%"));
        while (!(line.substring(1,2).equals("^"))) {
          responses.add(line.substring(1,1 + line.substring(1).indexOf("%")));
          line = line.substring(1 + line.substring(1).indexOf("%"));
        }
        addBg();
        addHealthBar();
        ts = new TextSelector(this, question, responses.toArray(new String[responses.size()]));
        getPanel();
        index++;
      }
      if (index == lines && lastLine == 0) {
        completed = true;
      }
    }
  }
  
  /*
   * Creates the sentence to type. Called after the user selects something using TextSelector.
   */
  public void typeText() {
    addBg();
    this.add(person);
    addHealthBar();
    enemyTextObj = new Text(null,  35, 70,  false,  true,  false,  55,  15, enemyText, this);
    enemyTextObj.draw();
    int xPos;
    if ((int)(Math.random()*2) == 1) {
      person.move("left");
      xPos = 20;
    }
    else {
      person.move("right");
      xPos = 75;
    }
    person.changeEmote((int)(3*Math.random()));
    playerTextObj = new Text(null, 35, 70, true, false, false, xPos, 188, playerText, this);
    playerTextObj.draw();
    playerTextObj.focusLetter();
    setVisible(true);
    getPanel();
    typeTimer.start();
    
  }
  /*
   * Reorders the current JPanel to account for layers.
   */
  public void getPanel() {
    Component[] components = this.getComponents();
    for (int i = 0; i < components.length; i++) {
      if (components[i] instanceof Letter)
        this.setComponentZOrder(components[i],0);
      else if (components[i] instanceof HealthBar)
        this.setComponentZOrder(healthBar, 1);
      else if (components[i] instanceof TextBox)
        this.setComponentZOrder(textbox,2);
      else if (components[i] instanceof Border)
        this.setComponentZOrder(components[i],2);
      else if (components[i] instanceof Person)
        this.setComponentZOrder(components[i],3);
      else if (components[i] instanceof Background)
        this.setComponentZOrder(components[i],4);
    }
  }
  /*
   * Returns the current line in the script.
   */
  public int getIndex () {
    return index;
  }
  /*
   * Returns the total number of lines in the script.
   */
  public int getLines () {
    return lines;
  }
  /*
   * Returns the completion of the section.
   */
  public boolean isComplete() {
    return completed;
  }
  /*
   * The method that activates every time the timer creates an ActionEvent.
   */
  public void actionPerformed(ActionEvent e) {
    if (playerTextObj.finishedLine()) {
      playerTextObj.erase();
      enemyTextObj.erase();
      remove(background);
      remove(person);
      remove(healthBar);
      responses = new ArrayList <String>();
      this.addKeyListener(this);
      typeTimer.stop();
      if (index == lines && lastLine == 1) {
        completed = true;
      }
      else {
        next();
      }
    } else if (enemyTextObj.finishedLine()){
      healthBar.incrementHealth(-1); 
    }
  }
  /*
   * Method that runs if a key is pressed. Advances text.
   */
  public void keyPressed(KeyEvent e) {
    if (isComplete() == true)
      this.removeKeyListener(this);
    else if (mode == 0) {
      int keyValue = e.getKeyCode();
      if (keyValue == 10 || keyValue == 32) {
        remove(background);
        remove(textbox);
        if (person != null)
          remove(person);
        remove(healthBar);
        visualNovelSpeaker.erase();
        visualNovelText.erase();
        next();
      }
    } else if (mode == 1) {
      int keyValue = e.getKeyCode();
      if (keyValue == 87 || keyValue == 38) {
        ts.moveUp();
      }
      else if (keyValue == 83 || keyValue == 40) {
        ts.moveDown();
      }
      else if (keyValue == 10 || keyValue == 32) {
        ts.cleanUp();
        remove(healthBar);
        playerText = ts.getSelection();
        this.removeKeyListener(this);
        typeText();
      }
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
  }
}