package consoleGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    private static int player = 0;
    static char[][] battleFront = new char[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        preSet();
        print();
        handleMove();
        scanner.close();
    }

        public static void preSet(){
            for (int i = 0; i < battleFront.length; i++) {
                for (int j = 0; j < battleFront.length; j++) {
                    battleFront[i][j] = ' ';
                }
            }
        }

    public static void print() {
        System.out.println("---------\n" +
                "| " + battleFront[0][0] + " " + battleFront[0][1] + " " + battleFront[0][2] + " |\n" +
                "| " + battleFront[1][0] + " " + battleFront[1][1] + " " + battleFront[1][2] + " |\n" +
                "| " + battleFront[2][0] + " " + battleFront[2][1] + " " + battleFront[2][2] + " |\n" +
                "---------");
    }

    public static boolean handleMove() {

        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        int input1 = 0;
        int input2 = 0;
        while (!end) {
        try {
            System.out.print("Enter the coordinates: ");
            input1 = scanner.nextInt();
            input2 = scanner.nextInt();
                if (input1 < 1 || input1 > 3 || input2 < 1 || input2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (battleFront[input1 - 1][input2 - 1] == 'X' || battleFront[input1 - 1][input2 - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    if (player == 0) {
                        battleFront[input1 - 1][input2 - 1] = 'X';
                        player++;
                    } else if (player == 1) {
                        battleFront[input1 - 1][input2 - 1] = 'O';
                        player--;
                    }
                    print();
                }
                if (winX()) {
                    System.out.println("X wins");
                    end = true;
                    break;
                } else if (winO()) {
                    System.out.println("O wins");
                    end = true;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }
        }
        return end;
    }

    public static boolean winX() {
        return ('X' == battleFront[0][0] && 'X' == battleFront[0][1] && 'X' == battleFront[0][2]
                || 'X' == battleFront[1][0] && 'X' == battleFront[1][1] && 'X' == battleFront[1][2]
                || 'X' == battleFront[2][0] && 'X' == battleFront[2][1] && 'X' == battleFront[2][2]

                || 'X' == battleFront[0][0] && 'X' == battleFront[1][0] && 'X' == battleFront[2][0]
                || 'X' == battleFront[0][1] && 'X' == battleFront[1][1] && 'X' == battleFront[2][1]
                || 'X' == battleFront[0][2] && 'X' == battleFront[1][2] && 'X' == battleFront[2][2]

                || 'X' == battleFront[0][0] && 'X' == battleFront[1][1] && 'X' == battleFront[2][2]
                || 'X' == battleFront[0][2] && 'X' == battleFront[1][1] && 'X' == battleFront[2][0]);
    }

    public static boolean winO() {
        return ('O' == battleFront[0][0] && 'O' == battleFront[0][1] && 'O' == battleFront[0][2]
                || 'O' == battleFront[1][0] && 'O' == battleFront[1][1] && 'O' == battleFront[1][2]
                || 'O' == battleFront[2][0] && 'O' == battleFront[2][1] && 'O' == battleFront[2][2]

                || 'O' == battleFront[0][0] && 'O' == battleFront[1][0] && 'O' == battleFront[2][0]
                || 'O' == battleFront[0][1] && 'O' == battleFront[1][1] && 'O' == battleFront[2][1]
                || 'O' == battleFront[0][2] && 'O' == battleFront[1][2] && 'O' == battleFront[2][2]

                || 'O' == battleFront[0][0] && 'O' == battleFront[1][1] && 'O' == battleFront[2][2]
                || 'O' == battleFront[0][2] && 'O' == battleFront[1][1] && 'O' == battleFront[2][0]);
    }
}