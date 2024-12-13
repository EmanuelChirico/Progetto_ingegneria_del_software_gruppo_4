package it.unisa.diem.ingsoft.gruppo4.view;

import it.unisa.diem.ingsoft.gruppo4.Rubrica.Contatto; // Importa la classe Contatto
import it.unisa.diem.ingsoft.gruppo4.Rubrica.GestoreFile; // Importa GestioneFile
import it.unisa.diem.ingsoft.gruppo4.Rubrica.Rubrica;
import java.awt.event.KeyEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {
    @FXML
    private TableView<Contatto> tableView; // Collegato al TableView in FXML

    @FXML
    private TableColumn<Contatto, String> colNome;     // Colonna "Nome"
    @FXML
    private TableColumn<Contatto, String> colCognome;  // Colonna "Cognome"
    @FXML
    private TableColumn<Contatto, String> colTelefono; // Colonna "Telefono"
    @FXML
    private TableColumn<Contatto, String> colEmail;    // Colonna "E-mail"
    @FXML
    private TextField searchField;
    @FXML
    private Button aggiungi;

   
    private final GestoreFile gestioneFile = new GestoreFile(); // Instanza della classe GestioneFile
    
    
    private Rubrica contatti;

public PrimaryController() {
    
}
    
     @FXML
    public void initialize() {
       
    }

   @FXML
private void handleAggiungiButton(ActionEvent event) {
   
}
   

    @FXML
    private void handleImportaButton(ActionEvent event) {
        
        }
    }

    @FXML
    private void handleEsportaButton() {
       
        }
    }
    @FXML
    private void handleModificaButton(ActionEvent event) {
        
    }

    @FXML
    private void handleEliminaButton(ActionEvent event) {
      
    }
    
    @FXML
private void handleSearch(KeyEvent event) {
   
    }
    



}
