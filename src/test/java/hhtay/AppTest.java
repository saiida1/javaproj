package hhtay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class AppTest 
{
    public AppTest()
    {
    }

    @Test
    public void testApp()
    {
    	assertNotEquals(new App(), null);
    }
    
    @Test
    public void testGetArea()
    {
    	App app = new App(5, 2);
    	assertEquals(app.getArea(), 10);
    }
}
