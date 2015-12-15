public class MagicBoard {
    private int[][] board;

    public MagicBoard() {
        board = new int[4][4];
        reset();
    }

    public void reset() {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                board[row][col] = 0;
    }

    public boolean win() {
        int winNum = 0;
        int tempSum = 0;
        //Determine winning number
        for (int col = 0; col < board.length; col++)
            winNum += board[0][col];

        if (winNum == 0)
            return false;

        //Check if all rows == winNum
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                tempSum += board[row][col];
            }
            if (tempSum != winNum)
                return false;
            tempSum = 0;
        }

        //check if all columns == winNum
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board.length; row++) {
                tempSum += board[row][col];
            }
            if (tempSum != winNum)
                return false;
            tempSum = 0;
        }

        //check if the L-R diagonal == winNum
        for (int i = 0; i < board.length; i++) {
            tempSum += board[i][i];
        }
        if (tempSum != winNum)
            return false;

        //check if the R-L diagonal == winNum
        tempSum = 0;
        int row = 0;
        for (int col = board.length - 1; col >= 0; col--) {
            tempSum += board[row][col];
            row++;
        }
        if (tempSum != winNum)
            return false;

        //if it has not returned false yet, it must be a magic square
        return true;
    }

    public String toString() {
        String result = "\n";
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                result += board[row][col];
                if (col < board.length - 1)
                    result += "-";
            }
            result += "\n";
        }
        return result;
    }

    public void placeNum(int num, int row, int col) {
        board[row - 1][col - 1] = num;
    }
}
