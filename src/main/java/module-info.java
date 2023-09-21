module com.example.pryatki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pryatki to javafx.fxml;
    exports com.example.pryatki;
}