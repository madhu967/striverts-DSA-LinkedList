package LinkedList;

class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        this.data=data1;
        this.next=next1;
    }
    Node(int data1){
        this.data=data1;
        this.next=null;
    }
}

public class deleteTail {
    private static Node convertToLL(int[] arr){
        Node head=new Node(arr[0]);
        Node mover=head;
        for(int i=1;i<arr.length;i++){
           Node temp=new Node(arr[i]);
           mover.next=temp;
           mover=temp;
        }
        return head;
    }

    private static Node removetail(Node head){
        if(head==null || head.next==null) return null;

        Node temp=head;
        while (temp.next.next != null) {
            temp=temp.next;
        }

        temp.next=null;

        return head;
    }
    public static void main(String[] args) {
        int[] arr={12,4,5,6};
        Node head=convertToLL(arr);
        System.out.println(head);
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        head=removetail(head);
        temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

    }
}
