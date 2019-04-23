package source.source;

import com.clouway.StringSumator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SumStringTest {
    private StringSumator strSum = new StringSumator();

    /**
     * Testing if 5 + 6 returns 11.0
     */
    @Test
    public void sumFiveAndSix() {
        assertEquals("11.0",strSum.sum("5","6"));
    }

    /**
     * Testing if 0 + 5 returns 5.0
     */
    @Test
    public void sumZeroAndFive() {
        assertEquals("5.0",strSum.sum("0","5"));
    }

    /**
     * Testing if -9 + 3 returns -6.0
     */
    @Test
    public void negativeSum() {
        assertEquals("-6.0",strSum.sum("-9","3"));
    }

    /**
     * Testing if one of the values is not a number proper exception is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    public void nonNumberValues() {
        strSum.sum("3","7point3");
    }

    /**
     * Testing if one of the values is null proper exception is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullValues() {
        strSum.sum(null,"something");
    }
}


