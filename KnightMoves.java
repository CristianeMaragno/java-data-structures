import java.util.List;
import java.util.ArrayList;
import java.util.Scanner; 
import java.util.Queue; 
import java.util.ArrayDeque;

public class KnightMoves {

    public int[] coodinates = {2, 1, 1, 2, -1, 2, -2, 1, -2, -1, -1, -2, 1, -2, 2, -1};

    public static void main(String[] args){
        KnightMoves knightMoves = new KnightMoves();
        //get input
        List<Square> squares = knightMoves.getData();

        //get knight path length
        int moves = knightMoves.get_knight_path_length(squares.get(0), squares.get(1));

        //Print solution
        System.out.println("Movimentos: " + moves);
    }

    public List<Square> getData(){
        List<Square> data = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        String[] startList = start.split("");
        Square startSquare = new Square(Integer.parseInt(startList[1]) - 1, getCoodinateCode(startList[0]));
         
        String destination = scanner.nextLine();
        String[] destinationList = destination.split("");
        Square destinationSquare = new Square(Integer.parseInt(destinationList[1]) - 1, getCoodinateCode(destinationList[0]));
         
        data.add(startSquare);
        data.add(destinationSquare);
        scanner.close();
        return data;
    }

    public int getCoodinateCode(String coodinate){
        switch(coodinate) {
            case "a":
              return 0;
            case "b":
              return 1;
            case "c":
              return 2;
            case "d":
              return 3;
            case "e":
              return 4;
            case "f":
              return 5;
            case "g":
              return 6;
            case "h":
              return 7;
            default:
              return 0;
          }
    }

    public int get_knight_path_length(Square origin, Square destination){
        int count = 0;
        Queue<Square> queue = new ArrayDeque<>();
        ChessBoard board = new ChessBoard();

        if(origin.row == destination.row && origin.col == destination.col){
            count = 0;
        }else{
            queue = getNextSquares(origin, board, queue); 
            while(!queue.isEmpty()){
                Square selectedSquare = queue.poll();
                if(selectedSquare.row == destination.row && selectedSquare.col == destination.col){
                    count = board.getValue(selectedSquare.row, selectedSquare.col);
                    break;
                }else{
                    queue = getNextSquares(selectedSquare, board, queue);
                }
            }
        }
        return count;
    }

    public Queue<Square> getNextSquares(Square origin, ChessBoard board, Queue<Square> queue){
        Square square;
        int value = board.getValue(origin.row, origin.col);
        value++;

        for(int i = 0; i < 15; i = i + 2){
            square = new Square(origin.row + coodinates[i], origin.col + coodinates[i + 1]);
            if(square_valid(square, board)){
                board.setValue(square.row, square.col, value);
                queue.add(square);
            }
        }
        return queue;
    }

    public boolean square_valid(Square s, ChessBoard board){
        int n = board.size();
        return s.row < n && s.col < n && s.row >= 0 && s.col >= 0;
    }

}

class Square{
    int row;
    int col;

    Square(int r, int c){
        row = r;
        col = c;
    }
}

class ChessBoard{
    private List<List<Integer>> board;
    private int size;

    ChessBoard(){
        board = new ArrayList<>();
        this.size = 8;
        fill(0);
    }

    public int size(){
        return this.size;
    }

    public List<Integer> operator(int i){
        return this.board.get(i);
    }

    public void fill(int value){
        for (int i = 0; i < this.size(); i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < this.size () ; j++) {
                row.add(value);
            }
            this.board.add(row);
        }
    }

    public void setValue(int row, int col, int value){
        this.board.get(row).set(col, value);
    }

    public int getValue(int row, int col){
        return this.board.get(row).get(col);
    }
}