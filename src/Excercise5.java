import java.util.Scanner;

public class Excercise5 {
    public static void main(String[] args) {
        char[] board = {'_', '_', '_', '_', '_', '_', '_', '_', '_'};

        int placeUser1;
        int placeUser2;
        boolean checkWinner = false;
        boolean checkBoard;

        System.out.println("Welcome to the Tic-Tac-Toe Circle game");
        printBoard(board);
        do {
            System.out.println("User number 1 You can insert the X mark");
            placeUser1 = getPostionFromUser(board);
            checkWinner = placeSymbolOnBoard(board, placeUser1, 'x');
            checkBoard = checkAvailableBoard(board);
            if (!checkWinner && checkBoard) {
                System.out.println("User number 2 You can insert the 0 mark");
                placeUser2 = getPostionFromUser(board);
                checkWinner = placeSymbolOnBoard(board, placeUser2, '0');
            }
        } while (!checkWinner && checkBoard);
        if (!checkBoard) {
            System.out.println("There is no more room on the board - there are no winners");
        } else if (checkWinner(board) == 'x') {
            System.out.println("User number 1 You are the winner!");
        } else System.out.println("User number 2 You are the winner!");
    }

    public static void printBoard(char[] board) {

        System.out.println(board[0] + " " + board[1] + " " + board[2]);
        System.out.println(board[3] + " " + board[4] + " " + board[5]);
        System.out.println(board[6] + " " + board[7] + " " + board[8]);

    }

    public static boolean isAvailable(char[] board, int position) {
        boolean checkvailable;
        if (board[position] == '0' || board[position] == 'x') {
            checkvailable = false;
        } else checkvailable = true;
        return checkvailable;
    }

    public static int getPostionFromUser(char[] board) {
        boolean check = false;
        int number;
        Scanner Scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter a number between 1-9:");
            number = Scanner.nextInt();
            if (number < 1 || number > 9) {
                System.out.println("The number is not Between between 1-9!");
            } else {
                number = number - 1;
                if (!isAvailable(board, number)) {
                    System.out.println("The position is not available !");
                } else {
                    System.out.println("The position is available!");
                    check = true;
                }
            }
        } while (!check);
        return number;
    }

    public static char checkWinner(char[] board) {
        char check = '-';
        for (int i = 0; i < board.length - 2; i++) {
            if (board[i] == board[i + 1] && board[i + 1] == board[i + 2] && board[i + 2] == 'x') {
                check = 'x';
            } else {
                if (board[i] == board[i + 1] && board[i + 1] == board[i + 2] && board[i + 2] == '0')
                    check = '0';
            }
            i++;
            i++;
        }
        if (check == '-') {
            for (int t = 0; t < 3; t++) {
                if (board[t] == board[t + 3] && board[t + 3] == board[t + 6] && board[t + 6] == '0') {
                    check = '0';
                } else if (board[t] == board[t + 3] && board[t + 3] == board[t + 6] && board[t + 6] == 'x')
                    check = 'x';
            }
        }
        if (check == '-') {
            if (board[0] == board[4] && board[4] == board[8] && board[8] == '0') {
                check = '0';
            } else if (board[0] == board[4] && board[4] == board[8] && board[8] == 'x') {
                check = 'x';
            }
            if (board[2] == board[4] && board[4] == board[6] && board[6] == '0') {
                check = '0';
            } else if (board[2] == board[4] && board[4] == board[6] && board[6] == 'x') {
                check = 'x';
            }
        }
        return check;
    }

    public static boolean placeSymbolOnBoard(char[] board, int place, char sign) {
        boolean checkWinner = false;
        board[place] = sign;
        printBoard(board);
        if (checkWinner(board) == '0' || checkWinner(board) == 'x') {
            checkWinner = true;
        }
        return checkWinner;
    }

    public static boolean checkAvailableBoard(char[] board) {
        boolean checkBoard = false;
        for (int i = 0; i < board.length; i++) {
            checkBoard = isAvailable(board, i);
            if (checkBoard) break;
        }
        return checkBoard;
    }
}