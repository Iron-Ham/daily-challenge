package ReturnKthToLast;

/**
 * Created by heshamsalman on 8/21/16.
 */
public class KthToLast {
    Node findKthToLastNode(Node head, int k) {
        Node n = head;
        Node runner = head;

        while (k > 0) {
            runner = runner.next;
            if (runner == null)
                return null;
            k--;
        }

        while (runner.next != null) {
            runner = runner.next;
            n = n.next;
        }

        return n;
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