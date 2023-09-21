package com.example.pryatki;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML
    private Button minus;

    @FXML
    private Label plable;
    @FXML
    private Button plus;
    @FXML
    private Label timerLabel;
    @FXML
    private Label welcomeText;

    @FXML
    private TextField playersField;

    @FXML
    private VBox playerNamesBox1;

    @FXML
    private VBox playerNamesBox;
    @FXML
    private Button stopButton;
    @FXML
    private Button pauseResumeButton;

    private int minutes = 0;
    private int seconds = 0;
    private Timer timer;
    private TimerTask timerTask;
    @FXML
    private List<TextField> playerNameFields;
   // List<Player> playerblueList = new ArrayList<>();
    private static final int MAX_NUM_OF_PLAYERS = 30;

    @FXML
    private void increaseMinutes() {
        minutes++;
        updateLabel();
    }

    @FXML
    private void decreaseMinutes() {
        if (minutes > 0) {
            minutes--;
            updateLabel();
        }
    }

    @FXML
    private void startTimer() {
        if (timer == null) {
            timer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (seconds > 0) {
                        seconds--;
                    } else {
                        if (minutes > 0) {
                            minutes--;
                            seconds = 59;
                        } else {
                            stopTimer();
                        }
                    }
                    updateLabel();
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
            stopButton.setDisable(false);
            pauseResumeButton.setDisable(false);
        }
    }

    @FXML
    private void stopTimer() {
        timer.cancel();
        timer = null;
        timerLabel.setText("00:00");
        stopButton.setDisable(true);
        pauseResumeButton.setDisable(true);
    }

    @FXML
    private void pauseResumeTimer() {
        if (timer != null) {
            if (timerTask != null) {
                timerTask.cancel();
                timerLabel.setText("Пауза");
                timerTask = null;
            } else {
                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        if (seconds > 0) {
                            seconds--;
                        } else {
                            if (minutes > 0) {
                                minutes--;
                                seconds = 59;
                            } else {
                                stopTimer();
                            }
                        }
                        updateLabel();
                    }
                };
                timer.scheduleAtFixedRate(timerTask, 0, 1000);
            }
        }
    }

    private void updateLabel() {
        String time = String.format("%02d:%02d", minutes, seconds);
        // Обновление графического интерфейса выполняется в главном потоке JavaFX
        Platform.runLater(() -> {
            timerLabel.setText(time);
        });
    }

    @FXML
    private void setPlayerNames() {
        playerNamesBox.getChildren().clear();
        int numOfPlayers = Integer.parseInt(playersField.getText());

        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        playerNameFields = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            String playerId = String.valueOf(i + 1) + alphabet[i % alphabet.length];
            TextField playerNameField = new TextField();
            playerNameField.setPromptText("Имя игрока " + playerId);
            playerNameField.setId(String.valueOf(i));
            playerNameFields.add(playerNameField);
            playerNamesBox.getChildren().add(playerNameField);

        }
    }

    @FXML
    private void handleEnterKeyPressed(javafx.scene.input.KeyEvent event) {
        if (event.getCode()== KeyCode.ENTER) {
            setPlayerNames();
        }
    }

@FXML
    private void test(){

    List<Label> lbl = new ArrayList<>();
    for(TextField p:playerNameFields) {
        Label playerLable = new Label("scene1");
        playerLable.setText(p.getId()+"   "+p.getPromptText()+"   "+p.getText());
        lbl.add(playerLable);
        System.out.println(p.getId()+"   "+p.getPromptText()+"   "+p.getText());
        playerNamesBox1.getChildren().add(playerLable);
    }

    }

}