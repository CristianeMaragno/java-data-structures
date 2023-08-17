package sorting;

public class Insertion {
    public static void main(String[] args){
        //Get the first value and go through the rest to find the item's right position 
        int[] vector = {3,7,1,5,4,3,8};

        int n = vector.length;
        int pivot = vector[0]; 
        int j = 0;
        for(int i = 1; i < n; i++) {
            pivot = vector[i];
            j = i - 1;
            
            while (j >= 0 && vector[j] > pivot) {
                vector[j+1] = vector[j];
                j--;
            }
            vector[j+1] = pivot; 
        }

        //Print result
        for(int x: vector){
            System.out.println(x);
        }
    }
}