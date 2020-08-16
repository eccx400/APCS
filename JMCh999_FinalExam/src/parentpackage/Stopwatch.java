package parentpackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Stopwatch extends JPanel
{
    private Timer timer;

    private Font myClockFont;

    private JButton startBtn, stopBtn, resetBtn;

    private JLabel text;

    private JPanel topPanel, bottomPanel;

    private int clockTick; // number of clock ticks; tick can be 1.0 s or 0.1 s

    private double clockTime; // time in seconds

    private String str;
    
    public static final int ONE_SEC = 1000; // time step in milliseconds

    public static final int TENTH_SEC = 100;


    public Stopwatch()
    {
        clockTick = 0; // initial clock setting in clock ticks
        clockTime = ( (double)clockTick ) / 10.0;

        str = new Double( clockTime ).toString();
        myClockFont = new Font( "Serif", Font.PLAIN, 50 );

        startBtn = new JButton( "Start" );
        stopBtn = new JButton( "Stop" );
        resetBtn = new JButton( "Reset" );

        text = new JLabel();
        text.setFont( myClockFont );
        text.setText( str );

        timer = new Timer( TENTH_SEC, new ActionListener()
        {
            public void actionPerformed( ActionEvent evt )
            {
                clockTick++;
                clockTime = ( (double)clockTick ) / 10.0;
                str = new Double( clockTime ).toString();
                text.setText( str );
            }
        } );

        startBtn.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent evt )
            {
                timer.start();
            }
        } );

        stopBtn.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent evt )
            {
                timer.stop();
            }
        } );

        resetBtn.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent evt )
            {
                clockTick = 0;
                clockTime = ( (double)clockTick ) / 10.0;
                str = new Double( clockTime ).toString();
                text.setText( str );
            }
        } );
    }


    public void setup()
    {
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        topPanel.add( text );

        bottomPanel.add( startBtn );
        bottomPanel.add( stopBtn );
        bottomPanel.add( resetBtn );

        this.setLayout( new BorderLayout() );

        add( topPanel, BorderLayout.CENTER );
        add( bottomPanel, BorderLayout.SOUTH );

        setSize( 300, 200 );

    }


    public static void main( String[] args )
    {
        Test testing = new Test();
    }
}


class Test extends JFrame
{
    Stopwatch watch;


    public Test()
    {
        super( "Stopwatch" );
        Container myPane = getContentPane();
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        watch = new Stopwatch();
        watch.setup();
        myPane.add( watch );
        pack();
        setVisible( true );
    }
}