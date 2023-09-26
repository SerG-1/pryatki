package com.example.pryatki;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class Controller {


    @FXML
    private Button minus;
    @FXML
    private Button plus;
    @FXML
    private Label timerLabel;
    @FXML
    private Label welcomeText;

    @FXML
    private TextField playersField;

    @FXML
    private Button button;

    private Controller1 controller2;
    @FXML
    private VBox playerNamesBoxBlue;
    @FXML
    private VBox playerNamesBoxRed;
    @FXML
    private Button stopButton;
    @FXML
    private Button pauseResumeButton;
    @FXML
    TextField playerNameFieldBlue;
    @FXML
    TextField playerNameFieldRed;
    private int minutes = 0;
    private int seconds = 0;
    private Timer timer;
    private TimerTask timerTask;
    @FXML
    private List<TextField> playerNameFieldsBlue;
    @FXML
    private List<TextField> playerNameFieldsRed;
    List<Player> playerblueList;
    List<Player1> playerredList;



    private static final int MAX_NUM_OF_PLAYERS = 30;
    private Stage secondStage;

    public void setSecondStage(Stage secondStage) {
        this.secondStage = secondStage;
    }



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
        playerNamesBoxBlue.getChildren().clear();
        playerNamesBoxRed.getChildren().clear();
        int numOfPlayers = Integer.parseInt(playersField.getText());

        char[] alphabetblue = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] alphabetred = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        playerNameFieldsBlue = new ArrayList<>();
        playerNameFieldsRed = new ArrayList<>();
        playerblueList = new ArrayList<>();
        playerredList = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {

            String playerblueId = String.valueOf(i + 1) + alphabetblue[i % alphabetblue.length];
            String playerredId = String.valueOf(i + 1) + alphabetred[i % alphabetred.length];
            playerNameFieldBlue = new TextField();
            playerNameFieldRed = new TextField();
            playerNameFieldBlue.setPromptText("Имя игрока " + playerblueId);
            playerNameFieldRed.setPromptText("Имя игрока " + playerredId);
            Player playerblue=new Player();
            Player1 playerred=new Player1();
            playerblue.setNomer(playerblueId);
            playerblue.setName("noname");
            playerblue.setId(i+1);
            playerred.setNomer(playerredId);
            playerred.setName("noname");
            playerred.setId(i+1);
            playerblueList.add(playerblue);
            playerredList.add(playerred);
           // playerNameFieldBlue.setId(String.valueOf(i));
            //Получить список TextField
            playerNameFieldsBlue.add(playerNameFieldBlue);
            playerNameFieldsRed.add(playerNameFieldRed);
            playerNamesBoxBlue.getChildren().add(playerNameFieldBlue);
            playerNamesBoxRed.getChildren().add(playerNameFieldRed);

        }
    }

    @FXML
    private void handleEnterKeyPressed(javafx.scene.input.KeyEvent event) {
        if (event.getCode()== KeyCode.ENTER) {
            setPlayerNames();
        }
    }

    @FXML
    private void handleButtonClick() {
        String r = "0";
        sendtobigdisplay(r);

    }
    @FXML
    public void sendtobigdisplay(String resp){

        System.out.println(resp);
        //Blue
       // controller2.getPlayerNamesBox1().getChildren().clear();
        controller2.getPlayerNamesBox1().getChildren().clear();
        controller2.getPlayerNamesBox3().getChildren().clear();
        int i =0;
        for (Player p:playerblueList ){

            p.setName(playerNameFieldsBlue.get(i).getText());
            Label llleft = new Label();
            Label llright = new Label();
            llleft.setText(p.getId()+"   "+p.getNomer()+"     "+p.getName());
            llright.setText(p.getPoints().toString());
            System.out.println(p.getId()+"   "+p.getNomer()+"     "+p.getName());
            System.out.println(resp);
            // controller2.getLabel().setText(p.getId()+"   "+p.getNomer()+"     "+p.getName());

            controller2.getPlayerNamesBox1().getChildren().add(llleft);
            controller2.getPlayerNamesBox3().getChildren().add(llright);
            i=i+1;
        }
        //Red
        controller2.getPlayerNamesBox2().getChildren().clear();
        int k =0;
        for (Player1 p1:playerredList ){

            p1.setName(playerNameFieldsRed.get(k).getText());
            Label ll1 = new Label();
            ll1.setText(p1.getId()+"   "+p1.getNomer()+"     "+p1.getName()+"      "+p1.getPoints());
            System.out.println(p1.getId()+"   "+p1.getNomer()+"     "+p1.getName());
            // controller2.getLabel().setText(p.getId()+"   "+p.getNomer()+"     "+p.getName());
            controller2.getPlayerNamesBox2().getChildren().add(ll1);
            k=k+1;
        }

    }


    public void setController2(Controller1 controller2) {
        this.controller2 = controller2;
    }

}