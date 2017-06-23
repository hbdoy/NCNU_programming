class Node{
    int value;
    Node next;
}

public class LLQueue{
    Node head, tail;
    public void add(int x){
        Node temp = new Node();
        temp.value = x;
        if(tail != null){
            tail.next = temp;
            tail = temp;
        }else{
            head = tail = temp;
        }
    }
    public int delete(){
        int result = head.vaule;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return result;
    }
    public boolean isEmpty(){
        return head == null;
    }
}