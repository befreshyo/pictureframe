import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
public class App {
    public static void main(String[] args) {
        ArrayList<PictureData> pd = PictureDataReader.readPictureDataFromFile();
        ArrayList<BufferedImage> bImage = PictureLoader.loadImagesFromPictureData(pd);
        PictureFrame tf = new PictureFrame(pd,bImage);
        tf.setVisible(true);
    }
    
}