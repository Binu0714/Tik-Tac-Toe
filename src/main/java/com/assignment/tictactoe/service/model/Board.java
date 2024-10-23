package com.assignment.tictactoe.service.model;

public interface Board {
    BoardUi getBoardUI();
    void initializeBoard();
    boolean isLegalMove(int row, int col);
    void updateMove(int row, int col, Piece piece);
    Winner checkWinner();
    void printBoard();
}
