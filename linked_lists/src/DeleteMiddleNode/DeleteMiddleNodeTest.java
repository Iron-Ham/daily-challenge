package DeleteMiddleNode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/22/16.
 */
public class DeleteMiddleNodeTest {

    Node head;
    DeleteMiddleNode dM = new DeleteMiddleNode();
    int originalCount;

    @Before
    public void setUp() {
        head = new Node(3);
        head.appendToEnd(2);
        head.appendToEnd(1);
        head.appendToEnd(1);
        head.appendToEnd(1);
        head.appendToEnd(1);
        originalCount = 6;
    }

    @Test
    public void deleteNode_FirstNode() {
        dM.deleteNode(head);
        Node k = head;
        int newCount = 0;
        while (k != null) {
            k = k.next;
            newCount++;
        }

        assertEquals(newCount, 5);
    }

    @Test
    public void deleteNode_MiddleNode() {
        dM.deleteNode(head.next);
        Node k = head;
        int newCount = 0;
        while (k != null) {
            k = k.next;
            newCount++;
        }

        assertEquals(newCount, 5);
    }

    @Test
    public void deleteNode_LastNode() {
        Node toDelete = head;
        while (toDelete.next != null) {
            toDelete = toDelete.next;
        }
        dM.deleteNode(toDelete);
        Node k = head;
        int newCount = 0;
        while (k != null) {
            k = k.next;
            newCount++;
        }

        assertEquals(newCount, originalCount);
    }

}