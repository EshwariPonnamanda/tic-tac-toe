public class Board{
    private static final int SIZE=3;
    private Cell[][] grid;

    public Board(){
        grid = new Cell[SIZE][SIZE];
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                grid[i][j] = new Cell();
            }
        }
    }

    public void printBoard(){
        System.out.println("\nCurrent Board:");
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                System.out.print(" "+ grid[i][j].getValue()+" ");
                if(j<SIZE-1) System.out.println("---+---+---");
            }
            System.out.println();
            if (i < SIZE - 1) System.out.println("---+---+---");
        }
    }

        public boolean placeSymbol(int row, int col, char symbol){
            if(row<0 || row>= SIZE || col<0 || col>=SIZE){
                return false;
            }
            if (!grid[row][col].isEmpty()) {
            System.out.println("Cell already taken!");
            return false;
        }
        grid[row][col].setValue(symbol);
        return true;
    }
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCellValue(int row, int col) {
        return grid[row][col].getValue();
    }
}