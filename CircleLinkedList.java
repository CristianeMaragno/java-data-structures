class CircleLinkedList<E>{

    private Node<E> head;

    private int size;

    public CircleLinkedList(){
        this.size = 0;
    }

    public static void main(String[] args){
        CircleLinkedList linked = new CircleLinkedList();
        for(int i = 0; i < 10; i++){
            linked.insert(i, i*2);
        }
        linked.print();

        for(int i = 18; i > 10; i = i -2){
            linked.remove(i);
        }

        linked.print();

    }

    public Node<E> find(E value){
        Node<E> pivot = this.head;
        while (pivot.value != null && pivot.value != value){
            pivot = pivot.next;
        }

        return pivot;
    }

    public E findByIndex(int position){
        Node<E> pivot = this.head;

        for(int i = 0; i < position; i++){
            pivot = pivot.next;
        }

        return pivot.value;
    }

    public void insert(int position, E new_elem){
        Node<E> new_node = new Node(new_elem);
        if(this.size == 0){
            this.head = new_node;
            this.head.next = this.head;
        }else{
            if(position == 0){
                new_node = this.head;
                this.head = new_node;
            }else{
                Node<E> pivot = this.head;
                for(int i = 0; i < position - 1; i++){
                    pivot = pivot.next;
                }
                new_node.next = pivot.next;
                pivot.next = new_node;
            }
        }
        this.size++;

    }

    public void swap(E value){
        Node<E> node = find(value);
        Node<E> nodeToSwap = node.next;
        Node<E> secondNodeToSwap = node.next.next;
        node.next = secondNodeToSwap;
        nodeToSwap.next = secondNodeToSwap.next;
        secondNodeToSwap.next = nodeToSwap;
    }

    public void empty(){
        this.head.next = null;
    }

    public void print(){
        Node<E> pivot = this.head;
        boolean continueLoop = true;
        while(continueLoop){
            System.out.println(pivot.value + " \n");
            pivot = pivot.next;
            continueLoop = (pivot != this.head);
        }
        
    }

    public void remove(E value){
        if(this.size() == 0){
            return;
        }

        if(this.head.value == value){
            this.head = this.head.next;
        }else{
            Node<E> pivot = head;
            while(pivot.next != this.head && pivot.next.value != value){
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

class Point{

    int x;

    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}