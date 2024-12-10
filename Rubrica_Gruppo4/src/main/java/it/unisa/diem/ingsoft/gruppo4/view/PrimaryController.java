package it.unisa.diem.ingsoft.gruppo4.view;

import it.unisa.diem.ingsoft.gruppo4.Rubrica.Contatto; // Importa la classe Contatto
import it.unisa.diem.ingsoft.gruppo4.Rubrica.GestioneFile; // Importa GestioneFile
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
import javafx.scene.control.TableColumn;
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

    private ObservableList<Contatto> contattiObservable = FXCollections.observableArrayList(); // Lista osservabile->DA VERIFICARE
    private final GestioneFile gestioneFile = new GestioneFile(); // Instanza della classe GestioneFile
    private final ArrayList<Contatto> rubrica = new ArrayList<>(); // Lista di contatti
    
     @FXML
    public void initialize() {
        // Configura le colonne del TableView
        colNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        colCognome.setCellValueFactory(new PropertyValueFactory<>("Cognome"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Collega la lista osservabile al TableView
        tableView.setItems(contattiObservable);
    }

    @FXML
    private void handleAggiungiButton(ActionEvent event) {
        try {
            App.setRoot("secondary"); // Cambia scena a `secondary.fxml`
        } catch (IOException e) {
            e.printStackTrace(); // Stampa il problema in console
        }
    }

    @FXML
    private void handleImportaButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona un file da importare");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di testo", "*.txt"));

        // Mostra la finestra di dialogo
        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            gestioneFile.importaContatti(selectedFile, rubrica); // Usa GestioneFile per importare i contatti
            tableView.getItems().clear(); // Svuota il TableView
            tableView.getItems().addAll(rubrica); // Aggiungi i contatti importati al TableView
        }
    }

    @FXML
    private void handleEsportaButton() {
        // Mostra una finestra di dialogo "Salva con nome" per scegliere il file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Esporta Rubrica");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di testo", "*.txt"));

        // Ottieni il file selezionato dall'utente
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            // Esporta i contatti nel file selezionato
            gestioneFile.esportaContatti(file, rubrica);
            System.out.println("Rubrica esportata con successo!");
        }
    }
}
