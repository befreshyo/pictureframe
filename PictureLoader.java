import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.ObjectInputStream.GetField;

/**
 * You create PictureLoader with a loadImagesFromPictureData function that returns an ArrayList<BufferedImage>. 
 * This function loads the images identified by the filename of each PictureData object into memory so that you can display them.
 */

public class PictureLoader {

    public static ArrayList<BufferedImage> loadImagesFromPictureData(ArrayList<PictureData> pd){
        try {
            ArrayList<BufferedImage> picture = new ArrayList<BufferedImage>();
            for (PictureData p: pd) {
                BufferedImage img = ImageIO.read(new File(p.getPic()));
                picture.add(img);     
            }
            return picture;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
