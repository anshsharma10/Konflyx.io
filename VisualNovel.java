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
 * The VisualNovel class. Creates a simple visual novel system for the driver and level classes to use.
 * used for the visual novel.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.30
 */
public class VisualNovel extends JPanel implements KeyListener{
  /**
   * The TextBox to work with.
   */
  TextBox textbox = new TextBox();;
  /**
   * The background to work with.
   */
  Background background = new Background(1);;
  /**
   * The ArrayList of Text objects. Each object will be shown once in the process of the visual novel screen.
   */
  ArrayList <ArrayList <Text>> textList;
  /**
   * The ArrayList of Person objects. Each object is shown along with its associated textList object.
   */
  ArrayList <Person> personList;
  /**
   * The current index in the visual novel. Each line has its own index to manage storytelling.
   */
  int index = 0;
  /**
   * The total number of lines in the current script.
   */
  int lines = 0;
  /**
   * Whether or not this visual novel portion is fully completed.
   */
  boolean completed = false;
  /**
   * The class constructor. Creates the visual novel.
   */
  public VisualNovel(String script) {
    textList = new ArrayList <ArrayList <Text>>();
    personList = new ArrayList<Person>();
    generateScript(script);
    completed = false;
    index = 0;
    this.setSize(1080,720);
    this.setPreferredSize(new Dimension(1080,720));
    this.addKeyListener(this);
    this.setFocusable(true);
    this.requestFocus();
  }
  /**
   * Searches through the list of scripts for a script with this particular VisualNovel object's name, then loads
   * the text from that script into a Text object, placing it in the textList ArrayList.
   * @param script The particular script to search for.
   */
  public void generateScript (String script) {
    File scriptList = new File("scripts/" + script + ".txt");
    try {
      Scanner scan = new Scanner(scriptList); 
      background = new Background(Integer.parseInt((scan.nextLine().substring(11))));
      scan.nextLine();
      scan.nextLine();
      scan.nextLine();
      while (scan.hasNextLine()) {
        String line = scan.nextLine(); 
        if (!(line.substring(0,1).equals(" ") && line.substring(2,3).equals(" ")))
          personList.add(new Person(Integer.parseInt(line.substring(0,1)),Integer.parseInt(line.substring(2,3))));
        else
          personList.add(null);
        textList.add(new ArrayList<Text>());
        textList.get(lines).add(new Text (null,  13, 26,  false,  false,  false,  38,  539, line.substring(4,line.indexOf("%")), this));
        textList.get(lines).add(new Text (null,  18, 36,  false,  false,  false,  20,  545, line.substring(line.indexOf("%")), this));
        lines++;
      }
    }
    catch (Exception e) {
      System.out.println(lines +""+ e);
    }
  }
  /**
   * Removes the background from the JPanel, then adds it again to manage layers.
   * @param The background int to add.
   */
  public void addBg () {
    this.remove(background);
    this.add(background);
  }
  /**
   * Removes the textbox from the JPanel, then adds it again to manage layers.
   */
  public void addTextBox () {
    this.remove(textbox);
    this.add(textbox);
  }
  /**
   * Adds text to the screen using the Text and Letter classes, with a character and their respective emotion displayed.
   * @return The JPanel after text is added.
   */
  public void addText () {
    addBg();
    if (index == 0) {
      if (personList.get(index) != null)
        this.add(personList.get(index));
      addTextBox();
      textList.get(index).get(0).draw();
      textList.get(index).get(1).draw();
    }
    else {
      if (personList.get(index - 1) != null)
        this.remove(personList.get(index - 1));
      if (personList.get(index) != null)
        this.add(personList.get(index));
      addTextBox();
      textList.get(index - 1).get(0).erase();
      textList.get(index - 1).get(1).erase();
      textList.get(index).get(0).draw();
      textList.get(index).get(1).draw();
    }
    index++;
    if (index == lines)
      completed = true;
    getPanel();
  }
  /**
   * Reorders the current JPanel to account for layers.
   */
  public void getPanel() {
    Component[] components = this.getComponents();
    for (int i = 0; i < components.length; i++) {
      if (components[i] instanceof Letter)
        this.setComponentZOrder(components[i],0);
      else if (components[i] instanceof TextBox)
        this.setComponentZOrder(textbox,1);
      else if (components[i] instanceof Person)
        this.setComponentZOrder(components[i],2);
      else if (components[i] instanceof Background)
        this.setComponentZOrder(components[i],3);
    }
  }
  /**
   * Returns the current line in the script.
   */
  public int getIndex () {
    return index;
  }
  /**
   * Returns the total number of lines in the script.
   */
  public int getLines () {
    return lines;
  }
  /**
   * Returns the completion of the section.
   */
  public boolean isComplete() {
    return completed;
  }
  /**
   * Method that runs if a key is pressed. Advances text.
   */
  public void keyPressed(KeyEvent e) {
    if (isComplete() == true)
      this.removeKeyListener(this);
    else {
      int keyValue = e.getKeyCode();
      if (keyValue == 10 || keyValue == 32) {
        addText();
      }
    }
  }
  /**
   * Method that runs if a key is released.
   */
  public void keyReleased(KeyEvent e) {
  }
  /**
   * Method that runs if a key is typed.
   */
  public void keyTyped(KeyEvent e) {
  }
}