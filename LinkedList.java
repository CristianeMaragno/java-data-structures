public class LinkedList{

    private Node head;

    private int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;

    }

    public static void main(String[] args){
        LinkedList linked = new LinkedList();
        for(int i = 0; i < 10; i++){
            linked.insert(i, i*2);
        }
        linked.print();


    }

    public Node find(int x){
        Node pivot = this.head;
        while (pivot != null && pivot.getValue() != x){
            pivot = pivot.getNext();
        }

        return pivot;
    }

    public void insert(int position, int new_elem){
        Node new_node = new Node(new_elem);

        if(this.size == 0){
            this.head = new_node;
        }else{
            Node pivot = this.head;
            if(position == 0){
                new_node.setNext(this.head);
                this.head = new_node;
            }else{
                for(int i = 0; i < position; i++){
                    pivot = pivot.getNext();
                }
                insert(pivot, new_node);
            }
        }
        this.size++;

    }

    public void insert(Node p, Node new_elem){
        if(p.getNext() == null){
            new_elem.setNext();
        }else{
            new_elem.setNext(p.getNext());
        }
        p.setNext(new_elem);
    }

    public void empty(){
        this.head.setNext(null);
    }

    public void print(){
        Node pivot = this.head;
        while(pivot != null){
            System.out.println(pivot.getValue() + " \n");
            pivot = pivot.getNext();
        }
        
    }

    public void remove(int value){
        if(this.size() == 0){
            return;
        }

        Node to_remove = null;
        if(this.head.getValue() == value){
            to_remove = this.head;
            this.head = this.head.getNext();
        }else{
            Node pivot = head;
            while(pivot.getNext() != null && pivot.getNext().getValue() != value){
                pivot = pivot.getNext();
            }
            to_remove = pivot.getNext();
            if(pivot.getNext() != null){
                pivot.setNext(pivot.getNext().getNext());
            }

        }
        this.size--;    
    }

    public int size(){
        return this.size;
    }

}

class Node{

    int value;

    Node next;

    Node(){

    }
    
    Node(int value){
        this.value = value;
        this.next = null;
    }

    Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setNext() {
        this.next = null;
    }
}


