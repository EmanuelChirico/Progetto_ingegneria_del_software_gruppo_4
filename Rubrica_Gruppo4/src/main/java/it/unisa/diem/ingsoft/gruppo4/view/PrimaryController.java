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

public class PrimaryController {

    @FXML
    private TableView<Contatto> tableView; // Specifica il tipo `Contatto` per il TableView

    private final GestioneFile gestioneFile = new GestioneFile(); // Instanza della classe GestioneFile
    private final ArrayList<Contatto> rubrica = new ArrayList<>(); // Lista di contatti

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
}
