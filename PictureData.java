import java.util.ArrayList;

/**
 * You define PictureData with the necessary data attributes, getters, setters, constructors, and toString function.
 */

public class PictureData {
    private String pic;
    private String num;
    private String desc;
    
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PictureData(String pic, String num, String desc) {
        this.pic = pic;
        this.num = num;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", pic, num, desc);
    }
    
}