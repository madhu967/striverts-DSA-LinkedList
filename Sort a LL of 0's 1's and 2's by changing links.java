class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Sort012LinkedList {

    public static Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;

       
        Node zeroD = new Node(-1);
        Node oneD = new Node(-1);
        Node twoD = new Node(-1);

        
        Node zero = zeroD, one = oneD, two = twoD;

        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

       
        zero.next = oneD.next != null ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null; 

     
        return zeroD.next;
    }

  
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

   
    public static void main(String[] args) {
        // Create unsorted linked list: 1 -> 2 -> 0 -> 1 -> 2 -> 0
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);

        System.out.println("Before sorting:");
        printList(head);

        head = sortList(head);

        System.out.println("After sorting:");
        printList(head);
    }
}
