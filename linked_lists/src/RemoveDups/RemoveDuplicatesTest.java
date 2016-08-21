package RemoveDups;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by heshamsalman on 8/21/16.
 */
public class RemoveDuplicatesTest {
    RemoveDuplicates rD = new RemoveDuplicates();
    Node head = new Node(1);

    @Test
    public void removeDuplicateNodes_SeriesOfDuplicates() {
        head.next = new Node(1);
        head.next.next = new Node(1);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(1);

        Node n = rD.removeDuplicateNodes(head);
        int expected = 0;
        int actual = countNodeDepth(n);
        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicateNodes_ScatteredDuplicates() {
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(4);
        Node n = rD.removeDuplicateNodes(head);
        int expected = 4;
        int actual = countNodeDepth(n);
        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicateNodes_FinalDuplicate() {
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(1);
        Node n = rD.removeDuplicateNodes(head);
        int expected = 4;
        int actual = countNodeDepth(n);
        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicateNodesWithoutSet_SeriesOfDuplicates() {
        head.next = new Node(1);
        head.next.next = new Node(1);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(1);

        Node n = rD.removeDuplicatesWithoutSet(head);
        int expected = 0;
        int actual = countNodeDepth(n);
        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicateNodesWithoutSet_ScatteredDuplicates() {
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(4);
        Node n = rD.removeDuplicatesWithoutSet(head);
        int expected = 4;
        int actual = countNodeDepth(n);
        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicateNodesWithoutSet_FinalDuplicate() {
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(1);
        Node n = rD.removeDuplicatesWithoutSet(head);
        int expected = 4;
        int actual = countNodeDepth(n);
        assertEquals(expected, actual);
    }

    int countNodeDepth(Node head) {
        int count = 0;
        Node n = head;
        while (n.next != null) {
            count++;
            n = n.next;
        }
        return count;
    }

}