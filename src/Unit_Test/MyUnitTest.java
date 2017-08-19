package Unit_Test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


/**
 * Created by SHOBOJIT on 6/17/2017.
 */


public class MyUnitTest {
    MyUnit_01 myUnit_01;
    MyUnit_02 myUnit_02;

    @Test
    public void testConcate(){

        String result = myUnit_01.Concate("one","two");
        assertEquals("onetwo", result);
        assertEquals(4,2+2);
    }


    @Before
    public void SetupTest(){
        myUnit_01 =new MyUnit_01();
        myUnit_02 = new MyUnit_02();
    }

    @Test
    public void testMultiply() {

        try
        {
            assertEquals(0, myUnit_02.Multiply(10,0));
            assertEquals(150, myUnit_02.Multiply(10,15));
            assertEquals(120, myUnit_02.Multiply(10,12));
        }catch (Exception e){
           System.out.println("e");
        }
    }


    @Test
    public void TestArray(){
        String[] expectedArray = {"Shuvojit", "Kar", "Manna"};
    String [] ResultArray = myUnit_02.TestStringArray();
    assertArrayEquals(expectedArray,ResultArray);
    }
}
