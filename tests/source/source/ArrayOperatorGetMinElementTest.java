package source.source;

import com.clouway.ArrayOperator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayOperatorGetMinElementTest {
    private ArrayOperator arrayOperator = new ArrayOperator();

    /**
     * Testing if getMinElement returns the smallest integer in array
     */
    @Test
    public void getCorrectMinElement() {
        assertEquals(-6,arrayOperator.getMinElement(new int[]{1,0,-2,-6,8,2}));
    }

    /**
     * Testing if getMinElement returns 0 from empty array
     */
    @Test
    public void getZeroFromEmptyArray() {
        assertEquals(0,arrayOperator.getMinElement(new int[]{}));
    }

    /**
     * Testing if Collections.min and getMinElement over the same numbers return equal results
     */
    @Test
    public void getCorrectMinByComparingWithCollectionsMin() {
        int[] array = {1,2,-6,3,6};
        List<Integer> list = new LinkedList<>();
        for (int i:array) {
            list.add(i);
        }
        assertEquals(Collections.min(list).intValue(),arrayOperator.getMinElement(array));
    }
}
