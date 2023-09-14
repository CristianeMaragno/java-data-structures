public class Queue {

    int[] fila;

    int first;

    int last;

    int size;

    public static void main(String[] args){

    }

    Queue(int size){
        first = 0;
        last = 0;
        size = size;
    }

    public void push(int value){
        if(!isFull()){
            fila[last] = value;
            last = (last + 1) % size;
        }
    }

    public void pop(){
        first = (first + 1) % size;
    }

    public int front(){
        return fila[first];
    }

    public int back(){
        if(last == 0){
            return fila[size -1];
        }else{
            return fila[last-1];
        }
    }

    public boolean isFull(){
        return (last + 1) % size == first;
    }

    public boolean empty(){
        return first == last;
    }

    public int size(){
        if(last > first){

        }else{
            
        }
    }
}
