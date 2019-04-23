package source.source;

import com.clouway.ArrayOperator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayOperatorGetSumTest {
    private ArrayOperator arrayOperator = new ArrayOperator();

    /**
     * Testing if getSum gets the correct sum of every element in array
     */
    @Test
    public void returnsCorrectAnswer() {

        assertEquals(6, arrayOperator.getSum(new int[]{1, 2, 3}));
    }

    /**
     * Testing if getSum calculates negative integers properly
     */
    @Test
    public void worksWithNegativeIntegers() {
        assertEquals(-5, arrayOperator.getSum(new int[]{-1, -2, -3, -4, 5}));
    }

    /**
     * Testing if getSum returns 0 with empty array
     */
    @Test
    public void worksWithEmptyArray() {
        assertEquals(0, arrayOperator.getSum(new int[]{}));
    }
}
