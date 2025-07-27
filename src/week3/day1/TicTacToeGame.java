package week3.day1;

import java.util.Scanner;
import week2.day13.WinCheck;

public class TicTacToeGame {

    public static void updateBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.print(board[i][0] + "|" + board[i][1] + "|" + board[i][2]);
            System.out.println();
            if (i < 2) {
                System.out.println("-+-+-");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char playAgain;

        do {
            char[][] board = new char[3][3];
            int row, column;
            int turn = 0;

            // Initialize board
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }

            updateBoard(board);

            while (true) {
                System.out.println("Enter row number 1-3: ");
                row = input.nextInt() - 1;
                System.out.println("Enter column number 1-3: ");
                column = input.nextInt() - 1;

                if (row >= 0 && row < 3 && column >= 0 && column < 3) {
                    if (board[row][column] == ' ') {
                        char currentPlayer = (turn % 2 == 0) ? 'X' : 'O';
                        board[row][column] = currentPlayer;
                        turn++;
                        updateBoard(board);

                        boolean result = WinCheck.checkWinner(board);
                        if (result) {
                            System.out.println("Player " + (currentPlayer == 'X' ? "1" : "2") + " wins!");
                            break;
                        }

                        if (turn == 9) {
                            System.out.println("Draw!");
                            break;
                        }

                    } else {
                        System.out.println("Cell already occupied. Try again.");
                    }

                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            }

            // Ask to play again AFTER game ends
            System.out.print("Play again? (y/n): ");
            playAgain = input.next().toLowerCase().charAt(0);

        } while (playAgain == 'y');

        input.close();
    }
}