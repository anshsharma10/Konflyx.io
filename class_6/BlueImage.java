import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
import java.awt.Color;

public class BlueImage 
{ 
  public static void main (String args[]) throws IOException 
  { 
    BufferedImage img = null; 
    File f = null; 
    
    //read image 
    try
    { 
      f = new File("textfiles\\A.png"); 
      img = ImageIO.read(f); 
    } 
    catch(IOException e) 
    { 
      System.out.println(e); 
    } 
    
    // get width and height 
    int width = img.getWidth(); 
    int height = img.getHeight(); 
    
    // convert to blue image 
    for (int y = 0; y < height; y++) 
    { 
      for (int x = 0; x < width; x++) 
      { 
        int p = img.getRGB(x,y); 
        // System.out.print(p);
        
        // int a = (p>>24)&0xff; 
        // int b = p&0xff; 
        
        // set new RGB 
        // keeping the b value same as in original 
        // image and setting r and g as 0. 
        // p = (a<<24) | (0<<16) | (0<<8) | b; 
        if (p < 0)
          img.setRGB(x, y,  new Color(255, 0, 0, 200).getRGB()); 
      } 
    } 
    
    // write image 
    try
    { 
      f = new File("Aa.png"); 
      ImageIO.write(img, "png", f); 
    } 
    catch(IOException e) 
    { 
      System.out.println(e); 
    } 
  } 
} 