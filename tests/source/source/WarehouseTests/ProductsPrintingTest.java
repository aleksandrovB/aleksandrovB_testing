package source.source.WarehouseTests;

import com.clouway.Main;
import com.clouway.Warehouse.BaseProduct;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ProductsPrintingTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Reassigns output stream
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Checks if every instance of BaseProduct is printed
     */
    @Test
    public void testPrintAllElements() {
        Main.printer.printAllProducts();

        StringBuilder stringBuilder = new StringBuilder();

        for (BaseProduct bp:Main.printer.getAllProducts()) {
            stringBuilder.append(bp);
        }

        assertEquals(stringBuilder.toString(),outContent.toString());
    }

    /**
     * Checks if every instance of BaseProduct is printed sorted by price
     */
    @Test
    public void testPrintSorted() {
        Main.printer.printSorted();

        StringBuilder stringBuilder = new StringBuilder();
        List<BaseProduct> sorted = new LinkedList<>(Main.printer.getAllProducts());
        sorted.sort(new Comparator<BaseProduct>() {
            @Override
            public int compare(BaseProduct o1, BaseProduct o2) {
                return Double.compare(o1.getSellPrice(),o2.getSellPrice());
            }
        });

        for (BaseProduct bp:sorted) {
            stringBuilder.append(bp);
        }

        assertEquals(stringBuilder.toString(),outContent.toString());
    }

    /**
     * Restores output stream
     */
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
