package it.unisa.diem.ingsoft.gruppo4.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import java.io.IOException;

public class SecondaryController {

    @FXML
    private void handleCancelButton(ActionEvent event) {
        try {
            App.setRoot("primary"); // Cambia la scena alla vista "primary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
