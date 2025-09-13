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

public class insert {
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

    private static Node insertHead(Node head,int val){
        Node temp=new Node(val,head);
        return temp;
    }
    public static void main(String[] args) {
        int[] arr={12,4,5,6};
        Node head=convertToLL(arr);
        System.out.println(head);
        head=insertHead(head, 15);
        System.out.println(head.data);
    }
}
