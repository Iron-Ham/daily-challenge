package ReturnKthToLast;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/21/16.
 */
public class KthToLastTest {

    KthToLast kL = new KthToLast();

    @Test
    public void findKthToLastNode_FirstToLast() throws Exception {
        Node head = new Node(9);
        head.next = new Node(8);
        head.next.next = new Node(7);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next.next = new Node(0);

        int expectedValue = 1;
        int actualValue = kL.findKthToLastNode(head, 1).data;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void findKthToLastNode_SecondToLast() throws Exception {
        Node head = new Node(9);
        head.next = new Node(8);
        head.next.next = new Node(7);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next.next = new Node(0);

        int expectedValue = 2;
        int actualValue = kL.findKthToLastNode(head, 2).data;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void findKthToLastNode_WhereKBiggerThanList() throws Exception {
        Node head = new Node(9);
        head.next = new Node(8);
        head.next.next = new Node(7);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next.next = new Node(0);

        Node expectedValue = null;
        Node actualValue = kL.findKthToLastNode(head, 12);

        assertEquals(expectedValue, actualValue);
    }

}