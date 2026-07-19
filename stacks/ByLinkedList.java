package stacks;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val= val;
        this.next=null;
    }
}

class Stack{
    Node head = null;

    Boolean isEmpty(){
        return head==null;
    }

    void push(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            head = temp;
            return;
        }
        temp.next=head;
        head = temp;
    }
    int pop(){
        if(isEmpty()){
            return -1;

        }
        int top = head.val;
        head = head.next;
        return top;
    }

    int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.val;
    }

}

public class ByLinkedList {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(12);
        s.push(24);
        s.push(36);
        
    }
    
}
