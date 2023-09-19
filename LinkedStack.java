public class LinkedStack<E> {
    Node<E> head;

    public static void main(String[] args){
        LinkedStack stack = new LinkedStack();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        stack.print();
        stack.pop();
        stack.pop();
        stack.print();
    }

    LinkedStack(){
        head = new Node<E>();
        head.next = null;
    }

    public void push(E value){
        Node<E> new_node = new Node<E>();
	    new_node.value = value;
	    new_node.next = head.next;
	    head.next = new_node;
    }

    public void pop(){
        if (!empty()) {
            Node<E> to_delete = head.next;
            head.next = to_delete.next;
        }
           
    }

    public E top(){
        return head.next.value;
    }

    public boolean empty(){
        return head.next == null;
    }

    public void print(){
        Node<E> pivot = head;
        while(pivot != null){
            System.out.println(pivot.value);
            pivot = pivot.next;
        }
    }
}

class Node<E>{

    E value;

    Node<E> next;

    Node(){

    }

    Node(E value){
        this.value = value;
    }
    
    Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }

}
