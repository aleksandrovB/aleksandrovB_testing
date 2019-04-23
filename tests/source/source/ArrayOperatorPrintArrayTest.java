package source.source;

import com.clouway.ArrayOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ArrayOperatorPrintArrayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ArrayOperator arrayOperator = new ArrayOperator();

    /**
     * Reassigning the standard output stream to ByteArrayOutput before every test
     */
    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Testing if printArray prints array properly
     */
    @Test
    public void printsProperElements() {
        int[] array = {1,2,3,4,5,6,7};
        arrayOperator.printArray(array);

        assertEquals("1 2 3 4 5 6 7 ",outContent.toString());
    }

    /**
     * Testing if printArray prints nothing when given an empty array
     */
    @Test
    public void printsNothingFromNothing() {
        int[] arr = {};
        arrayOperator.printArray(arr);

        assertEquals("", outContent.toString());
    }

    /**
     * Restoring the output stream after every test
     */
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
