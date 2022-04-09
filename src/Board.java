import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Square>> board;
    private int numTries;

    public Board() {
        numTries = 0;
        board = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            List<Square> row = new ArrayList<>();
            for (int j = 0; j < SquareTypes.NUMBER_OF_LETTERS_IN_EACH_ROW; j++) {
                row.add(new Square(SquareTypes.DEFAULT));
            }
            board.add(row);
        }

    }

    public List<List<Square>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Square>> board) {
        this.board = board;
    }

    public int getNumTries() {
        return numTries;
    }

    public void setNumTries(int numTries) {
        this.numTries = numTries;
    }

    public int indexOf(char[] j, char i) {
        for (int e = 0; e < j.length; e++) {
            if (j[e] == i) return e;
        }
        return -1;
    }

    public int numTimes(char[] i, char t){
        int count = 0;
        for(char e : i){
            if(t == e) count++;
        }
        return count;
    }

    public void printBoard() {
        getBoard().forEach(row -> {
            for (Square square : row) {
                System.out.print(square.getSquare());
            }
            System.out.println();
        });
    }

    public boolean contains(char[] row, char letter) {
        for (char e : row) {
            if (e == letter) return true;
        }
        return false;
    }

    public boolean isInEarlier(char[] arr, char e, int current){
        if(current == 0){
            for(int i = current + 1; i < arr.length; i++){
                if(arr[i] == e){
                    return true;
                }
            }
        }
        else{
            for(int i = current - 1; i >= 0; i--){
                if(arr[i] == e){
                    return true;
                }
            }
            for(int i = current + 1; i < arr.length; i++){
                if(arr[i] == e){
                    return true;
                }
            }
        }
        return false;
    }

}
