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

public class search {
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
    private static int checkIfPresent(Node head,int val){
        Node temp=head;
        while(temp!=null){
            if(temp.data==val) {
                return 1;
            }
            temp=temp.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr={12,4,5,6};
        Node head=convertToLL(arr);
        System.out.println(head);
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
        int present=checkIfPresent(head, 9);
        System.out.println(present);
    }
}
