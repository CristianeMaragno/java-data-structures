import java.util.ArrayList;
import java.util.List;

import java.util.Scanner; 

public class BiggestIsland {

    public static void main(String[] args){
        //get data
        List<List<Integer>> map = getData();

        /*for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                System.out.println(map.get(i).get(j));
            }
        }*/

        //proccess data
        int result = findBiggestIsland(map);

        //print data
        System.out.println(result);
    }

    public static List<List<Integer>> getData(){
        List<List<Integer>> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        while(continueLoop){
            String item = scanner.nextLine();  // Read user input
            if(item.equals("-1")){
                continueLoop = false;
            }else{
                item = item.strip();
                String[] itemList = item.split("");
                List<Integer> row = new ArrayList<>();
                for (int i = 0; i < itemList.length; i++) {
                    row.add(Integer.parseInt(itemList[i]));
                }
                data.add(row);
            }
        }

        scanner.close();
        return data;
    }

    public static int findBiggestIsland(List<List<Integer>> map){
        LinkedStack stack = new LinkedStack<>();
        int result = 0;
        for (int i = 0; i < map.size(); i++) {
            int count = 0;
            for (int j = 0; j < map.get(i).size(); j++) {
                if(map.get(i).get(j) == 1){
                    map.get(i).set(j, -1);
                    count++;
                    stack.push(new Point(i, j+1));
                    stack.push(new Point(i, j-1)); //Problem with out of bounds
                    stack.push(new Point(i+1, j));
                    stack.push(new Point(i-1, j));
                    while(!stack.empty()){
                        Point point = (Point) stack.top();
                        if(map.get(point.x).get(point.y) == 1){
                            count++;
                            map.get(point.x).set(point.y, -1);
                            stack.push(new Point(i, j+1));
                            stack.push(new Point(i, j-1)); //Problem with out of bounds
                            stack.push(new Point(i+1, j));
                            stack.push(new Point(i-1, j));
                        }
                        stack.pop();
                    }

                    if(count > result){
                        result = count;
                    }
                }
                //System.out.println(map.get(i).get(j));
            }
        }

        return result;
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
