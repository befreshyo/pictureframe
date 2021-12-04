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

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PictureFrame extends JFrame{
    public void setupMainMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        mnuFile.add(miSave);
        mnuFile.add(miExit);
        miExit.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            }
        );
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,"created by lala");
                }
            }
        );
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }

    public void setupGUI(){
        setTitle("menu and mouse app");     //always assumes this.setTitle if it does not have an object followed by a dot
        setBounds(100,100,290,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMainMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JButton btnChange = new JButton("Change");
    }

    public PictureFrame(){
        setupGUI();
    }
}
