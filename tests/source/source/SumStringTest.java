package source.source;

import com.clouway.StringSumator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SumStringTest {
    private StringSumator strSum = new StringSumator();


    @Test
    public void sumFiveAndSix() {
        assertEquals("11.0",strSum.sum("5","6"));
    }

    @Test
    public void sumZeroAndFive() {
        assertEquals("5.0",strSum.sum("0","5"));
    }

    @Test
    public void negativeSum() {
        assertEquals("-6.0",strSum.sum("-9","3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonNumberValues() {
        strSum.sum("not a number","7point3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullValues() {
        strSum.sum(null,"something");
    }

    //
////    @Rule
////    public ExpectedException thrown = ExpectedException.none();
//
//    @Test(expected = IllegalArgumentException.class)
//    public void nonDoubleValues() {
//        new StringSumator().sum(null,"da");
////       thrown.expect(IllegalArgumentException.class);
//    }
}


