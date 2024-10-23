package com.assignment.tictactoe.service.controller;

import com.assignment.tictactoe.service.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;

public class BoardController implements BoardUi {
    private HumanPlayer humanPlayer;
    private AiPlayer aiPlayer;
    private BoardImpl board;

    @FXML
    private Label AiScore;

    @FXML
    private Label HumanScore;

    @FXML
    private Label TieScore;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    private int humanScore = 0;
    private int aiScore = 0;
    private int tieScore = 0;

    public BoardController() {
        board = new BoardImpl(this);
        humanPlayer = new HumanPlayer(board);
        aiPlayer = new AiPlayer(board);
    }

    @FXML
    public void initialize() {
        updateScoreUi();
    }

    @FXML
    void ButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String id = button.getId();
        String cell = id.substring(6);

        int row = -1;
        int col = -1;
        int count = 1;

        L1: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (count == Integer.parseInt(cell)) {
                    row = i;
                    col = j;
                    break L1;
                }
                count++;
            }
        }

        humanPlayer.move(row, col);
        updateUi();

        if (board.checkWinner() != null) {
            notifyWinner(board.checkWinner().getWinnerPiece());
        } else if (board.isBoardFull()) {
            tieScore++;
            System.out.println("Tie");
            showAlert("Tie");
            updateScoreUi();
        } else {
            aiPlayer.findBestMove();
            System.out.println("----------------------");
            board.printBoard();
            updateUi();

            if (board.checkWinner() != null) {
                notifyWinner(board.checkWinner().getWinnerPiece());
            }
        }
    }

    @Override
    public void update(int col, int row, Piece piece) {
        Button[][] button = {{button1, button2, button3}, {button4, button5, button6}, {button7, button8, button9}};

        if (piece == Piece.X) {
            button[row][col].setText("X");
        } else if (piece == Piece.O) {
            button[row][col].setText("O");
        } else {
            button[row][col].setText(" ");
        }
    }

    public void updateUi() {
        for (int i = 0; i < board.getPieces().length; i++) {
            for (int j = 0; j < board.getPieces()[i].length; j++) {
                update(j, i, board.getPieces()[i][j]);
            }
        }
    }

    @Override
    public void notifyWinner(Piece winner) {
        if (winner == Piece.X) {
            humanScore++;
            System.out.println("X is winner");
            showAlert("X is winner");
        } else if (winner == Piece.O) {
            aiScore++;
            System.out.println("O is winner");
            showAlert("O is winner");
        }
        updateScoreUi();
    }

    private void updateScoreUi() {
        HumanScore.setText(""+ humanScore);
        AiScore.setText(""+ aiScore);
        TieScore.setText(""+ tieScore);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.setOnCloseRequest((DialogEvent event) -> {
            board.initializeBoard();
            updateUi();
        });
        alert.showAndWait();
    }
}
