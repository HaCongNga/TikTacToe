

public class Board {


    private static final int SIZE = 3;
    private static final int MAX_VALUE = 30;

    /**
     * 3x3 cells in board
     */
    private final Cell[][] cells = new Cell [SIZE][SIZE];

    /**Init board
     */
    public Board(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                cells[i][j] = new Cell ();
                cells[i][j].getStatus();
            }
        }
    }
    /** Choose a cell */
    public boolean choose (int row, int col, CellStatus _status){
        if (cells[row][col].getStatus() == CellStatus.EMPTY){
            cells[row][col].setStatus(_status);
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Check if game over
     * @return true if game over, false if otherwise
     */
    public boolean check ()  {
        if (!isNotFull()){
            return true;
        }
        if (findWinner() == CellStatus.X || findWinner() == CellStatus.O){
            return true;
        }
        return false;
    }

    private boolean isNotFull()  {
        for (int i = 0; i  < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].getStatus() == CellStatus.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Print board
     * Ex:
     * [][][]
     * [X][O][]
     * [][][]
     */
    public void print() {
        for (int i = 0; i  < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].getStatus() == CellStatus.EMPTY) {
                    System.out.print("[ ] ");
                }
                else if (cells[i][j].getStatus() == CellStatus.X)  {
                    System.out.print("[X] ");
                }
                else{
                    System.out.print("[O] ");
                }
            }
            System.out.println();
        }

    }

    public CellStatus findWinner(){
        if (cells[0][0].getStatus() == cells[0][1].getStatus() && cells[0][1].getStatus() == cells[0][2].getStatus() && cells[0][1].getStatus() == CellStatus.X ){
            return CellStatus.X;
        }
        else if (cells[0][0].getStatus() == cells[0][1].getStatus() && cells[0][1].getStatus() == cells[0][2].getStatus() && cells[0][1].getStatus() == CellStatus.O){
            return CellStatus.X;
        }
        else if (cells[1][0].getStatus() == cells[1][1].getStatus() && cells[1][1].getStatus() == cells[1][2].getStatus() && cells[1][1].getStatus() == CellStatus.X){

            return CellStatus.X;
        }
        else if (cells[1][0].getStatus() == cells[1][1].getStatus() && cells[1][1].getStatus() == cells[1][2].getStatus() && cells[1][1].getStatus() == CellStatus.O){
            return CellStatus.O;
        }
        else if  (cells[2][0].getStatus() == cells[2][1].getStatus() && cells[2][1].getStatus() == cells[2][2].getStatus()){
            if (cells[2][0].getStatus() == CellStatus.X)  {
                return CellStatus.X;
            }
            else if (cells[2][0].getStatus() == CellStatus.O)return CellStatus.O;
        }
        else if (cells[0][0].getStatus() == cells[1][0].getStatus() && cells[1][0].getStatus() == cells[2][0].getStatus()){
            if (cells[1][0].getStatus() == CellStatus.O){
                return CellStatus.O;
            }
            else if (cells[1][0].getStatus() == CellStatus.X)return CellStatus.X;
        }
        else if (cells[0][1].getStatus() == cells[1][1].getStatus() && cells[1][1].getStatus() == cells[2][1].getStatus()){
            if (cells[1][1].getStatus() == CellStatus.O){
                return CellStatus.O;
            }
            else if (cells[1][1].getStatus() == CellStatus.X)return CellStatus.X;
        }
        else if (cells[0][2].getStatus() == cells[1][2].getStatus() && cells[1][2].getStatus() == cells[2][2].getStatus()){
            if (cells[1][2].getStatus() == CellStatus.O){
                return CellStatus.O;
            }
            else if (cells[1][2].getStatus() == CellStatus.X) return CellStatus.X;
        }
        else if (cells[0][0].getStatus() == cells[1][1].getStatus() && cells[1][1].getStatus() == cells[2][2].getStatus()){
            if (cells[1][1].getStatus() == CellStatus.X){
                return CellStatus.X;
            }
            else if (cells[1][1].getStatus() == CellStatus.O)return CellStatus.O;
        }
        else if (cells[0][2].getStatus() == cells[1][1].getStatus() && cells[1][1].getStatus() == cells[2][0].getStatus()){
            if (cells[1][1].getStatus() == CellStatus.X){
                return CellStatus.X;
            }
            else if (cells[1][1].getStatus() == CellStatus.O){
                return CellStatus.O;
            }
        }
         return CellStatus.EMPTY;

    }
}
