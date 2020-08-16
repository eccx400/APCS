import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * The Piglatinator program translates a phrase word-by-word into Pig Latin.
 * (Here, words are delineated by any combination of spaces, commas, periods,
 * question marks, exclamation marks, semicolons, colons, hyphens, double
 * quotes, or parentheses. A description of the algorithm for translating an
 * English word into a Pig Latin word is given in part 4 below.) The user can
 * load text from a file or type it in or cut and paste it from another program.
 * There is also a menu command to save the text.
 * 
 * @author Eric Cheng
 * @version 13 October 2014
 * @author Period - 2
 * @author Assignment - JMCh10_PigLatinator
 * @author Sources - Eric Cheng
 */
public class PiglatinAnalyzer
{
    /**
     * declare String
     */
    private String text;


    /**
     * Constructor: saves the text string
     * 
     * @param fromage
     *            = get String
     */
    public PiglatinAnalyzer( String fromage )
    {
        this.text = fromage;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     * 
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String english = "";

        String delim = "~!@#$%^&*()_`-=[]\\;'./,{}|:\"?>< \t";

        StringTokenizer str = new StringTokenizer( text, delim, true );

        while ( str.hasMoreTokens() )
        {
            String leWord = str.nextToken();
            if ( leWord.length() > 1)
            {
                english += wordToPigLatin( leWord );
            }
            else
            {
                if ( leWord.equals( "i" ) || leWord.equals( "I" )
                    || leWord.equals( "a" ) || leWord.equals( "A" ) )
                {
                    english += leWord + "yay";
                }
                else
                {
                    english += leWord;
                }
            }
        }
        return english;
    }

    /**
     * Converts an "english" word to its piglatin form:
     * 
     * Here's how to translate the English word englishWord into the Pig Latin
     * word pigLatinWord: If there are no vowels in englishWord, then
     * pigLatinWord is just englishWord + "ay". (There are ten vowels: 'a', 'e',
     * 'i', 'o', and 'u', and their uppercase counterparts.)
     * 
     * Else, if englishWord begins with a vowel, then pigLatinWord is just
     * englishWord + "yay".
     * 
     * Otherwise (if englishWord has a vowel in it and yet doesn't start with a
     * vowel), then pigLatinWord is end + start + "ay", where end and start are
     * defined as follows:
     * 
     * Let start be all of englishWord up to (but not including) its first
     * vowel. Let end be all of englishWord from its first vowel on. But, if
     * englishWord is capitalized, then capitalize end and "uncapitalize" start.
     * 
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        int length = englishWord.length();
        if ( isVowel( englishWord.charAt( 0 ) ) )
        {
            return englishWord + "yay"; // Second Condition
        }

        for ( int count = 0; count < length; count++ )
        {
            if ( isVowel( englishWord.charAt( count ) ) ) // Third Condition
            {
                if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
                {
                    return Character.toUpperCase( englishWord.charAt( count ) )
                        + englishWord.substring( count + 1 )
                        + Character.toLowerCase( englishWord.charAt( 0 ) )
                        + englishWord.substring( 1, count ) + "ay";
                }
                return englishWord.substring( count )
                    + englishWord.substring( 0, count ) + "ay";
            }
        }
        return englishWord + "ay"; // First Condition
    }


    /**
     * The char version of isVowel
     * 
     * @param fromage
     *            = given char
     * @return true or false for a vowel
     */
    public boolean isVowel( char fromage )
    {
        if ( fromage == 'A' || fromage == 'E' || fromage == 'I'
            || fromage == 'O' || fromage == 'U' || fromage == 'a'
            || fromage == 'e' || fromage == 'i' || fromage == 'o'
            || fromage == 'u' )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * The string version of isVowel
     * 
     * @param fromage
     *            = given string
     * @return true or false for a vowel
     */
    public boolean isVowel( String fromage )
    {
        if ( fromage.equals( "A" ) || fromage.equals( "a" )
            || fromage.equals( "E" ) || fromage.equals( "e" )
            || fromage.equals( "I" ) || fromage.equals( "i" )
            || fromage.equals( "O" ) || fromage.equals( "o" )
            || fromage.equals( "U" ) || fromage.equals( "U" ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
