import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * pictureloader - loadImagesFromPictureData calls the arraylist pd containing the data of the file
 * it will try to (else return null) create an arraylist bufferedimage to contain buffered image data of the picture file name
 * for each line in the array list pd,
 * ImageIO.read will read each filename of that line
 * and add to the BufferedImage arraylist
 */

public class PictureLoader {

    public static ArrayList<BufferedImage> loadImagesFromPictureData(ArrayList<PictureData> pd){
        try {
            ArrayList<BufferedImage> picture = new ArrayList<BufferedImage>();
            for (PictureData p: pd) {
                BufferedImage img = ImageIO.read(new File(p.getFile()));
                picture.add(img);     
            }
            return picture;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
