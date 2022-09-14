import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //using scanner to read input from keyboard;
        Scanner scanner = new Scanner(System.in);

        // create a game board
        Board board = new Board();

        //X turn first
        boolean isXTurn = true;

        while (true) {
            CellStatus status;
            if (isXTurn) {
                System.out.println("X turn");
                status = CellStatus.X;
            } else {
                System.out.println("O turn");
                status = CellStatus.O;
            }

            //get cell position from keyboard
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean isValid = board.choose(row,col,status);
            if  (!isValid)  {
                System.out.println("Invalid, try again");
            }
            else{
                //swap turn
                isXTurn = !isXTurn;
            }

            //print board
            board.print();

            //check if game over
            boolean gameOver = board.check();
            if (gameOver){
                if (board.findWinner() == CellStatus.X){
                    System.out.println("X wins");
                }
                else if (board.findWinner() == CellStatus.O){
                    System.out.println("O wins");
                }
                else{
                    System.out.println("X and O draw");
                }
                break;
            }
        }
    }
}
