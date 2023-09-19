public class CircularQueue {

    int[] queue;

    int topOfQueue;

    int beginningOfQueue;

    int size;

    public static void main(String[] args){

    }

    CircularQueue(int size){
        queue = new int[size];
        topOfQueue = -1;
        beginningOfQueue = -1;
        this.size = size;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("The Queue is full!");
        }else if(empty()){
            beginningOfQueue = 0;
            topOfQueue++;
            queue[topOfQueue] = value;
        }else{
            if (topOfQueue + 1 == size) {
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            queue[topOfQueue] = value;
        }
    }

    public void pop(){
        if (empty()) {
            System.out.println("The Queue is Empty!");
        } else {
            if (beginningOfQueue == topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            } else if (beginningOfQueue + 1 == size) {
                beginningOfQueue = 0;
            } else {
                beginningOfQueue++;
            }
        }
    }

    public int front(){
        return queue[beginningOfQueue];
    }

    public boolean isFull(){
        if (topOfQueue + 1 == beginningOfQueue) {
            return true;
        } else
            return topOfQueue == size - 1 && beginningOfQueue == 0;
    }

    public boolean empty(){
        return beginningOfQueue == -1;
    }

    public int size(){
        return this.size(); //Size of total array, not the parts being used
    }
}
