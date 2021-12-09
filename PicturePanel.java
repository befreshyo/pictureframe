import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * uses the arraylist pd of data and bufferedimage data 
 * creates a string that is a message that will be displayed in the gui
 * msgX, msgY wil be used in creating the message indicating the X and Y coordinates of mousemovent
 */


public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener{
    private ArrayList<PictureData> pd;
    private BufferedImage picture;
    private String message;
    private int msgX, msgY;

    /**
     * setPreferredSize sets size of the panel 
     * message sets original message displayed when app is opened
     * addMouseListener and addMouseMotionListener calling import events
     * msgX, msgY are set to 10 and 20 initially 
     * pd creates a new arraylist
     */
    
    public PicturePanel(){
        setPreferredSize(new Dimension(200,200));
        message = "(x=0, y=0)";
        addMouseListener(this);
        addMouseMotionListener(this);
        msgX = 10;
        msgY = 20;
        pd = new ArrayList<PictureData>();
    }

    /**
     * buffered image picture is set to the picture data and repaints based upon results 
     */

    public void setPicture(BufferedImage picture){
        this.picture = picture;
        repaint();
     }

     /**
      * paintComponent will use drawImage to diplay the picture
      * drawString will use the message, msgX, msgY to display the mouse movement results 
      */

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(picture,0,0,null);
        g.drawString(message,msgX,msgY);
    }

    /**
     * displays mouse movement if mouse is clicked 
     */

    public void mouseClicked(MouseEvent e){
        message = String.format("(x=%d, y=%d)", e.getX(), e.getY());
        msgX = e.getX();
        msgY = e.getY();
        repaint();
    }
    
    public void mousePressed(MouseEvent e){
        //do nothing
    }

    public void mouseReleased(MouseEvent e){
        //do nothing
    }

    public void mouseEntered(MouseEvent e){
        //do nothing
    }

    public void mouseExited(MouseEvent e){
        //do nothing
    }

    public void mouseMoved(MouseEvent e){
        //do nothing
    }

    public void mouseDragged(MouseEvent e){
        //do nothing
    }
    
}
