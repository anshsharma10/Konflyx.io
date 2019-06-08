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
 * The TextSelector class. Uses a KeyListener to allow the user to select the text they want to type.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.06.10
 */
public class TextSelector {
  /*
   * An array of all String responses.
   */
  String[] responses;
  /*
   * The list of all text objects in use.
   */
  ArrayList <Text> TextResponses = new ArrayList <Text> ();
  /*
   * The question to ask the user.
   */
  Text question;
  /*
   * The current location of the cursor. 0 is the top, and the number of possible responses - 1 is the bottom. (e.g 3 responses will have a max location of 2)
   */
  int location = 0;
  /*
   * The maximum possible location of the cursor. Equal to the number of possible responses - 1.
   */
  int maxLocation;
  /*
   * The current y position of the border on the screen.
   */
  int yPos = 150;
  /*
   * The border outside the currently selected text.
   */
  Border border = new Border (yPos);
  /*
   * The panel to work with.
   */
  JPanel panel;
  /*
   * The class constructor. Assigns all variables.
   * @param panel The panel to work with.
   * @param responses The list of possible responses to choose.
   * @param question The question to ask the user.
   */
  public TextSelector (JPanel panel, String[] responses, String question) {
    this.panel = panel;
    this.responses = responses;
    maxLocation = responses.length - 1;
    
    panel.add(border);
    this.question = new Text(null,  40, 80,  false,  false,  false,  Text.centerTextXPosition(40,question.length()),  45, question, panel);
    this.question.draw();
    for (int i = 0; i < responses.length; i++) {
      TextResponses.add(new Text(null,  33, 66,  false,  false,  false,  Text.centerTextXPosition(33, responses[i].length()),  167 + 120*i, responses[i], panel));
      TextResponses.get(i).draw();
    }
  }
  /*
   * Returns the panel.
   * @return the panel.
   */
  public JPanel getPanel() {
    return panel;
  }
  /*
   * Moves the border 120px down, to select the next text. This is only done if the location is not already at its maximum.
   * @return the panel after movement.
   */
  public void moveDown() {
    if (location < maxLocation) {
      border.setBounds(60,yPos + 120,952,101);;
      location++;
      yPos += 120;
    }
  }
  /*
   * Moves the border 120px up, to select the previous text. This is only done if the location is not already at its minimum.
   * @return the panel after movement.
   */
  public void moveUp() {
    if (location > 0) {
      border.setBounds(60,yPos - 120,952,101);
      location--;
      yPos -= 120;
    }
  }
  /*
   * Returns the users selection as a String.
   * @return The user's selection.
   */
  public String getSelection() {
    return responses[location];
  }
  /*
   * Cleans up all text selector files. Used when the driver class is done with the TextSelector class.
   * @return The working JPanel.
   */
  public JPanel cleanUp() {
    panel.remove(border);
    question.erase();
    for (Text text : TextResponses) {
      text.erase();
    }
    return getPanel();
  }
}