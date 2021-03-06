/**
 * sets picturedata with the data attributes, getters, setters, constructors, and toString function.
 * file,date,desc are set in order to be used in other parts of program
 * the set functions allow the save to override the information in the text file
 */

public class PictureData {
    private String file;
    private String date;
    private String desc;
    
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PictureData(String file, String date, String desc) {
        this.file = file;
        this.date = date;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", file, date, desc);
    }
}
