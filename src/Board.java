import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String test = "audio";
        char[] correct = test.toCharArray();
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        board.printBoard();
        boolean won = false;
        while (board.getNumTries() != 5 && !won) {
            System.out.println();
            System.out.println("Make your guess: ");
            char[] guess = sc.nextLine().toCharArray();
            List<Square> row = board.getBoard().get(board.getNumTries());

            for (int i = 0; i < SquareTypes.NUMBER_OF_LETTERS_IN_EACH_ROW; i++) {
                char letter = guess[i];
                char correctLetter = correct[i];
                if(letter == correctLetter){
                    row.get(i).setSquare(SquareTypes.CORRECT);
                    if(board.isInEarlier(guess, letter, i) && board.numTimes(correct, letter) == 1 && row.get(board.indexOf(guess, letter)).getSquare() == SquareTypes.YELLOW) {
                        row.get(board.indexOf(guess, letter)).setSquare(SquareTypes.INCORRECT);
                    }
                }else if(board.contains(correct, letter) && !board.isInEarlier(correct,letter,i) && board.numTimes(correct, letter) == 1 && row.get(board.indexOf(guess, letter)).getSquare() != SquareTypes.YELLOW){
                    row.get(i).setSquare(SquareTypes.YELLOW);
                }else if(board.contains(correct, letter) && board.isInEarlier(correct,letter,i) && row.get(board.indexOf(guess, letter)).getSquare() != SquareTypes.CORRECT){
                    row.get(i).setSquare(SquareTypes.YELLOW);
                }
                else{
                    row.get(i).setSquare(SquareTypes.INCORRECT);
                }
            }


            board.setNumTries(board.getNumTries() + 1);
            int count = 0;
            for (Square s : row) {
                if (s.getSquare() == SquareTypes.INCORRECT || s.getSquare() == SquareTypes.YELLOW) break;
                else count++;
                if (count == 5) {
                    System.out.println("You got the word correct! Good job!");
                    won = true;
                    break;
                }
            }
            System.out.println();
            if (!won) board.printBoard();

        }
        if (!won) {
            System.out.println("You ran out of tries!\nThe word was: " + test);
        }
    }
}
