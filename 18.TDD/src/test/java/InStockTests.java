import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class InStockTests {
    private final String DEFAULT_PRODUCT_LABEL = "label";
    private final int DEFAULT_PRODUCT_QUANTITY = 200;
    private final double DEFAULT_PRODUCT_PRICE = 2.5;

    private Product product;
    private Instock stock;

    @Before
    public void setUp() {
        this.product = new Product(DEFAULT_PRODUCT_LABEL, DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        this.stock = new Instock();
    }


    @Test
    public void shouldAddProduct() {
        stock.add(product);
        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldHaveNonZeroCountAfterProductAdd() {
        this.stock.add(product);
        Assert.assertEquals(1, this.stock.getCount());
    }

    @Test
    public void shouldHaveCountEqualsToProductAdd() {
        this.stock.add(product);
        this.stock.add(product);
        this.stock.add(product);

        Assert.assertEquals(3, this.stock.getCount());
    }

    @Test
    public void shouldReturnFalseIfProductNotContained() {
        Assert.assertFalse(this.stock.contains(product));
    }

    @Test
    public void containsShouldReturnTrueIfProductLabelMatch() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL, 11, 2);

        this.stock.add(second);

        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldReturnCorrectOrderByInsertionOrderWithOneProduct() {
        this.stock.add(product);

        Product actual = this.stock.find(1);

        Assert.assertEquals(actual, product);
    }

    @Test
    public void shouldReturnCorrectOrderByInsertionOrderWithMultipleProducts() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(product);
        this.stock.add(second);
        this.stock.add(third);

        Product actual = this.stock.find(3);

        Assert.assertEquals(third, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenFindCalledWithInvalidIndex() {
        this.stock.find(1);
    }

    @Test
    public void shouldAddQuantityToExistingProduct() {
        this.stock.add(product);

        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        Product actual = this.stock.find(1);

        Assert.assertEquals(2 * DEFAULT_PRODUCT_QUANTITY, actual.getQuantity());
    }

    @Test
    public void shouldAddQuantityToExistingProductMultipleTimes() {
        this.stock.add(product);

        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        Product actual = this.stock.find(1);

        Assert.assertEquals(4 * DEFAULT_PRODUCT_QUANTITY, actual.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void quantityShouldThrowExceptionIfProductDontExist() {

        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowExceptionIfLabelDontExist() {

        this.stock.findByLabel(product.getLabel());
    }

    @Test
    public void findByLabelShouldReturnCorrectResultForMultipleProducts() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(product);
        this.stock.add(second);
        this.stock.add(third);

        Product actual = this.stock.findByLabel(DEFAULT_PRODUCT_LABEL + "2");

        Assert.assertEquals(second, actual);
    }

    @Test
    public void findByLabelShouldReturnProduct() {
        this.stock.add(product);
        Product actual = this.stock.findByLabel(product.getLabel());
        Assert.assertEquals(actual, product);
    }

    @Test
    public void shouldReturnFirstNProductsSortedByLabel() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(product);

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultOrEmptyStockInFindFirstByAlphabeticalOrder() {
        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultOrNegativeCountStockInFindFirstByAlphabeticalOrder() {
        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(-1);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultForGreaterCountStockInFindFirstByAlphabeticalOrder() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(product);

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(5);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultForInStockInFindFirstByAlphabeticalOrder() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(product);

        Product[] sorted = {product, second, third};

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(3);

        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(actual.iterator().hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertEquals(sorted[i++], iterator.next());
        }
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableForEmptyStock() {

        Iterable<Product> actual = this.stock.findAllInRange(5, 15);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableIfNonMatchesThePrice() {

        this.stock.add(product);

        Iterable<Product> actual = this.stock.findAllInRange(5, 15);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableForNegativePrices() {

        this.stock.add(product);

        Iterable<Product> actual = this.stock.findAllInRange(-5, -15);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnCorrectResult() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(product);
        this.stock.add(second);
        this.stock.add(third);

        Iterable<Product> actual = this.stock.findAllInRange(DEFAULT_PRODUCT_PRICE -1, DEFAULT_PRODUCT_PRICE +1);

        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }
    @Test
    public void findAllInPriceRangeShouldReturnCorrectResultForHigherBoundEdge() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(product);
        this.stock.add(second);
        this.stock.add(third);

        Iterable<Product> actual = this.stock.findAllInRange(DEFAULT_PRODUCT_PRICE -1, DEFAULT_PRODUCT_PRICE );

        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }
    @Test
    public void findAllInPriceRangeShouldSortCorrectly() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 20, 10);

        this.stock.add(product);
        this.stock.add(second);
        this.stock.add(third);

        Iterable<Product> actual = this.stock.findAllInRange( 0, 30 );

        Product[] sorted = {third, second, product};
        Iterator<Product> iterator = actual.iterator();

            Assert.assertTrue(actual.iterator().hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertEquals(sorted[i++], iterator.next());
        }
    }
}
