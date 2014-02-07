package com.github.allenday;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestStoRm 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestStoRm( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestStoRm.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testStoRm()
    {
        assertTrue( true );
    }
}
