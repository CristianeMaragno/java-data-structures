package sorting;

public class Selection {
    public static void main(String[] args){
        //Go through every position, find the smaller value and put in order at the begining of the array
        int[] vector = {2,7,1,4,6};

        int n = vector.length;
        for(int i = 0; i < n-1; i++){
            int ind_min = i;
            for(int j = i+1; j < n; j++){
                if(vector[j] < vector[ind_min]){
                    ind_min = j;
                }
            }

            int aux = vector[i];
            vector[i] = vector[ind_min];
            vector[ind_min] = aux;
        }

        //Print result
        for(int x: vector){
            System.out.println(x);
        }
    }
}
