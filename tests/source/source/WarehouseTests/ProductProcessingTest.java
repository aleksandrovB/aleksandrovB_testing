package source.source.WarehouseTests;

import com.clouway.Warehouse.BaseProduct;
import com.clouway.Warehouse.Phone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductProcessingTest {
    private BaseProduct product =
            new BaseProduct("TV",250.0,310.11,47.6,120.0);
    private double delta = 0.0001;

    /**
     * Tests getters
     */
    @Test
    public void constructorTest() {
        BaseProduct rope = new BaseProduct("rope",10,12,5,300);

        assertEquals("rope",rope.getName());
        assertEquals(10,rope.getBuyPrice(),delta);
        assertEquals(12,rope.getSellPrice(),delta);
        assertEquals(300,rope.getMaxCapacity(),delta);
        assertEquals(0,rope.getMoneyGained(),delta);
        assertEquals(50,rope.getMoneySpent(),delta);
        assertEquals(-50,rope.getProfits(),delta);
    }

    /**
     * Adds 1.01 to inStock and expects it to increase by 1.01
     */
    @Test
    public void addQuantity() {
        product.add(1.01);
        assertEquals(48.61,product.getInStock(),delta);
    }

    /**
     * Adds more items than the limit and expects current inStock to stay the same
     */
    @Test
    public void addMoreThanLimit() {
        product.add(100);

        assertEquals( 47.6,product.getInStock(), delta);
    }

    /**
     * Adds enough elements to exactly fill inStock
     */
    @Test
    public void addToMatchInStockAndMaxCapacity() {
        product.add(72.4);

        assertEquals(product.getMaxCapacity(),product.getInStock(),delta);
    }

    /**
     * Creates new product with inStock>maxCapacity
     */
    @Test
    public void initializeWithMoreThanMaxCapacity() {
        BaseProduct prod = new BaseProduct("Door",5,6,110,100);
        prod.add(72);

        assertEquals(72,prod.getInStock(),delta);
    }

    /**
     * Sells product
     */
    @Test
    public void sellProduct() {
        product.sell(46.6);

        assertEquals(1,product.getInStock(),delta);
    }

    /**
     * Sells more than available product
     */
    @Test
    public void sellMoreThanAvailable() {
        product.sell(50);

        assertEquals(47.6,product.getInStock(),delta);
    }

    /**
     * Sells everything available
     */
    @Test
    public void sellEverything() {
        Phone sams = new Phone("Samsung", 350,700,3,20);
        sams.sell(3);

        assertEquals(0,sams.getInStock(),delta);
    }

    /**
     * Sells and adds random amount of products
     */
    @Test
    public void sellAndAddWorkingProperlyTogether() {
        product.sell(0.6);
        product.add(3);
        product.add(20);
        product.sell(150);
        product.add(5);
        product.sell(25);
        product.sell(25);

        assertEquals(25,product.getInStock(),delta);
    }

    /**
     * Checks if moneySpent is getting updated properly
     */
    @Test
    public void getMoneySpent() {
        assertEquals(11900,product.getMoneySpent(),delta);
        product.add(4);
        assertEquals(12900,product.getMoneySpent(),delta);
        product.add(5000);
        assertEquals(12900,product.getMoneySpent(),delta);
    }

    /**
     * Checks if moneyGained is getting updated properly
     */
    @Test
    public void getMoneyGained() {
        assertEquals(0,product.getMoneyGained(),delta);
        product.sell(5);
        assertEquals(1550.55,product.getMoneyGained(),delta);
        product.sell(3500);
        assertEquals(1550.55,product.getMoneyGained(),delta);
    }

    /**
     * Checks if moneyGained - moneySpent is returned correctly
     */
    @Test
    public void getProfits() {
        product.sell(40);
        assertEquals(504.4,product.getProfits(),delta);
    }
}
