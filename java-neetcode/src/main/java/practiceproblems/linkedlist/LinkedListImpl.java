package practiceproblems.linkedlist;

public class LinkedListImpl {

    Node head;


    public void insert(int data) {

        Node n = new Node(data);

        if (head == null) {
            head = n;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = n;
        }
    }
}
