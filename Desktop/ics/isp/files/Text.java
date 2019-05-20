/*
 * The Letter class. Creates a letter using JFrame to easily create sentences.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.20
 */
public class Letter {
  /*
   * The colour of the text.
   */
  Color text_colour;
  /*
   * The size of the text.
   */
  int text_size;
  /*
   * Whether or not the text will animate when on screen.
   */
  boolean idleAnimation;
  /*
   * Whether or not the text will animate into the scene.
   */
  boolean animateIn;
  /*
   * Whether or not the text will animate out of the scene.
   */
  boolean animateOut;
  /*
   * The horizontal position of the bottom-leftmost part of the text on the screen, in pixels.
   */
  boolean posX;
  /*
   * The vertical position of the bottom-leftmost part of the text text on the screen, in pixels.
   */
  boolean posY;
  /*
   * An ArrayList containing each letter in the text.
   */
  ArrayList <Letter> textList;
  /*
   * The class constructor. Creates a Text object with all variables set. Additionally, creates an ArrayList of Letters, one Letter for each letter in the contents String.
   * @param colour The text's colour.
   * @param size The text's size.
   * @param idleAnim Whether or not the text animates on screen.
   * @param inAnim Whether or not the text animates into the screen.
   * @param outAnim Whether or not the text animates out of the screen.
   * @param x The horizontal position of the text.
   * @param y The vertical position of the text.
   * @param contents The contents of the text.
   */
  public Text (Color colour, int size, boolean idleAnim, boolean inAnim, boolean outAnim, int x, int y, String contents) {
    text_colour = colour;
    text_size = size;
    idleAnimation = idleAnim;
    animateIn = inAnim;
    animateOut = outAnim;
    posX = x;
    posY = y;
    textList = new ArrayList <Letter> ();
    for (int i = 0; i < contents.length; i++) {
      textList.add(new Letter(text_colour, text_size, idleAnimation, animateIn, animateOut, posX, posY, contents.substring(i, i + 1)));
    }
  }
  /*
   * Draws the text with respective colour and size by calling draw() on each letter within the letters ArrayList.
   * Will animate while drawing if animateIn is on. Also calls animateIdle() if animateIdle is on.
   */
  public void draw () {
    //To be implemented
  }
  /* 
   * Erases the text by calling erase() on each letter within the letters ArrayList.
   * Will animate out if animateOut is on.
   */
  public void erase() {
    //to be implemented
  }
}