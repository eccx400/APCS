import java.util.Arrays;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Eric Cheng
 * @version 11 Feburary 2015
 * @author Period - 2
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * @author Sources - Eric Cheng
 */
public class Enigma
{
    private char[] lookupTable;


    public Enigma( int numLetters )
    {
        int x = 0;
        lookupTable = new char[numLetters];
        for ( x = 0; x < lookupTable.length; x++ )
        {
            lookupTable[x] = '-';
        }
    }


    public void setSubstitution( int index, char ch )
    {
        lookupTable[index] = ch;
    }


    public String decode( String text )
    {
        StringBuffer buffer = new StringBuffer( text.length() );

        while ( !text.isEmpty() )
        {
            char getChar = text.toUpperCase().charAt( 0 );
            char newChar = text.charAt( 0 );
            int number = Character.getNumericValue( getChar )
                - Character.getNumericValue( 'A' );

            if ( Character.isLetter( getChar ) )
            {
                if ( !Character.isLowerCase( newChar ) )
                {
                    buffer.append( Character.toUpperCase( lookupTable[number] ) );
                }
                else
                {
                    buffer.append( Character.toLowerCase( lookupTable[number] ) );
                }
            }
            else
            {
                buffer.append( getChar );
            }
            text = text.substring( 1 );
        }
        return buffer.toString();
    }


    public String getHints( String text, String lettersByFrequency )
    {
        int[] freq = countLetters( text );
        char[] newChar = new char[freq.length];
 
        System.out.println("i: " + freq[8]);
        System.out.println("t: " + freq[19]);
        for ( int r = 0; r < freq.length; r++ )
        {
            int less = 0;
 
            for ( int c = 0; c < freq.length; c++ )
            {
                if ( freq[c] < freq[r] || ( freq[c] == freq[r] && c < r) )
                {
                    less++;
                }
            }
            newChar[r] = lettersByFrequency.charAt( less );
        }
 
        StringBuffer hint = new StringBuffer();
        int x = 0;
        while( x < newChar.length)
        {
            hint.append( newChar[x] );
            x++;
        }
        return hint.toString();
    }


    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];
        text = text.toUpperCase();

        while ( !text.isEmpty() )
        {
            char getChar = text.charAt( 0 );
            text = text.substring( 1 );
            if ( Character.isLetter( getChar ) )
            {
                int index = Character.getNumericValue( getChar )
                    - Character.getNumericValue( 'A' );
                counts[index]++;
            }
        }
        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    protected char[] getLookupTable()
    {
        return lookupTable;
    }


    protected int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}