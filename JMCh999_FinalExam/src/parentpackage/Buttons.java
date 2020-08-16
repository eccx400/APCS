package parentpackage;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.Image;


/**
 * Creates the buttons, although not in use yet
 * 
 * @author Eric Cheng
 * @author Kabir Kapoor
 * @date 5/23/2015
 * @author Assignment - JMCh999_FinalExam
 */
public class Buttons extends JFrame implements ActionListener
{
  
    // instance variables 
    JButton[] array = new JButton[10]; 
  

    // constructor for ButtonFrame 
    public Buttons() 
    { 
        super( "Numbers" ); 
        getContentPane().setLayout( new FlowLayout() ); 
        
        for ( int i = 1; i < array.length; i++ ) 
        { 
            array[i] = new JButton( "" + i ); 
            array[i].setActionCommand( "" + i ); 
            getContentPane().add( array[i] ); 
            array[i].addActionListener( this ); 
        } 
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    } 
  
    // Check to see if the number is correct
    public void actionPerformed( ActionEvent evt ) 
    { 
       
    } 
  
    public static void main( String[] args )
    {
        Buttons frm = new Buttons();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}