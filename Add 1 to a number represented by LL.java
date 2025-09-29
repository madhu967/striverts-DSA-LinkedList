class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class AddOneToLinkedList {

  
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

  
    public static ListNode addOne(ListNode head) {
        head = reverse(head); 

        ListNode curr = head;
        int carry = 1;

        while (curr != null && carry > 0) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;

            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(0);
            }

            curr = curr.next;
        }

        head = reverse(head);
        return head;
    }

    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

  
    public static void main(String[] args) {
      
        ListNode head = new ListNode(1);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        System.out.print("Original List: ");
        printList(head);

        head = addOne(head);

        System.out.print("After Adding One: ");
        printList(head);
    }
}
