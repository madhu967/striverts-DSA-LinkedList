package doublelinkedlist;

class Node{
    int data;
    Node next;
    Node back;

    Node(int data1,Node next1,Node back1){
        this.data=data1;
        this.next=next1;
        this.back=back1;
    }

    Node(int data1){
        data=data1;
        next=null;
        back=null;
    }
}

public class insertionsindll {
    private static Node convertToDll(int[] arr){
        Node head=new Node(arr[0]);
        Node prev=head;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }
    private static void print(Node head){
        while (head!=null) {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    private static Node insertBeforeHead(Node head,int val){
        Node newHead=new Node(val,head,null);
        head.back=newHead;
        return newHead;
    }
    public static void main(String[] args) {
        int[] arr={12,5,8,7};
        Node head=convertToDll(arr);
        head=insertBeforeHead(head, 15);
        print(head);
    }
}
