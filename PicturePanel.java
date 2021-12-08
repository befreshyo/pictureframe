/**
 * You create PicturePanel, a descendant of JPanel that has a BufferedImage object called picture as a private data member 
 * as well as a setPicture function that takes in a BufferedImage object to set picture to. 
 * When setPicture changes the value of the picture private data member, it calls repaint, so that PicturePanel's paintComponent function renders the new image.
 */

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener{
    private ArrayList<PictureData> pd;
    private String message;
    private int msgX, msgY;
    private BufferedImage picture;
    public PicturePanel(){
        setPreferredSize(new Dimension(200,200));
        message = "(x=0, y=0)";
        addMouseListener(this);
        addMouseMotionListener(this);
        msgX = 10;
        msgY = 20;
        pd = new ArrayList<PictureData>();
    }

    public void setPicture(BufferedImage picture){
        this.picture = picture;
        repaint();
     }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(picture,0,0,null);
        g.drawString(message,msgX,msgY);
    }

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

    public ArrayList<PictureData> getPD() {
        return pd;
    }
    public void setDots(ArrayList<PictureData> pd) {
        this.pd = pd;
    }
    
}
