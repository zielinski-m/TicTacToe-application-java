package com.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeAppTests {

        @Test
        public void testWinRowsForO() {

            //Given
            TicTacToeRun game = new TicTacToeRun(new Board(10));
            Board board = game.board;
            Player player = game.NPC;
            int boardSize = board.boardSize;
            int winCondition = 3;
            if (boardSize > 3) {
                winCondition = 5;
            }

            //When
                //First row
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, 0, i);
            }

                //Last row
            board = new Board(boardSize);
            player = new Player("O");
            game = new TicTacToeRun(board);
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, 9, i);
            }

            //Then
            assertTrue(game.checkWin());
        }

        @Test
        public void testWinColumnsForO() {

            //Given
            TicTacToeRun game = new TicTacToeRun(new Board(3));
            Board board = game.board;
            Player player = game.NPC;
            int boardSize = board.boardSize;
            int winCondition = 3;
            if (boardSize > 3) {
                winCondition = 5;
            }

            //When
                //First column
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, i, 0);
            }

                // Third column
            board = new Board(boardSize);
            player = new Player("O");
            game = new TicTacToeRun(board);
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, i, 2);
            }

            //Then
            assertTrue(game.checkWin());
        }

        @Test
        public void testWinDiagonalForO() {

            //Given
            TicTacToeRun game = new TicTacToeRun(new Board(3));
            Board board = game.board;
            Player player = game.NPC;
            int boardSize = board.boardSize;
            int winCondition = 3;
            if (boardSize > 3) {
                winCondition = 5;
            }

            //When
                //Diagonal direction
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, i, i);
            }

                //Reverse diagonal direction
            board = new Board(boardSize);
            player = new Player("O");
            game = new TicTacToeRun(board);
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, i, boardSize - i - 1);
            }

            //Then
            assertTrue(game.checkWin());

        }

        @Test
        public void testWinRowsForX() {

            //Given
            TicTacToeRun game = new TicTacToeRun(new Board(5));
            Board board = game.board;
            Player player = game.player1;
            int boardSize = board.boardSize;
            int winCondition = 3;
            if (boardSize > 3) {
                winCondition = 5;
            }

            //When
                //First row
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, 0, i);
            }

                //Fifth row
            board = new Board(boardSize);
            player = new Player("X");
            game = new TicTacToeRun(board);
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, boardSize - 1, i);
            }

            //Then
            assertTrue(game.checkWin());
        }

        @Test
        public void testWinColumnsForX() {

            //Given
            TicTacToeRun game = new TicTacToeRun(new Board(5));
            Board board = game.board;
            Player player = game.player1;
            int boardSize = board.boardSize;
            int winCondition = 3;
            if (boardSize > 3) {
                winCondition = 5;
            }

            //When
                //First column
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, i, 0);
            }

                // Third column
            board = new Board(boardSize);
            player = new Player("X");
            game = new TicTacToeRun(board);
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, i, 3);
            }

            //Then
            assertTrue(game.checkWin());
        }
        @Test
        public void testWinDiagonalForX() {

            //Given
            TicTacToeRun game = new TicTacToeRun(new Board(3));
            Board board = game.board;
            Player player = game.player1;
            int boardSize = board.boardSize;
            int winCondition = 3;
            if (boardSize > 3) {
                winCondition = 5;
            }

            //When
                // Diagonal direction
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, i, i);
            }

                // Reverse diagonal direction
            board = new Board(boardSize);
            player = new Player("X");
            game = new TicTacToeRun(board);
            for (int i = 0; i < winCondition; i++) {
                board.makeMove(player, i, boardSize - i - 1);
            }

            //Then
            assertTrue(game.checkWin());
        }
        @Test
        public void testCheckDraw() {

            //Given
            TicTacToeRun game = new TicTacToeRun(new Board(3));
            Board board = game.board;
            Player player = game.NPC;
            int boardSize = board.boardSize;
            int winCondition = 3;
            if (boardSize > 3) {
                winCondition = 5;
            }

            //When
            for (int i = 0; i < board.boardSize; i++) {
                for (int j = 0; j < board.boardSize; j++) {
                    if ((i + j) % 2 == 0) {
                        board.makeMove(player, i, j);
                    } else {
                        player = game.player1;
                        board.makeMove(player, i, j);
                    }
                }
            }

            //Then
            assertTrue(game.checkDraw());
        }

        @Test
        public void testInvalidMove() {

            //Given
            TicTacToeRun game = new TicTacToeRun(new Board(3));
            Board board = game.board;
            Player player = game.NPC;
            int boardSize = board.boardSize;
            int winCondition = 3;
            if (boardSize > 3) {
                winCondition = 5;
            }

            //When
            assertThrows(IllegalArgumentException.class, () -> board.makeMove(player, -1, -1));
            assertThrows(IllegalArgumentException.class, () -> board.makeMove(player, 3, 3));
            assertThrows(IllegalArgumentException.class, () -> board.makeMove(player, -1, 2));
            assertThrows(IllegalArgumentException.class, () -> board.makeMove(player, 0, 4));
        }
}


