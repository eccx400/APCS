package parentpackage;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;


/**
 * Stores some of the gameboards
 * 
 * @author Eric Cheng
 * @author Kabir Kapoor
 * @date 5/23/2015
 * @author Assignment - JMCh999_FinalExam
 */
public class Sudoku
{
    int[][] es1, es2, es3;

    int[][] me1, me2, me3;

    int[][] ha1, ha2, ha3;


    /**
     * Constructor with Games
     */
    public Sudoku()
    {
        // Easy @ http://puzzles.about.com/od/sudokupuzzles/qt/ESuDokuSol73.htm
        int[][] es1 = { { 6, 2, 9, 1, 7, 8, 4, 3, 5 },
            { 8, 4, 5, 3, 6, 2, 7, 9, 1 }, { 1, 3, 7, 5, 9, 4, 8, 2, 6 },
            { 2, 7, 8, 6, 4, 3, 5, 1, 9 }, { 3, 9, 1, 2, 8, 5, 6, 7, 4 },
            { 4, 5, 6, 7, 1, 9, 2, 8, 3 }, { 9, 6, 3, 8, 5, 7, 1, 4, 2 },
            { 5, 8, 4, 9, 2, 1, 3, 6, 7 }, { 7, 1, 2, 4, 3, 6, 9, 5, 8 } };

        // Easy @ http://puzzles.about.com/od/sudokupuzzles/qt/ESuDokuSol74.htm
        int[][] es2 = { { 2, 4, 6, 1, 5, 7, 3, 8, 9 },
            { 3, 1, 8, 6, 4, 9, 2, 5, 7 }, { 5, 7, 9, 8, 3, 2, 1, 6, 4 },
            { 9, 2, 7, 5, 8, 1, 4, 3, 6 }, { 4, 8, 5, 7, 6, 3, 9, 1, 2 },
            { 2, 6, 3, 2, 9, 4, 8, 7, 5 }, { 6, 3, 1, 9, 2, 5, 7, 4, 8 },
            { 8, 9, 4, 3, 7, 6, 5, 2, 1 }, { 7, 5, 2, 4, 1, 8, 6, 9, 3 } };

        // Easy @ http://puzzles.about.com/od/sudokupuzzles/qt/ESuDokuSol75.htm
        int[][] es3 = { { 8, 9, 6, 1, 4, 2, 3, 5, 7 },
            { 3, 1, 5, 9, 6, 7, 8, 2, 4 }, { 7, 4, 2, 3, 8, 5, 6, 1, 9 },
            { 9, 5, 1, 2, 3, 8, 4, 7, 6 }, { 4, 8, 3, 7, 5, 6, 1, 9, 2 },
            { 2, 6, 7, 4, 1, 9, 5, 3, 8 }, { 1, 2, 8, 6, 9, 3, 7, 4, 5 },
            { 6, 7, 4, 5, 2, 1, 9, 8, 3 }, { 5, 3, 9, 8, 7, 4, 2, 6, 1 } };
    }

}