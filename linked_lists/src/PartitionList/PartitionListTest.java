package PartitionList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/23/16.
 */
public class PartitionListTest {
    Node head = new Node(3);
    PartitionList pL = new PartitionList();

    @Test
    public void partitionList() {
        head.appendToEnd(3);
        head.appendToEnd(5);
        head.appendToEnd(3);
        head.appendToEnd(3);

        int target = 5;
        Node h = pL.partitionList(head, target);
        int[] expected = { 3, 3, 3, 3, 5};
        int count = 0;

        while(h != null) {
            assertEquals(expected[count++], h.data);
            h = h.next;
        }
        assertEquals(expected.length, count);
    }

    @Test
    public void partitionList_WorstCase() {
        head.data = 9;
        head.appendToEnd(9);
        head.appendToEnd(5);
        head.appendToEnd(3);
        head.appendToEnd(3);

        int target = 5;
        Node h = pL.partitionList(head, target);
        int count = 0;
        int[] expected = { 3, 3, 5, 9, 9};

        while(h != null) {
            assertEquals(expected[count++], h.data);
            h = h.next;
        }
        assertEquals(expected.length, count);
    }
}