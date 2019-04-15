import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {

    private static final String[] INITIAL_DATA = new String[]{"ONE", "TWO", "THREE"};

    private ListIterator listIterator;

    @Before
    public void createLI() throws OperationNotSupportedException {
        listIterator = new ListIterator(ListIteratorTests.INITIAL_DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithNullParam() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void printShouldReturnCorrectElement() {
        Assert.assertEquals(ListIteratorTests.INITIAL_DATA[0], listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void printOnEmptyListShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void hasNextShouldReturnFalseOnEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();

        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void hasNextShouldReturnTrueIfThereAreNextElements() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void moveShouldMoveCorrectlyToTheNextElement() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void moveShouldReturnFalseOnEndOfList() {
        for (int i = 0; i < 2; i++) {
            listIterator.move();
        }
        Assert.assertFalse(listIterator.move());
    }
}
