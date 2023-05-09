package com.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int polesNumber;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Enter number of poles. For example 3 or 10");
            try {
                polesNumber = Integer.parseInt(scan.nextLine());
                if (polesNumber < 3) {
                    System.out.println("Number of poles must be 3 or higher ");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again");
                continue;
            }

            System.out.println("To play TicTacToe please select number of the row then comma then number of column. For example 1,4");
            Board board = new Board(polesNumber);
            TicTacToeRun game = new TicTacToeRun(board);
            game.gameStart(scan);
            System.out.println("Do you want to play again? (yes/no)");
            String input = scan.nextLine().toLowerCase();

            while (!input.equals("yes") && !input.equals("no")) {
                System.out.println("Invalid input. Do you want to play again? (yes/no)");
                input = scan.nextLine().toLowerCase();
            }
            if (input.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }
    }
}


