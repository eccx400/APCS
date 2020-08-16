import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 *  Test for the complex number class.
 *  
 *  testConstructor1Param - test the 1 parameter constructor
 *  testConstructor2Param - test the 2 parameter constructor
 *  testAddRealAndComplexNum - addition of a complex number 
 *     with a real number
 *  testAdd2ComplexNums - addition of two complex numbers
 *  testMultiply2ComplexNums - multiplication of two complex numbers
 *  testMultiplyRealAndComplexNum - multiplication of a complex number
 *     with a real number
 *  testAbsoluteValue - absolute value of a complex number
 *
 *  @author  Eric Cheng
 *  @version 30 Septembre 2014
 *  @author  Period: 2
 *  @author  Assignment: JMCh09Ex17_Complex 
 *
 *  @author  Sources: Eric Cheng
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    private static final double REAL = 10.0;
    private static final double IMAGINE = 5.0;
    
    private Complex machine1;
    
    public void setUp()
    {
      machine1 = new Complex(REAL,IMAGINE);    
    }
    
    @Test
    public void testConstructor1Param()
    {
        machine1 = new Complex( REAL );
        assertEquals( "10.0 + 0.0i", machine1.toString() );
    }

    @Test
    public void testConstructor2Param()
    {
        machine1 = new Complex( REAL, IMAGINE );
        assertEquals( "10.0 + 5.0i", machine1.toString() );
    }

    @Test
    public void testAddRealAndComplexNum()
    {
        machine1 = new Complex( REAL, IMAGINE );
        machine1 = machine1.add( 1.0 );
        assertEquals( "11.0 + 5.0i", machine1.toString() );
    }
    
    @Test
    public void testAdd2ComplexNums()
    {
        machine1 = new Complex( REAL, IMAGINE );
        machine1 = machine1.add( new Complex( 1.0, 3.0 ) );
        assertEquals( "11.0 + 8.0i", machine1.toString() );
    }

    @Test
    public void testMultiply2ComplexNums()
    {
        machine1 = new Complex( REAL, IMAGINE);
        machine1 = machine1.multiply( new Complex( 2.0, 3.0 ) );
        assertEquals( "5.0 + 40.0i", machine1.toString() );
    }

    @Test
    public void testMultiplyRealAndComplexNum()
    {
        machine1 = new Complex( REAL, IMAGINE );
        machine1 = machine1.multiply( 5.0 );
        assertEquals( "50.0 + 25.0i", machine1.toString() );
    }

    @Test
    public void testAbsoluteValue()
    {
        machine1 = new Complex( 3.0, 4.0 );
        assertEquals( 5.0, machine1.abs(), 0.01 );
    }
    
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }

    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
