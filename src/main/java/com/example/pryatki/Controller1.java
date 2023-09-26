package com.example.pryatki;


import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class Controller1 {


    @FXML
    private VBox playerNamesBox1;
    @FXML
    private VBox playerNamesBox2;

    @FXML
    private VBox playerNamesBox3;


    public VBox getPlayerNamesBox1() {
        return playerNamesBox1;
    }

    public void setPlayerNamesBox1(VBox playerNamesBox1) {
        this.playerNamesBox1 = playerNamesBox1;
    }

    public VBox getPlayerNamesBox2() {
        return playerNamesBox2;
    }

    public void setPlayerNamesBox2(VBox playerNamesBox2) {
        this.playerNamesBox2 = playerNamesBox2;
    }

    public VBox getPlayerNamesBox3() {
        return playerNamesBox3;
    }

    public void setPlayerNamesBox3(VBox playerNamesBox3) {
        this.playerNamesBox3 = playerNamesBox3;
    }
}
