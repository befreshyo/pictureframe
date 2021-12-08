/**
 * You create PictureFrame, a JFrame descendant. 
 * It should be 290 pixels wide and 400 pixels tall. 
 * It should use a BorderLayout to arrange the controls as shown in the examples above. 
 * The north part should be occupied by a PicturePanel. 
 * The center of the PictureFrame should consist of a JPanel that likewise uses a BorderLayout, 
 * with its north section filled with a JTextField for holding the date, 
 * its center section filled with the description JTextArea, 
 * and its south section filled with a JPanel that holds the three buttons.
 * 
 * 
 * north - picpanel
 * center - picframe
 *  - jpanel:
 *      borderlayout:
 *      north - JTextField
 *      center - JTextArea
 *      south - filled with a JPanel that holds the three buttons
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
import javax.swing.JTextArea;
import javax.swing.Action;
import javax.swing.ButtonGroup;

import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PictureFrame extends JFrame{
    int currentIndex = 0;
    private JTextField date;
    private JTextArea desc;
    private PicturePanel panNorth;
    ArrayList<PictureData> pd = PictureDataReader.readPictureDataFromFile("descriptions.txt");
    ArrayList<BufferedImage> loadImagesFromPictureData = PictureLoader.loadImagesFromPictureData(pd);
    PictureData pdDataLine = pd.get(currentIndex);

    public void setData(int currentIndex){
        PictureData pdDataLine = pd.get(currentIndex);
        date.setText(pdDataLine.getDate());
        desc.setText(pdDataLine.getDesc());

    }

    public void setPictureAndData(int currentIndex){
        panNorth.setPicture(loadImagesFromPictureData.get(currentIndex));
        setData(currentIndex);
    }

    public void saveData(String date, String desc){
        pd.get(currentIndex).setDate(date);
        pd.get(currentIndex).setDesc(desc);
        PictureDataWriter.writeToFile(pd,"descriptions.txt");
    }

    public void setupMainMenu(){
        System.out.println(pdDataLine.getDate());
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
                saveData(date.getText(), desc.getText());
            }
        }
        );
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
        JPanel panCenter = new JPanel();
        panCenter.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JButton btnPrev = new JButton("Prev");
        JButton btnSave = new JButton("Save");
        JButton btnNext = new JButton("Next");
        panSouth.add(btnPrev);
        btnPrev.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (currentIndex <= 0){
                    currentIndex = 3;
                    setPictureAndData(currentIndex);
                } else {
                    currentIndex = currentIndex - 1;
                    setPictureAndData(currentIndex);
                }
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
                if (currentIndex >= 3){
                    currentIndex = 0;
                    setPictureAndData(currentIndex);
                } else {
                    currentIndex = currentIndex + 1;
                    setPictureAndData(currentIndex);
                }
            }
        });
        panNorth = new PicturePanel();
        c.add(panNorth,BorderLayout.NORTH);
        c.add(panCenter,BorderLayout.CENTER);
        date = new JTextField(20);
        desc = new JTextArea(1,1);
        desc.setLineWrap(true);
        panCenter.add(date,BorderLayout.NORTH);
        panCenter.add(desc,BorderLayout.CENTER);
        panCenter.add(panSouth,BorderLayout.SOUTH);

    }
    
    public PictureFrame(){
        setupGUI();
        setPictureAndData(currentIndex);
    }

}
