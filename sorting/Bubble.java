package sorting;

public class Bubble {

    public static void main(String[] args){
        //Create data
        int[] vector = {7,1,4,5,8,6,4};

        simpleSort(vector);
        optimizedSort(vector);
    }

    public static void simpleSort(int[] vector){
        int n = vector.length;
        int i;
        boolean changed;

        do {
            changed = false;
            for (i = 1; i < n; i++)
                if (vector[i - 1] > vector[i]) {
                    int aux = vector[i - 1];
                    vector[i - 1] = vector[i];
                    vector[i] = aux;
                    changed = true;
                }
        } while (changed);

        //Print result
        for(int x: vector){
            System.out.println(x);
        }
    }

    public static void optimizedSort(int[] vector){
        int j, i, pos_ult_inv, lim_dir, n = vector.length;
        lim_dir = n;
        for (j = 0; j < n; j++) {
            pos_ult_inv = 0;
            for (i = 1; i < lim_dir; i++){
                if (vector[i - 1] > vector[i]) {
                    int aux = vector[i - 1];
                    vector[i - 1] = vector[i];
                    vector[i] = aux;
                    pos_ult_inv = i;
                }
            }
            lim_dir = pos_ult_inv;
        }

        //Print result
        for(int x: vector){
            System.out.println(x);
        }
    }
}
