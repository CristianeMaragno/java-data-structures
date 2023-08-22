import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class KnapsackProblem {
    public static void main(String[] args){
        //get data
        List<String> items = getData();

        //sort data by utility and weight
        List<String> orderedItems = sortData(items);

        //Get max of values for the backpack capacity
        List<String> result = useBackback(Integer.parseInt(items.get(items.size() - 1)), orderedItems);

        //Print result
        for(String x: result){
            System.out.println(x);
        }
    }

    public static List<String> getData(){
        Scanner scanner = new Scanner(System.in);
        boolean newValues = true;
        List<String> items = new ArrayList<String>();

        while(newValues){
            String item = scanner.nextLine();  // Read user input
            if(item.equals("-1 -1 -1")){
                newValues = false;
            }else{
                items.add(item); 
            }
        }
        String item = scanner.nextLine(); //Get backpack total capacity  
        items.add(item);

        scanner.close();
        return items;
    } 

    public static List<String> sortData(List<String> items){
        int n = items.size();

        for(int i = 0; i < n-1; i++){
            int ind_max = i;
            for(int j = i+1; j < n - 1; j++){
                float currentItem = calculateImportance(items.get(j));
                float maxItem = calculateImportance(items.get(ind_max));
                if(currentItem > maxItem){
                    ind_max = j;
                }
            }

            String aux = items.get(i);
            items.set(i, items.get(ind_max));
            items.set(ind_max, aux);
        }

        return items;
    }

    public static float calculateImportance(String item){
        String[] itemList = item.split(" ");
        int use = Integer.parseInt(itemList[0]);
        int weight = Integer.parseInt(itemList[1]);
        float result = use/weight;
        System.out.println(result);
        return result;
    }

    public static List<String> useBackback(int capacity, List<String> items){
        List<String> result = new ArrayList<String>();
        boolean full = false;
        int used = 0;
        for(int i = 0; i < items.size() - 1; i++){
            String[] itemList = items.get(i).split(" ");
            int weight = Integer.parseInt(itemList[1]);
            int amount = Integer.parseInt(itemList[2]);
            int itemUsed = 0;
            for(int j = 1; j == amount; j++){
                boolean compared = used + weight > capacity;
                if(compared){
                    full = true;
                    break;
                }else{
                    used =+ weight;
                    itemUsed++;
                }
            }
            result.add(String.valueOf(itemUsed));
            if(full){
                break;
            }
        }
        return result;
    }
}
