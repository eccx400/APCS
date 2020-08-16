package defaul;

import java.util.Scanner;


/**
 * Yo guys, I created this because I got tired of WolframAlpha asking me to
 * subscribe to its premium ($$$) service in order to solve some linear
 * equations. That ain't chill.
 * 
 * Please enjoy!
 * 
 * @author Kabir Kapoor
 * @version Nov 16, 2014
 * @author Period: LOL This isn't for a class
 * @author Assignment: LinearAlgebra (not an assignment, just a tool)
 *
 * @author Sources: NONE, well a couple Linear Algebra wikis, and
 *         artofproblemsolving but I derived everything in this so idk about any
 *         official 'sources'.
 * 
 *         OBLIGATORY CLAUSE: This program was first created by Kabir Kapoor.
 */
public class LinearAlgebra
{

    public static void main( String[] args )
    {
        double[][] coefMatrix;
        Scanner scan = new Scanner( System.in );
        int coefsize;
        System.out.println( "Yo before this starts, make sure that you have as many equations as you have variables :D. I will refer to the number of equations as the \"size\"." );
        System.out.println( "Enter the \"size\" of the coefficient matrix: " );
        coefsize = scan.nextInt();
        coefMatrix = new double[coefsize][coefsize];
        double[][] rightMatrix = new double[coefsize][1];
        System.out.println( " Part 1! Enter values for the coefficient matrix left-to-right then down." );
        System.out.println( "IMPORTANT!!!! Make sure to enter the coefficients for x first, y second, z third, w fourth etc. FOR EACH ROW IN THIS ORDER in the matrix:" );
        for ( int i = 0; i < coefsize; i++ )
        {
            for ( int j = 0; j < coefsize; j++ )
            {
                System.out.println( "Enter value: " );
                coefMatrix[i][j] = scan.nextDouble();
                System.out.println( "Received value!" );
                System.out.println( " - " );
            }
        }
        System.out.println( "Finished with Part 1!" );

        for ( int c = 0; c < coefsize; c++ )
        {
            for ( int d = 0; d < coefsize; d++ )
                System.out.print( coefMatrix[c][d] + "\t" );

            System.out.print( "\n" );
        }
        System.out.println( "Is this your coefficient matrix? (y) o (n): " );
        if ( scan.next().equals( "n" ) )
        {
            System.out.println( "Sorry, please diagnose or start over" );
        }
        else
        {
            System.out.println( "Great! Now for Part 2: " );
            System.out.println();
            System.out.println( "Enter values for the right hand side matrix up to down: " );
            for ( int i = 0; i < rightMatrix.length; i++ )
            {
                for ( int j = 0; j < rightMatrix[0].length; j++ )
                {
                    System.out.println( "Enter value: " );
                    rightMatrix[i][j] = scan.nextDouble();
                    System.out.println( "Received value!" );
                    System.out.println( " - " );
                }
            }
            System.out.println( "Finished with Part 2!" );

            for ( int c = 0; c < rightMatrix.length; c++ )
            {
                for ( int d = 0; d < rightMatrix[0].length; d++ )
                    System.out.print( rightMatrix[c][d] + "\t" );

                System.out.print( "\n" );
            }
            System.out.println( "Is this your right hand side matrix? (y) o (n): " );
            if ( scan.next().equals( "n" ) )
            {
                System.out.println( "Sorry, please diagnose or start over" );
            }
            else
            {
                System.out.println( "Great! Sit back, relax, and this program will give you all of your solutions (or tell you if there are no unique solutions)! " );
                System.out.println( "And by the way, what's with wolframalpha? It's so damn slow at doing this LOL." );
                System.out.println();
                double det = determinant( coefMatrix );
                if ( Math.abs( det - 0.0 ) <= 0.05 )
                {
                    System.out.println( "Your system has no unique solutions!" );
                }
                else
                {
                    double[][] inverseMatrix = new double[coefMatrix.length][coefMatrix[0].length];
                    int signCount = 2;
                    for ( int i = 0; i < coefMatrix.length; i++ )
                    {
                        for ( int j = 0; j < coefMatrix[0].length; j++ )
                        {

                            inverseMatrix[i][j] = determinant( minor( coefMatrix,
                                i,
                                j,
                                coefMatrix.length ) );
                            if ( signCount % 2 == 1 )
                            {
                                inverseMatrix[i][j] *= -1;
                            }
                            signCount++;
                        }
                    }
                    for ( int i = 0; i < inverseMatrix.length; i++ )
                    {
                        for ( int j = 0; j < inverseMatrix[0].length; j++ )
                        {
                            inverseMatrix[i][j] = inverseMatrix[i][j] / det;
                        }
                    }
                    double[][] transposeMatrix = transpose( inverseMatrix );
                    double[][] answerMatrix = multiply( transposeMatrix,
                        rightMatrix );
                    System.out.println( "Your solutions in the form (x,y,z,w,t,....) below: " );
                    String answerString = "(";
                    for ( int i = 0; i < answerMatrix.length; i++ )
                    {
                        answerString += answerMatrix[i][0];
                        if ( i != answerMatrix.length - 1 )
                        {
                            answerString += ",";
                        }
                    }
                    answerString += ")";
                    System.out.println( answerString );

                }
            }
        }

    }


    public static double[][] minor( double[][] M, int bar, int kol, int maxidx )
    {
        double[][] minor = new double[maxidx - 1][maxidx - 1];
        int mini = 0, minj = 0;
        for ( int i = 0; i < maxidx; i++ )
        {
            for ( int j = 0; j < maxidx; j++ )
            {
                if ( i != bar && j != kol )
                {
                    minor[mini][minj] = M[i][j];
                    minj++;
                    if ( minj == ( maxidx - 1 ) )
                    {
                        mini++;
                        minj = 0;
                    }
                }
            }
        }
        return minor;
    }


    public static double[][] transpose( double[][] isqArray )
    {
        double transpose[][] = new double[isqArray.length][isqArray[0].length];
        {
            for ( int i = 0; i < isqArray.length; i++ )
            {
                for ( int j = 0; j < isqArray[0].length; j++ )
                {
                    transpose[j][i] = isqArray[i][j];
                }
            }
        }
        return transpose;
    }


    public static double determinant( double[][] matrix )
    { // method sig. takes a matrix (two dimensional array), returns
      // determinant.
        int sum = 0;
        int s;
        if ( matrix.length == 1 )
        { // bottom case of recursion. size 1 matrix determinant is itself.
            return ( matrix[0][0] );
        }
        for ( int i = 0; i < matrix.length; i++ )
        { // finds determinant using row-by-row expansion
            double[][] smaller = new double[matrix.length - 1][matrix.length - 1];
            for ( int a = 1; a < matrix.length; a++ )
            {
                for ( int b = 0; b < matrix.length; b++ )
                {
                    if ( b < i )
                    {
                        smaller[a - 1][b] = matrix[a][b];
                    }
                    else if ( b > i )
                    {
                        smaller[a - 1][b - 1] = matrix[a][b];
                    }
                }
            }
            if ( i % 2 == 0 )
            { // sign changes based on i
                s = 1;
            }
            else
            {
                s = -1;
            }
            sum += s * matrix[0][i] * ( determinant( smaller ) );
        }
        return ( sum ); // returns determinant value. once stack is finished,
                        // returns final determinant.
    }


    public static double[][] multiply( double[][] first, double[][] second )
    {
        int m = first.length;
        int n = first[0].length;

        int p = second.length;
        int q = second[0].length;

        double multiply[][] = new double[m][q];

        double sum = 0;
        for ( int c = 0; c < m; c++ )
        {
            for ( int d = 0; d < q; d++ )
            {
                for ( int k = 0; k < p; k++ )
                {
                    sum = sum + first[c][k] * second[k][d];
                }

                multiply[c][d] = sum;
                sum = 0;
            }
        }

        return multiply;
    }
}
