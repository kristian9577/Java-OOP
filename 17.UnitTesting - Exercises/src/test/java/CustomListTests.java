import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

public class CustomListTests {
    private CustomLinkedList<Integer> linkedList;

    @Before
    public void createList() {
        this.linkedList = new CustomLinkedList<>();
    }

    @Test
    public void addingElementShouldAddCorrectly() {
        linkedList.add(12);
        Assert.assertTrue(linkedList.contains(12));
    }

    @Test
    public void containsShouldReturnTrueIfElementIsPresentInsideList() {
        linkedList.add(12);
        linkedList.add(22);
        linkedList.add(32);
        Assert.assertTrue(linkedList.contains(32));
    }

    @Test
    public void containsShouldReturnFalseOnEmptyList() {
        Assert.assertFalse(linkedList.contains(32));
    }

    @Test
    public void containsShouldReturnFalseIfElementIsNotPresent() {
        linkedList.add(22);
        linkedList.add(32);
        Assert.assertFalse(linkedList.contains(2));
    }

    @Test
    public void indexOfReturnCorrectValue() {
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
        Assert.assertEquals(linkedList.indexOf(99), 99);
    }

    @Test
    public void indexOfReturnMinusOneIfElementIsNotPresentInList() {
        Assert.assertEquals(linkedList.indexOf(1), -1);
    }

}
