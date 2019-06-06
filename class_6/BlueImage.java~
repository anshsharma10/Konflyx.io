import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
  
public class BlueImage 
{ 
    public static void main(String args[])throws IOException 
    { 
        BufferedImage img = null; 
        File f = null; 
  
        //read image 
        try
        { 
            f = new File("A.png"); 
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
  
                int a = (p>>24)&0xff; 
                int b = p&0xff; 
  
                // set new RGB 
                // keeping the b value same as in original 
                // image and setting r and g as 0. 
                p = (a<<24) | (0<<16) | (0<<8) | b; 
  
                img.setRGB(x, y, p); 
            } 
        } 
  
        // write image 
        try
        { 
            f = new File("A.png"); 
            ImageIO.write(img, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
    } 
} 