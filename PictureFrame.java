import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * pictureframe does all the important stuff -
 * pictureframe extends jframe to create the app
 * currentIndex is set to 0, this will be used to determine which picture/data to get
 * string fname is the filename used 
 * arraylist picturedata pd is set to PictureDataReader.readPictureDataFromFile that will read that file in get the data
 * arraylist bufferedimage loadImagesFromPictureData is set to PictureLoader.loadImagesFromPictureData that will load buffered images based on that data
 * picturedata pddataline (couldnt come up with a better name) - will be the a line of data from pd at that currentindex
 * picturepanel pannorth is set to indicate the north menu
 * date,desc are JTextArea created that will displayed on main app
 * */ 

public class PictureFrame extends JFrame{
    int currentIndex = 0;
    String fname = "descriptions.txt";
    ArrayList<PictureData> pd = PictureDataReader.readPictureDataFromFile(fname);
    ArrayList<BufferedImage> loadImagesFromPictureData = PictureLoader.loadImagesFromPictureData(pd);
    PictureData pdDataLine = pd.get(currentIndex);
    private PicturePanel panNorth;
    private JTextField date;
    private JTextArea desc;

    /**
     * sets the date and desc at the current index
     * and is passed through to setpictureanddata
     */

    public void setData(int currentIndex){
        PictureData pdDataLine = pd.get(currentIndex);
        date.setText(pdDataLine.getDate());
        desc.setText(pdDataLine.getDesc());

    }

    /**
     * sets the picture and data at the current index
     */

    public void setPictureAndData(int currentIndex){
        panNorth.setPicture(loadImagesFromPictureData.get(currentIndex));
        setData(currentIndex);
    }

    /**
     * saves data to the filename by using setdate and set desc functions
     * then PictureDataWriter.writeToFile uses data to write file
     */

    public void saveData(String date, String desc){
        pd.get(currentIndex).setDate(date);
        pd.get(currentIndex).setDesc(desc);
        PictureDataWriter.writeToFile(pd,fname);
    }

     /**
     * creates the top menu for the app
     * mbar is created a new jmenubar
     * mnuFile, mnuHelp are new JMenu items that will be displayed at the top, mbar adds these items 
     * miSave,miExit are new JMenuItem that will be contained under the file tab, mnuFile adds these items 
     * miAbout is a new JMenuItem that is added under help to show message pop up 
     * jmenubar is then set to mbar
     */
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
                // calls the saveData function (I added since it is called twice in the program)
                saveData(date.getText(), desc.getText());
            }
        }
        );
        mnuFile.add(miExit);
        miExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // exits app
                System.exit(0);
            }
        });
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //shows a popup window containing that text
                JOptionPane.showMessageDialog(null,"Created by Paula Grata in December 2021");
            }
        });
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }

    /**
     * sets up apps gui, containing top menu bar, picture, mousemovements, date, desc,  and prev, save, and next button
     * creates the center and south layout of the app
     * center - will date and description of photo
     * south - will contain prev, save, and next button
     * setTitle will set title of app
     * setBounds sets the bounds of the app
     * closes on exit
     * calls setupmainmenu to display
     * Container c will contain pannorth and pancenter and creates a new borderlayout
     * pancenter will contain pansouth that will contain btnPrev, btnSave, btnNext
     */
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
                /**
                 * (this took a lot of trial and error to figure out)
                 * if current index is at 0 or greater than, it will be set to the 3rd photo automatically
                 */
                if (currentIndex <= 0){
                    currentIndex = 3;
                    setPictureAndData(currentIndex);
                } else {
                 /**
                 * else it will deduct 1 from the currentindex displaying the photo at the prev index
                 */
                    currentIndex = currentIndex - 1;
                    setPictureAndData(currentIndex);
                }
            } 
        });
        panSouth.add(btnSave);
        btnSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //calls save data function
                saveData(date.getText(), desc.getText());
            }
        });
        panSouth.add(btnNext);
        btnNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (currentIndex >= 3){
                    //does the same thing as prev button, yet if currentIndex is equal or greated than 3 it will be automatically set to 0
                    currentIndex = 0;
                    setPictureAndData(currentIndex);
                } else {
                    //else currentindex will add 1 displaying the next photo
                    currentIndex = currentIndex + 1;
                    setPictureAndData(currentIndex);
                }
            }
        });
        panNorth = new PicturePanel();
        c.add(panNorth,BorderLayout.NORTH);
        c.add(panCenter,BorderLayout.CENTER);
        date = new JTextField(20);
        desc = new JTextArea(1,1);      //sarah b helped me with this part - i could not figure out why my text boxes were messed up,
        desc.setLineWrap(true);         //i realized that i was not setting JTextArea - and was just using JTextField 

        /**
         * pancenter adds date to the north
         * adds desc to the center
         * and the buttons contained in pansouth to the south
         */
        panCenter.add(date,BorderLayout.NORTH);
        panCenter.add(desc,BorderLayout.CENTER);
        panCenter.add(panSouth,BorderLayout.SOUTH);

    }
    
    /**
     * setupgui is called 
     * set pictureadndata is called at the current index (I was not sure if this should go elsewhere? 
     *                                                     it seemed odd calling it after the setupgui
     *                                                     thinking it should have gone in the gui but
     *                                                     it worked here)
     */
    public PictureFrame(){
        setupGUI();
        setPictureAndData(currentIndex);
    }

}
