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
    private static Node insertTail(Node head,int val){
        if(head==null){
            return new Node(val);
        }
        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        Node newNode=new Node(val);
        temp.next=newNode;
        return head;
    }
    private static Node insertPosition(Node head,int val,int k){
        if(head==null){
            if(k==1){
                return new Node(val);
            }
            else{
                return head;
            }
        }
        if(k==1){
            return new Node(val,head);
        }
        int cnt=0;
        Node temp=head;
        while (temp!=null) {
            cnt++;
            if(cnt==(k-1)){
                Node x=new Node(val,temp.next);
                temp.next=x;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr={12,4,5,6};
        Node head=convertToLL(arr);
        System.out.println(head);
        head=insertHead(head, 15);
        System.out.println(head.data);
        head=insertTail(head, 8);
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        head=insertPosition(head, 10, 3);
        temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
