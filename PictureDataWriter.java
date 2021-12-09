import java.util.*;
import java.io.*;

public class PictureDataWriter {

    /**
     * checks if file is a .txt document
     * pd is the array of data
     * string fname is the file name (I tried using File fname, but wasn't working)
     * returns the next function, writeToTextFile else returns false
     */

    public static boolean writeToFile(ArrayList<PictureData> pd, String fname){
         if (fname.endsWith(".txt")){
             return writeToTextFile(pd, fname);
            } else {
                return false;
            }
        }

    /**
     *  writes data to text file
     * pd is the array of data
     * string fname is the file name
     * returns true if it was was able to write data else returns false
     */

    public static boolean writeToTextFile (ArrayList<PictureData> pd, String fname){
    try {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
        for (PictureData p: pd) {
            pw.printf("%s\t%s\t%s\n",p.getFile(), p.getDate(), p.getDesc());
        }
        pw.close();
        return true;
    } catch(Exception ex){
        return false;
        }
    }
}
