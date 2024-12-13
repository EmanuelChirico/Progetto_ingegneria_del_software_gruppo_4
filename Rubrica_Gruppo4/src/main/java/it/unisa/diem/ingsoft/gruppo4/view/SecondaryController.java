package it.unisa.diem.ingsoft.gruppo4.view;

import it.unisa.diem.ingsoft.gruppo4.Rubrica.Contatto; // Importa la classe Contatto
import it.unisa.diem.ingsoft.gruppo4.Rubrica.Rubrica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondaryController {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCognome;
    
    // TextField per i numeri di telefono (3)
    @FXML
    private TextField txtTelefono1;
    @FXML
    private TextField txtTelefono2;
    @FXML
    private TextField txtTelefono3;
    
    // TextField per le email (3)
    @FXML
    private TextField txtEmail1;
    @FXML
    private TextField txtEmail2;
    @FXML
    private TextField txtEmail3;
    @FXML
    private Button conferma;
    @FXML
    private Button annulla;
    
     
     
       private Rubrica rubrica;
       public void initData(Rubrica rubrica) {
           
       }

    
    @FXML
    private void handleAnnullaButton(ActionEvent event) {
        
    }

   @FXML
private void handleConfermaButton(ActionEvent event) {
  
}

}