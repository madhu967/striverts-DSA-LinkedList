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

public class arraytodll {

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
    private static Node deleteHead(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node prev=head;
        head=head.next;

        head.back=null;
        prev.next=null;

        return head;
    }

    private static Node deleteTail(Node head){
        if(head==null||head.next==null){
            return null;
        }
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        Node prev=tail.back;
        prev.next=null;
        tail.back=null;
        return head;

    }
    private static Node removekthElement(Node head,int k){
       if(head==null){
        return null;
       }
       int cnt=0;
       Node kNode=head;
       while (kNode!=null) {
        cnt++;
        if(cnt==k) break;
        kNode=kNode.next;
       }
       Node prev=kNode.back;
       Node front=kNode.next;

       if(prev==null && front== null){
        return null;
       }
       else if(prev==null){
        return deleteHead(head);
       }
       else if(front==null){
        return deleteTail(head);
       }
       prev.next=front;
       front.back=prev;

       kNode.next=null;
       kNode.back=null;

       return head;
    }
    private static void deletNode(Node temp){
        Node prev=temp.back;
        Node front=temp.next;
        if(front==null){
            prev.next=null;
            temp.back=null;
        }
        prev.next=front;
        front.back=prev;

        temp.next=null;
        temp.back=null;

        
    }
    public static void main(String[] args) {
        int[] arr={12,5,8,7};
        Node head=convertToDll(arr);
        // System.out.println(head.data);
        // print(head);
        // head=deleteHead(head);
        // head=deleteTail(head);
        // print(head);
        // System.out.println(head.data);
        // head=removekthElement(head, 1);
        deletNode(head.next);
        print(head);
    }
}
