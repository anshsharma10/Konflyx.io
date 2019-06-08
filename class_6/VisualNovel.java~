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
 * The VisualNovel class. Creates a simple visual novel system for the driver and level classes to use. Contains methods
 * used for the visual novel.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.30
 */
public class VisualNovel {
  /*
   * The JPanel to work with.
   */
  JPanel panel;
  /*
   * The TextBox to work with.
   */
  TextBox textbox = new TextBox();;
  /*
   * The background to work with.
   */
  Background background = new Background(1);;
  /*
   * The ArrayList of Text objects. Each object will be shown once in the process of the visual novel screen.
   */
  ArrayList <ArrayList <Text>> textList;
  /*
   * The ArrayList of Person objects. Each object is shown along with its associated textList object.
   */
  ArrayList <Person> personList;
  /*
   * The text currently shown on the screen.
   */
  Text currentText;
  /*
   * The person currently shown on the screen.
   */
  Person currentPerson;
  /*
   * The current index in the visual novel. Each line has its own index to manage storytelling.
   */
  int index = 0;
  /*
   * The total number of lines in the current script.
   */
  int lines = 0;
  /*
   * The class constructor. Creates the visual novel.
   */
  public VisualNovel(JPanel panel, String script) {
    this.panel = panel;
    textList = new ArrayList <ArrayList <Text>>();
    personList = new ArrayList<Person>();
    generateScript(script);
    index = 0;
  }
  /*
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
        personList.add(new Person(Integer.parseInt(line.substring(0,1)),Integer.parseInt(line.substring(2,3))));
        textList.add(new ArrayList<Text>());
        textList.get(lines).add(new Text (null,  13, 26,  false,  false,  false,  38,  539, line.substring(4,line.indexOf("%")), panel));
        textList.get(lines).add(new Text (null,  18, 36,  false,  false,  false,  20,  540, line.substring(line.indexOf("%")), panel));
        lines++;
      }
    }
    catch (Exception e) {
    }
  }
  /*
   * Removes the background from the JPanel, then adds it again to manage layers.
   * @param The background int to add.
   */
  public void addBg () {
    panel.remove(background);
    panel.add(background);
  }
  /*
   * Removes the textbox from the JPanel, then adds it again to manage layers.
   */
  public void addTextBox () {
    panel.remove(textbox);
    panel.add(textbox);
  }
  /*
   * Adds text to the screen using the Text and Letter classes, with a character and their respective emotion displayed.
   * @return The JPanel after text is added.
   */
  public JPanel addText () {
    addBg();
    if (index == 0) {
      panel.add(personList.get(index));
      addTextBox();
      textList.get(index).get(0).draw();
      textList.get(index).get(1).draw();
    }
    else {
      panel.remove(personList.get(index - 1));
      panel.add(personList.get(index));
      addTextBox();
      textList.get(index - 1).get(0).erase();
      textList.get(index - 1).get(1).erase();
      textList.get(index).get(0).draw();
      textList.get(index).get(1).draw();
    }
    index++;
    return getPanel();
  }
  /*
   * Returns the current JPanel.
   * @return the JPanel.
   */
  public JPanel getPanel() {
    Component[] components = panel.getComponents();
    for (int i = 0; i < components.length; i++) {
      if (components[i] instanceof Letter)
        panel.setComponentZOrder(components[i],0);
      else if (components[i] instanceof TextBox)
        panel.setComponentZOrder(textbox,1);
      else if (components[i] instanceof Person)
        panel.setComponentZOrder(components[i],2);
      else if (components[i] instanceof Background)
        panel.setComponentZOrder(components[i],3);
    }
    return panel;
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
}