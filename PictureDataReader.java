/**
 * reads data from the file provided
 * opens up file
 * per each line of the file
 * seperates line of file into parts by tab
 * sets file,date,desc to each part of the line
 * creates a new picture data containing the file,date,desc
 * adds data 
 * returns array of data
 */

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class PictureDataReader {
    public static ArrayList<PictureData> readPictureDataFromFile(String fname){
        try {
            ArrayList<PictureData> pd = new ArrayList<PictureData>();
            Scanner fsc = new Scanner(new File(fname));
            String file,date,desc;
            String line;
            String[] parts;
            PictureData picData;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                if (line.length()>0) {
                    parts = line.split("\t");
                    file = parts[0];
                    date = parts[1];
                    desc = parts[2];
                    picData = new PictureData(file,date,desc);
                    pd.add(picData);
                }
            } return pd;
        } catch (Exception ex) {
            return null;
        }
    }
}
