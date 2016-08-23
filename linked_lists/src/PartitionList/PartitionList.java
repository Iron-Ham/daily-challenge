package PartitionList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshamsalman on 8/23/16.
 */
public class PartitionList {

    Node partitionList(Node head, int targetValue) {
        Node current = head;
        Node bigger = null;
        Node previousNode = null;

        while (current != null) {
            if (current.data == targetValue) {
                previousNode = current;
                current = current.next;
            } else if (current.data < targetValue) {
                if (previousNode == null) {
                    // Head is smaller than target, which is good
                    previousNode = current;
                    current = current.next;
                } else {
                    // make a new head
                    previousNode.next = current.next;
                    current.next = head;
                    head = current;
                    current = previousNode.next;
                }
            } else {
                if (previousNode == null) {
                    // Head is bigger than target
                    head = head.next;
                    if (bigger == null) {
                        bigger = current;
                        bigger.next = null;
                    } else {
                        current.next = bigger;
                        bigger = current;
                    }
                    current = head;
                } else if (current.next == null) {
                    // Last node is bigger than target, which is good.
                    previousNode = current;
                    current = null;
                } else {
                    // Middle is bigger than target
                    previousNode.next = current.next;
                    current.next = bigger;
                    bigger = current;
                    current = previousNode.next;
                }
            }
        }
        previousNode.next = bigger;
        return head;
    }

}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    void appendToEnd(int k) {
        Node n = this;
        Node newNode = new Node(k);

        while(n.next != null)
            n = n.next;

        n.next = newNode;
    }
}
