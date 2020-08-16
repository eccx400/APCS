package parentpackage;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


/**
 * This creates the game board and the buttons for each specific action
 * 
 * @author Eric Cheng
 * @author Kabir Kapoor
 * @date 5/23/2015
 * @author Assignment - JMCh999_FinalExam
 */
public class BoardGUI extends JFrame implements ActionListener
{
    JPanel buttonPanel;
    
    ArrayList<Button> buttonList = new ArrayList(4);

    int[][] board;

    int num;
    
    private JPanel topPanel, bottomPanel;
    
    JFrame frame = new JFrame( "Sudoku GameBoard" );
    
    private Button start;
    
    private Button checkpoint;
    
    private Button hint;
    
    private Button solution;

    /**
     * Constructor
     */
    public BoardGUI()
    {
        super();

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setBounds(30, 30, 300, 300);
        frame.add( new SetPanel() );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
        
        JPanel mainPanel = new JPanel();
        buttonPanel = new JPanel();     
        buttonPanel.setLayout(new GridLayout(12,1));   
        buttonPanel.setSize(900,900);

        add(mainPanel); 
        
        buttonList.add(start);
        buttonPanel.add(buttonList.get(0));
        buttonList.get(0).addActionListener(this);
        
        buttonList.add(checkpoint);
        buttonPanel.add(buttonList.get(1));
        buttonList.get(1).addActionListener(this);
        
        buttonList.add(hint);
        buttonPanel.add(buttonList.get(2));
        buttonList.get(2).addActionListener(this);
        
        buttonList.add(solution);
        buttonPanel.add(buttonList.get(3));
        buttonList.get(3).addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.add(buttonPanel);
    }
    
    public void setup()
    {
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        topPanel.add( frame );

        bottomPanel.add( start );
        bottomPanel.add( checkpoint );
        bottomPanel.add( hint );
        bottomPanel.add( solution );

        this.setLayout( new BorderLayout() );

        add( topPanel, BorderLayout.CENTER );
        add( bottomPanel, BorderLayout.SOUTH );

        setSize( 300, 200 );

    }


    /**
     * Testing use only
     * 
     * @param args
     *            = argument array
     */
    public static void main( String args[] )
    {
        BoardGUI frm = new BoardGUI();

        frm.setSize( 200, 300 );
        frm.setVisible( true );
    }


    @Override
    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed( ActionEvent e )
    {
        // TODO Auto-generated method stub

    }

    /**
     * private JButton start;
     * 
     * private JButton checkpoint;
     * 
     * private JButton hint;
     * 
     * private JButton solution;
     * 
     * start = new JButton( "Start Game" ); checkpoint = new JButton(
     * "Checkpoint" ); hint = new JButton( "Get Hint" ); solution = new JButton(
     * "Get Solution" );
     * 
     * start.addActionListener( this ); checkpoint.addActionListener( this );
     * hint.addActionListener( this ); solution.addActionListener( this );
     * 
     * // add the button to the JFrame getRootPane().setLayout( new FlowLayout()
     * ); getRootPane().add( start ); getRootPane().add( checkpoint );
     * getRootPane().add( hint ); getRootPane().add( solution );
     * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * 
     */
}