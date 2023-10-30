import java.util.Scanner; 
import java.util.Arrays;

public class HashTable {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    input = input.strip();
    int vectorSize = Integer.parseInt(input);
    String[] vector = new String[vectorSize];
    Arrays.fill(vector, "-1");

    String operation = "";
    while(!operation.equals("-1")){
      operation = scanner.nextLine();
      operation = operation.strip();
      if(operation.equals("-1")) break;
      input = scanner.nextLine(); //waits for this too
      input = input.strip();

      //Hash function is hash(s) = len(s) % m.
      int stringLength = input.length();
      int hashPostion = (stringLength) % vectorSize;
      if(operation.equals("0")){
        int availablePosition = searchAvailablePosition(hashPostion, vector);
        vector[availablePosition] = input;
      }
      if(operation.equals("1")){
        int removePosition = searchRemovePosition(hashPostion, vector, input);
        vector[removePosition] = "-2";
      }
    }

    scanner.close();

    //Print resulting vector
    for(String x : vector){
      System.out.println(x);
    }
  }

  public static int searchAvailablePosition(int hashPostion, String[] vector){
    for(int i = hashPostion; i < vector.length; i++){
      if(vector[i].equals("-1") || vector[i].equals("-2")){
        return i;
      }
    }
    
    for(int i = 0; i < hashPostion; i++){
      if(vector[i].equals("-1") || vector[i].equals("-2")){
        return i;
      }
    }

    return 0;
  }

  public static int searchRemovePosition(int hashPostion, String[] vector, String removeString){
    for(int i = hashPostion; i < vector.length; i++){
      if(vector[i].equals(removeString)){
        return i;
      }
    }
    
    for(int i = 0; i < hashPostion; i++){
      if(vector[i].equals(removeString)){
        return i;
      }
    }

    return 0;
  }
}
