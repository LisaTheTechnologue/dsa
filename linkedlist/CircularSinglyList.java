class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
    }
}

class CircularSinglyLL {
    Node last;

    // Add to empty list
    void addEmpty(int data) {
        Node n = new Node(data);
        last = n;
        last.next = last; // circular
    }

    // Add after last (tail)
    void addLast(int data) {
        Node n = new Node(data);
        n.next = last.next;
        last.next = n;
        last = n;
    }

    // Traverse
    void traverse() {
        if (last == null)
            return;
        Node cur = last.next;
        do {
            System.out.print(cur.data + " ");
            cur = cur.next;
        } while (cur != last.next);
    }
}

public class CircularSinglyList {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
    }
}
