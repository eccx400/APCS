package piglatinator;
import java.util.Scanner;
/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - TODO Assignment Name

   @author  Sources - TODO list collaborators
 */
public class PiglatinAnalyzer
{
    private String text;

    // Constructor: saves the text string
    public PiglatinAnalyzer(String text)
    {
        this.text = text;
    }

    /**
     * Converts a string to it piglatin form according to the following rules:
     *   a. If there are no vowels in englishWord, then pigLatinWord is just
     *      englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o',
     *      and 'u', and their uppercase counterparts.)
     *   b. Else, if englishWord begins with a vowel, then pigLatinWord is just
     *      englishWord + "yay".
     *   c. Otherwise (if englishWord has a vowel in it and yet doesn't start
     *      with a vowel), then pigLatinWord is end + start + "ay", where end
     *      and start are defined as follows:
     *        1. Let start be all of englishWord up to (but not including) its
     *           first vowel.
     *        2. Let end be all of englishWord from its first vowel on.
     *        3. But, if englishWord is capitalized, then capitalize end and
     *           "uncapitalize" start.
     *
     * @return   piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        String translateWord = "";
        for ( int i = 0; i < phraseToTranslate.length(); i++)
        {
            char ch = phraseToTranslate.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch))
            {
                translateWord += ch;
            }
            else
            {
                if ( translateWord.isEmpty())
                {
                    translation += ch;
                }
                else
                {
                    translation += wordToPigLatin(translateWord) + ch;
                    translateWord = "";
                }
            }
        }
        if ( !translateWord.isEmpty())
        {
            translation += wordToPigLatin(translateWord);
            translateWord = "";
        }
        
        return translation;
    }

    /**
     *  Converts an "english" word to its piglatin form
     *
     * @param  englishWord  a string representing an english word
     * @return              piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord)
    {
        String pigLatinWord = "";
        if ( englishWord.contains("A") || englishWord.contains("a") || 
                        englishWord.contains("E") || englishWord.contains("e") ||
                        englishWord.contains("I") || englishWord.contains("i") ||
                        englishWord.contains("O") || englishWord.contains("o") ||
                        englishWord.contains("U") || englishWord.contains("u"))
        {
            char first = englishWord.charAt(0);
            if ( isVowel(first))
            {
                pigLatinWord += englishWord + "yay";
            }
            else
            {
                int start = 0;
                while (!isVowel(englishWord.charAt(start)))
                {
                    start++;
                }
                pigLatinWord += englishWord.substring(start) + 
                                englishWord.substring( 0, start ) + "ay";
                if (Character.isUpperCase( englishWord.charAt( 0 ) ))
                {
                    pigLatinWord = englishWord.substring(start, start+1).toUpperCase() +
                            englishWord.substring(start+1) + englishWord.substring(0,1).toLowerCase()+
                            englishWord.substring(1,start) + "ay";
                            
                }
            }
        }
        else
        {
            pigLatinWord = englishWord + "ay";
            /**for( int i = 0; i < englishWord.length(); i++ )
            {
                if ( !Character.isLetter(englishWord.charAt(i)))
                {
                    pigLatinWord += englishWord.charAt(i);
                }
            }**/
        }
        return pigLatinWord;
    }
    /**
     * 
     * @param c char
     * @return if the char is a vowel
     */
    public boolean isVowel(char c)
    {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' ||
                        c == 'U' || c == 'a' || c == 'e' ||
                        c == 'i' || c == 'o' || c == 'u';
    }

}
