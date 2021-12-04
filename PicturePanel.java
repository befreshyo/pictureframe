/**
 * You create PicturePanel, a descendant of JPanel that has a BufferedImage object called picture as a private data member 
 * as well as a setPicture function that takes in a BufferedImage object to set picture to. 
 * When setPicture changes the value of the picture private data member, it calls repaint, so that PicturePanel's paintComponent function renders the new image.
 */

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener{
    private String message; //will show on the panel
    private int msgX, msgY;
    //private ArrayList<Dot> dots;
    public PicturePanel(){
        message = "(x=0, y=0)";
        addMouseListener(this);
        addMouseMotionListener(this);
        msgX = 10;
        msgY = 20;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message,msgX,msgY);
    }

    public void mouseClicked(MouseEvent e){
        message = String.format("(x=%d, y=%d)", e.getX(), e.getY());
        msgX = e.getX();
        msgY = e.getY();
        repaint();
    }
    
    public void mousePressed(MouseEvent e){
    }

    public void mouseReleased(MouseEvent e){
    }

    public void mouseEntered(MouseEvent e){
    }

    public void mouseExited(MouseEvent e){
    }

    public void mouseMoved(MouseEvent e){
    }

    public void mouseDragged(MouseEvent e){
    }
    
}
