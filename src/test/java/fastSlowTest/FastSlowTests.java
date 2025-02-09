package fastSlowTest;

import fastSlowPointers.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static fastSlowPointers.FastSlow.*;

public class FastSlowTests {

    private ListNode notCyclical;

    @Before
    public void setUp(){
        notCyclical = new ListNode(1);
        notCyclical.next = new ListNode(2);
        notCyclical.next.next = new ListNode(3);
        notCyclical.next.next.next = new ListNode(4);
        notCyclical.next.next.next.next = new ListNode(5);
        notCyclical.next.next.next.next.next = new ListNode(6);
        notCyclical.next.next.next.next.next.next = new ListNode(7);
    }

    @Test
    public void testSlowFastFalse() {
        Assert.assertFalse(hasCycle(notCyclical));
    }

    @Test
    public void testSlowFastTrue() {
        notCyclical.next.next.next.next.next.next = notCyclical;
        Assert.assertTrue(hasCycle(notCyclical));
    }

    @Test
    public void testGetCycleStart(){
        notCyclical.next.next.next.next.next.next = notCyclical.next.next.next;
        Assert.assertEquals(4, startOfCyclicalList(notCyclical).value);
    }

}
