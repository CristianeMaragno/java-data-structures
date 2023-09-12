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

        for(int i = 18; i > 10; i = i -2){
            linked.remove(i);
        }

        linked.print();

    }

    public Node find(int x){
        Node pivot = this.head;
        while (pivot != null && pivot.value != x){
            pivot = pivot.next;
        }

        return pivot;
    }

    public void insert(int position, int new_elem){
        Node new_node = new Node(new_elem);

        if(this.head == null){
            this.head = new_node;
        }else{
            if(position == 0){
                new_node.next = this.head;
                this.head = new_node;
            }else{
                Node pivot = this.head;
                for(int i = 0; i < position -1; i++){
                    pivot = pivot.next;
                }
                new_node.next = pivot.next;
                pivot.next = new_node;
            }
        }
        this.size++;

    }

    public void empty(){
        this.head.next = null;
    }

    public void print(){
        Node pivot = this.head;
        while(pivot != null){
            System.out.println(pivot.value + " \n");
            pivot = pivot.next;
        }
        
    }

    public void remove(int value){
        if(this.size() == 0){
            return;
        }

        if(this.head.value == value){
            this.head = this.head.next;
        }else{
            Node pivot = head;
            while(pivot.next != null && pivot.next.value != value){
                pivot = pivot.next;
            }
            if(pivot.next != null){
                pivot.next = pivot.next.next;
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

}


