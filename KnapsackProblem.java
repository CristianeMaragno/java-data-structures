import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class KnapsackProblem {

    public static int capacity;
    public static void main(String[] args){
        //get data
        List<Item> items = getData();

        //sort data by utility and weight
        List<Item> orderedItems = sortData(items);

        //Get max of values for the backpack capacity
        List<Item> result = useBackback(orderedItems);

        //Print result
        for(Item x: result){
            System.out.println(x.getIndex() + " " + x.getUsed());
        }
    }

    public static List<Item> getData(){
        Scanner scanner = new Scanner(System.in);
        boolean newValues = true;
        List<Item> items = new ArrayList<Item>();
        int index = 0;

        while(newValues){
            String item = scanner.nextLine();  // Read user input
            if(item.equals("-1 -1 -1")){
                newValues = false;
            }else{
                item = item.strip();
                String[] itemList = item.split(" ");
                int utility = Integer.parseInt(itemList[0]);
                int weight = Integer.parseInt(itemList[1]);
                int amount = Integer.parseInt(itemList[2]);
                float importance = (float) utility/weight; 
                Item newItem = new Item(utility, weight, amount, importance, index);
                items.add(newItem); 
                index++;
            }
        }
        capacity = scanner.nextInt();

        scanner.close();
        return items;
    }

    public static List<Item> sortData(List<Item> items){
        int j, i, pos_ult_inv, lim_dir, n = items.size();
        lim_dir = n;
        for (j = 0; j < n; j++) {
            pos_ult_inv = 0;
            for (i = 1; i < lim_dir; i++){
                if (items.get(i - 1).getImportance() < items.get(i).getImportance()) {
                    Item aux = items.get(i - 1);
                    items.set(i - 1, items.get(i));
                    items.set(i, aux);
                    pos_ult_inv = i;
                }
            }
            lim_dir = pos_ult_inv;
        }

        return items;
    }

    public static List<Item> useBackback(List<Item> items){
        List<Item> result = new ArrayList<Item>();
        int weightUsed = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            int itemUsed = 0;

            for(int j = 1; j <= item.getAmount(); j++){
                boolean compared = weightUsed + item.getWeight() <= capacity;
                if(compared){
                    weightUsed = weightUsed + item.getWeight();
                    itemUsed++;
                }
            }
            if(itemUsed != 0){
                item.setUsed(itemUsed);
                result.add(item);
            }
        }
        return result;
    }
}

class Item{

    int utility;

    int weight;

    int amount;

    float importance;

    int index;

    int used;

    public Item(int utility, int weight, int amount, float importance, int index){
        this.utility = utility;
        this.weight = weight;
        this.amount = amount;
        this.importance = importance;
        this.index = index;
    }

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getImportance() {
        return importance;
    }

    public void setImportance(float importance) {
        this.importance = importance;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

}