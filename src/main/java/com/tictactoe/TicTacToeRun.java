package com.tictactoe;

import java.util.Random;
import java.util.Scanner;
public class TicTacToeRun {

    Board board;
    Player player1;
    Player NPC;
    Player currentPlayer;
    private boolean gameOver;
    private Random random = new Random();

    public TicTacToeRun(Board board) {

        this.board = board;
        this.player1 = new Player("X");
        this.NPC = new Player("O");
        this.currentPlayer = player1;
        this.gameOver = false;
    }

    public int[] getRandomMove() {

        int[] move = new int[2];
        move[0] = random.nextInt(board.boardSize);
        move[1] = random.nextInt(board.boardSize);
        return move;
    }

    public void gameStart(Scanner scanner) {

        while (!gameOver) {
            board.createBoard();
            System.out.println("player " + currentPlayer.getPlayerChar() + ", make your move");

            if (currentPlayer == NPC) {
                int[] move = getRandomMove();
                while (board.boardGame[move[0]][move[1]].equals("X") || board.boardGame[move[0]][move[1]].equals("O")) {
                    move = getRandomMove();
                }
                System.out.println("NPC chooses " + (move[0] + 1) + " " + (move[1] + 1));
                board.makeMove(currentPlayer, move[0], move[1]);

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer.getPlayerChar() + " wins!");
                    board.createBoard();
                    gameOver = true;

                } else if (checkDraw()) {
                    System.out.println("It's a draw!");
                    board.createBoard();
                    gameOver = true;

                } else {
                    currentPlayer = (currentPlayer == player1 ? NPC : player1);
                }
            } else {
                String input = scanner.nextLine();
                String[] parts = input.split(",");
                int horizontal = Integer.parseInt(parts[0]) - 1;
                int vertical = Integer.parseInt(parts[1]) - 1;

                try {
                    board.makeMove(currentPlayer, horizontal, vertical);

                    if (checkWin()) {
                        System.out.println("Player " + currentPlayer.getPlayerChar() + " wins!");
                        board.createBoard();
                        gameOver = true;
                    } else {
                        currentPlayer = (currentPlayer == player1 ? NPC : player1);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public boolean checkWin() {

        int winCondition = 3;
        if (board.boardSize > 3) {
            winCondition = 5; // if board is bigger than 3 X 3
        }

        // check horizontal
        for (int i = 0; i < board.boardSize; i++) {
            int count = 0;
            String lastSymbol = "";
            for (int j = 0; j < board.boardSize; j++) {
                String currentSymbol = board.boardGame[i][j];
                if (!currentSymbol.equals("|")) {
                    if (currentSymbol.equals(lastSymbol)) {
                        count++;
                        if (count >= winCondition) {
                            return true;
                        }
                    } else {
                        count = 1;
                        lastSymbol = currentSymbol;
                    }
                } else {
                    count = 0;
                    lastSymbol = "";
                }
            }
        }

        // check vertical
         for (int j = 0; j < board.boardSize; j++) {
             int count = 0;
             String lastSymbol = "";
             for (int i = 0; i < board.boardSize; i++) {
                 String currentSymbol = board.boardGame[i][j];
                 if (!currentSymbol.equals("|")) {
                     if (currentSymbol.equals(lastSymbol)) {
                         count++;
                         if (count >= winCondition) {
                             return true;
                         }
                     } else {
                        count = 1;
                        lastSymbol = currentSymbol;
                     }
                 } else {
                    count = 0;
                    lastSymbol = "";
                }
            }
        }

         //check diagonals
         int count = 0;
         String lastSymbol = "";
         for (int i = 0; i < board.boardSize; i++) {
             String currentSymbol = board.boardGame[i][i];
             if (!currentSymbol.equals("|")) {
                 if (currentSymbol.equals(lastSymbol)) {
                     count++;
                     if (count >= winCondition) {
                         return true;
                     }
                 } else {
                     count = 1;
                     lastSymbol = currentSymbol;
                 }
             } else {
                 count = 0;
                 lastSymbol = "";
             }
         }

         //check reverse diagonals
         count = 0;
         lastSymbol = "";
         for (int i = 0; i < board.boardSize; i++) {
             String currentSymbol = board.boardGame[i][board.boardSize - 1 - i];
             if (!currentSymbol.equals("|")) {
                 if (currentSymbol.equals(lastSymbol)) {
                     count++;
                     if (count >= winCondition) {
                         return true;
                     }
                 } else {
                    count = 1;
                    lastSymbol = currentSymbol;
                 }
             } else {
                count = 0;
                lastSymbol = "";
             }
         }
         return false;
    }

    public boolean checkDraw() {

        for (int row = 0; row < board.boardGame.length; row++) {
            for (int col = 0; col < board.boardGame[row].length; col++) {
                if (board.boardGame[row][col].equals("|")) {
                    return false;
                }
            }
        }
        return true;
    }
}
