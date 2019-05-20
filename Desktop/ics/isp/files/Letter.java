/*
 * The Letter class. Creates a letter using JFrame to easily create sentences.
 * @authors Ansh Sharma, Braulio Carrion
 * @date 2019.05.20
 */
public class Letter {
  /*
   * The colour of the letter.
   */
  Color letter_colour;
  /*
   * The size of the letter.
   */
  int letter_size;
  /*
   * Whether or not the letter will animate when on screen.
   */
  boolean idleAnimation;
  /*
   * Whether or not the letter will animate into the scene.
   */
  boolean animateIn;
  /*
   * Whether or not the letter will animate out of the scene.
   */
  boolean animateOut;
  /*
   * The horizontal position of the bottom-leftmost part of the letter on the screen, in pixels.
   */
  boolean posX;
  /*
   * The vertical position of the bottom-leftmost part of the letter on the screen, in pixels.
   */
  boolean posY;
  /*
   * The String value of the letter to represent.
   */
  boolean letter;
  /*
   * The class constructor. Creates a Letter object with all variables set.
   * @param colour The letter's colour.
   * @param size The letter's size.
   * @param idleAnim Whether or not the letter animates on screen.
   * @param inAnim Whether or not the letter animates into the screen.
   * @param outAnim Whether or not the letter animates out of the screen.
   * @param x The horizontal position of the letter.
   * @param y The vertical position of the letter.
   * @param let The letter to represent.
   */
  public Letter (Color colour, int size, boolean idleAnim, boolean inAnim, boolean outAnim, int x, int y, String let) {
    letter_colour = colour;
    letter_size = size;
    idleAnimation = idleAnim;
    animateIn = inAnim;
    animateOut = outAnim;
    posX = x;
    posY = y;
    letter = let;
  }
  /*
   * Draws the letter with respective colour and size. Will animate while drawing if animateIn is on. Also calls animateIdle() if animateIdle is on.
   */
  public void draw () {
    //To be implemented
  }
  /* 
   * Erases the letter. Will animate out if animateOut is on.
   */
  public void erase() {
    //to be implemented
  }
}