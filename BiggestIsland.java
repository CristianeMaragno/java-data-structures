import java.util.ArrayList;
import java.util.List;

import java.util.Scanner; 

public class BiggestIsland {

    public static void main(String[] args){
        //get data
        List<List<Integer>> map = getData();

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
            if(item.isEmpty()){
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
            for (int j = 0; j < map.get(i).size(); j++) {
                if(map.get(i).get(j) == 1){
                    int count = 0;
                    int width = map.get(i).size();
                    map.get(i).set(j, -1);
                    count++;
                    if(j+1 < width && map.get(i).get(j+1) == 1){ //Problem with out of bounds //x ou i funciona comparar com size
                        stack.push(new Point(i, j+1));
                    }
                    if(j-1 >= 0 && map.get(i).get(j-1) == 1){
                        stack.push(new Point(i, j-1));
                    }
                    if(i+1 < map.size() && map.get(i+1).get(j) == 1){
                        stack.push(new Point(i+1, j));
                    }
                    if(i-1 >= 0 && map.get(i-1).get(j) == 1){
                        stack.push(new Point(i-1, j));
                    }
                    while(!stack.empty()){
                        Point point = (Point) stack.top();
                        stack.pop();
                        if(map.get(point.x).get(point.y) == 1){ //not needed?
                            count++;
                            map.get(point.x).set(point.y, -1);
                            if(point.y+1 < width && map.get(point.x).get(point.y+1) == 1){
                                stack.push(new Point(point.x, point.y+1));
                            }
                            if(point.y-1 >= 0 && map.get(point.x).get(point.y-1) == 1){
                                stack.push(new Point(point.x, point.y-1));
                            }
                            if(point.x+1 < map.size() && map.get(point.x+1).get(point.y) == 1){
                                stack.push(new Point(point.x+1, point.y));
                            }
                            if(point.x-1 >= 0 && map.get(point.x-1).get(point.y) == 1){
                                stack.push(new Point(point.x-1, point.y));
                            }
                        }
                    }
                    if(count > result){
                        result = count;
                    }
                }
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
