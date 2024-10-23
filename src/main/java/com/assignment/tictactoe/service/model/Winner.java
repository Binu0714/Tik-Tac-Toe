package com.assignment.tictactoe.service.model;

public class Winner {
    private Piece winnerPiece;

    int col1 , row1 , col2, row2, col3, row3;

    public Winner(Piece winnerPiece, int col1, int row1, int col2, int row2, int col3, int row3) {
        this.winnerPiece = winnerPiece;
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
        this.col3 = col3;
        this.row3 = row3;
    }

    public Piece getWinnerPiece() {
        return winnerPiece;
    }
}
