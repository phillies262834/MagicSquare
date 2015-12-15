import java.util.Scanner;

public class MagicSqaureApp {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        MagicBoard board = new MagicBoard();

        System.out.println(board);

        while(board.win() == false){
            System.out.println("Enter the number, row, and column (number <space> row <space> col <enter>):");

            int num = reader.nextInt();
            int row = reader.nextInt();
            int col = reader.nextInt();
            board.placeNum(num, row, col);

            System.out.print(board);
        }

        if(board.win() == true)
            System.out.println("Congratulations you win!");
    }
}
