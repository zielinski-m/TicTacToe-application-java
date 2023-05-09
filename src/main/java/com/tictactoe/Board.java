package com.tictactoe;

public class Board {
    String[][] boardGame;
    final int boardSize;

    public Board(int boardSize) {

        this.boardSize = boardSize;
        boardGame = new String[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boardGame[i][j] = "|";
            }
        }
    }

    public void createBoard() {

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(boardGame[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(Player player, int vertical, int horizontal) throws IllegalArgumentException {

        if ( vertical < 0 || vertical >= boardSize || horizontal < 0 || horizontal >= boardSize) {
            throw new IllegalArgumentException("Invalid move");
        }
        if (!boardGame[vertical][horizontal].equals("|")) {
            throw new IllegalArgumentException("Invalid move");
        }
        boardGame[vertical][horizontal] = player.getPlayerChar();
    }
}
