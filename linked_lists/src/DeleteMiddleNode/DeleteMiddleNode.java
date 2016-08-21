package DeleteMiddleNode;

/**
 * Created by heshamsalman on 8/21/16.
 */
public class DeleteMiddleNode {

    void deleteNode(Node node) {
        // Given access only to the node, you cannot delete it if it is the last node.
        // When only given access to one node, setting its values and pointers to those
        // of the next node effectively 'delete' it. 
        if (node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
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
