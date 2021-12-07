/**
 * You create PictureFrame, a JFrame descendant. 
 * It should be 290 pixels wide and 400 pixels tall. 
 * It should use a BorderLayout to arrange the controls as shown in the examples above. 
 * The north part should be occupied by a PicturePanel. 
 * The center of the PictureFrame should consist of a JPanel that likewise uses a BorderLayout, 
 * with its north section filled with a JTextField for holding the date, 
 * its center section filled with the description JTextArea, 
 * and its south section filled with a JPanel that holds the three buttons.
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;

import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PictureFrame extends JFrame{
    private PicturePanel panNorth;
    ArrayList <PictureData> pd = new ArrayList<PictureData>();
    ArrayList <BufferedImage> loadImagesFromPictureData = new ArrayList<BufferedImage>();

    public void setupMainMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        mnuFile.add(miSave);
        miSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //stuff here
            }
        });
        mnuFile.add(miExit);
        miExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Created by Paula Grata in December 2021");
            }
        });
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }

    public void setupGUI(){
        setTitle("Picture Frame");
        setBounds(100,100,290,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMainMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JButton btnPrev = new JButton("Prev");
        JButton btnSave = new JButton("Save");
        JButton btnNext = new JButton("Next");
        panSouth.add(btnPrev);
        btnPrev.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //stuff here
            }
        });
        panSouth.add(btnSave);
        btnSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //stuff here
            }
        });
        panSouth.add(btnNext);
        btnNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //stuff here
            }
        });
        c.add(panSouth,BorderLayout.SOUTH);
        panNorth = new PicturePanel();
        c.add(panNorth,BorderLayout.NORTH);
    }
    

    public PictureFrame(ArrayList<PictureData> pd, ArrayList<BufferedImage> loadImagesFromPictureData){
        this.pd = pd;
        this.loadImagesFromPictureData = loadImagesFromPictureData;
        setupGUI();
        panNorth.setPicture(loadImagesFromPictureData.get(0));
    }

}
