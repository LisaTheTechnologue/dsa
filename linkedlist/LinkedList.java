import java.util.HashSet;

public class LinkedList {
    class Node {
        int value;
        Node next;
        Node prev;
    }

    public Node head;
    public Node tail;
    public int size;

    public void createLL(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertNode(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void traversalLL() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Create the HashSet to keep track of the existing value
     * Traverse through the LinkedList
     * --> HashSet contains value --> point to next one to remove the node
     * 
     */
    void deleteDups() {
        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.value)) {
                // duplicate found, skip current node
                prev.next = current.next;
            } else {
                seen.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    /**
     * Using Two Pointers: fast and slow
     * fast will reach end first
     * slow will move along with fast
     * 'nth to last': so 'fast' should move ahead of 'slow' n steps
     * 
     * @param n
     * @return Node
     */
    Node nthToLast(int n) {
        if (head == null || n <= 0) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null; // n is larger than list length
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * Write code to partition a linked list around a value x, such that all nodes
     * less than x come before all nodes greater than or equal to x.
     * 
     * explain:
     * nodes < x : left of x
     * nodes >= x : right of x
     * 
     * solutions:
     * nodes < x : add to head
     * nodes >= x : add to tail
     * then add 2 together
     * 
     * @param args
     */
    LinkedList partition(LinkedList ll, int x) {
        Node current = ll.head;
        ll.tail = ll.head;
        while (current != null) {
            Node next = current.next;
            if (current.value < x) {
                current.next = ll.head;
                ll.head = current;
            } else {
                ll.tail.next = current;
                ll.tail = current;
            }
            current = next;
        }
        ll.tail.next = null;
        return ll;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.createLL(1);
        ll.insertNode(2);
        ll.insertNode(4);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);

        System.out.println("Original Linked List:");
        ll.traversalLL();

        ll.deleteDups();

        System.out.println("After Deleting Duplicates:");
        ll.traversalLL();

        System.out.println("Nth to Last:");
        Node node = ll.nthToLast(2);
        System.out.println(node.value);

        System.out.println("Partition at 3:");
        LinkedList ll1 = ll.partition(ll, 3);
        ll1.traversalLL();
    }

}