import java.util.*;
import java.io.*;

public class PictureDataWriter {

    public static boolean writeToFile(ArrayList<PictureData> pd, String fname){
         if (fname.endsWith(".txt")){
             return writeToTextFile(pd,fname);
            } else {
                return false;
            }
        }

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
