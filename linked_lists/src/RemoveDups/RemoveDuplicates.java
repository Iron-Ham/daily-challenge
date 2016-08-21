package RemoveDups;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by heshamsalman on 8/21/16.
 */
public class RemoveDuplicates {

    Node removeDuplicateNodes(Node head) {
        Set<Integer> dataSet = new HashSet<>();
        Node n = head;
        dataSet.add(head.data);
        while (n.next != null) {
            if (dataSet.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                n = n.next;
                if (n != null)
                    dataSet.add(n.data);
            }
        }
        return head;
    }

    Node removeDuplicatesWithoutSet(Node head) {
        Node n = head;
        Node runner = head;

        while (n != null && n.next != null) {
            while (runner.next != null) {
                if (runner.next.data == n.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            n = n.next;
        }
        return head;
    }
}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }

    void appendToEnd(int k) {
        Node n = this;
        Node newNode = new Node(k);

        while(n.next != null)
            n = n.next;

        n.next = newNode;
    }
}
