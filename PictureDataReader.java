/**
 * You create PictureDataReader with a readPictureDataFromFile function that returns an ArrayList<PictureData>. 
 * You call it near the beginning of your program to create the PictureDataReader objects that will serve as the model for your application.
 */

import java.util.ArrayList;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class PictureDataReader {

    public static ArrayList<PictureData> readPictureDataFromFile(){
        try {
            ArrayList<PictureData> pd = new ArrayList<PictureData>();
            Scanner fsc = new Scanner(new File("descriptions.txt"));
            String pic,num,desc;
            String line;
            String[] parts;
            PictureData picData;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                if (line.length()>0) {
                    parts = line.split("\t");
                    pic = parts[0];
                    num = parts[1];
                    desc = parts[2];
                    picData = new PictureData(pic,num,desc);
                    pd.add(picData);
                }
            } return pd;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
