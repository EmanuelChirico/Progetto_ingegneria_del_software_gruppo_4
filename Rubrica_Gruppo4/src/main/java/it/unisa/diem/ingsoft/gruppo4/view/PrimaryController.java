package it.unisa.diem.ingsoft.gruppo4.view;

import it.unisa.diem.ingsoft.gruppo4.Rubrica.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @file PrimaryController.java
 * @brief Controller principale per la gestione della rubrica.
 * 
 * Questa classe gestisce l'interfaccia grafica principale della rubrica, inclusa
 * l'interazione con i contatti tramite aggiunta, modifica, eliminazione, 
 * importazione ed esportazione. Contiente i seguenti metodi:
 * -initialize
 * -filtraContatti
 * -handleAggiungiButton
 * -addContactToTable
 * -aggiornaTabella
 * -handleImportaButton
 * -handeEsportaRubrica
 * -handleModificaButton
 * -setRubrica
 * -handleEliminaButton
 * -handleSearch
 * -getTableView
 * 
 * @author Gruppo 4
 */

public class PrimaryController {
    
    @FXML
    private TableView<Contatto> tableView;
    @FXML
    private TableColumn<Contatto, String> colNome;
    @FXML
    private TableColumn<Contatto, String> colCognome;
    @FXML
    private TableColumn<Contatto, String> colTelefono;
    @FXML
    private TableColumn<Contatto, String> colEmail;
    @FXML
    private TextField searchField;
    @FXML
    private Button aggiungi;
    @FXML
    private Button rimuovi;
    @FXML
    private Button modifica;
    @FXML
    private Button esporta;
    @FXML
    private Button importa;
    @FXML
    private TextField ricerca;
    
    private OperazioniRubrica rubrica;
    private GestoreFile gestioneFile;
    
    /**
     * @brief Inizializza il controller e configura la tabella dei contatti.
     * 
     * Configura le colonne del `TableView`, associa i dati della rubrica e aggiunge
     * un listener per filtrare i contatti in base al testo di ricerca.
     * @pre Il file FXML è stato caricato correttamente e i componenti annotati con @FXML sono stati inizializzati.
     * @post La tabella è configurata
     */
    
    @FXML
    public void initialize() {
        rubrica = new Rubrica();
        gestioneFile = new GestoreFile();
    
        // Configura le colonne del TableView
        colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        colCognome.setCellValueFactory(cellData -> cellData.getValue().cognomeProperty());
        colTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getNumTel())));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getEmail())));

        tableView.setItems(rubrica.getContatti());
    
        // Aggiunto un listener al TextField di ricerca in modo da filtrare la TableView
        ricerca.textProperty().addListener((observable, oldValue, newValue) -> {
            filtraContatti(newValue);
        });
    }

     /**
     * @brief Filtra i contatti visibili nella tabella in base a un filtro.
     * 
     * @param filtro Stringa di filtro per cercare i contatti per nome o cognome.
     * @pre La rubrica è inizializzata e la `TableView` è configurata con i dati.
     * @post La tabella mostra solo i contatti che soddisfano il filtro. Lo stato della rubrica non viene modificato.
     */
    private void filtraContatti(String filtro) {
        if (filtro == null || filtro.isEmpty()) {
            tableView.setItems(rubrica.getContatti());
        } else {
            List<Contatto> risultati = rubrica.ricercaContatto(filtro);
            ObservableList<Contatto> contattiFiltrati = FXCollections.observableArrayList(risultati);
            tableView.setItems(contattiFiltrati);
        }
    }
    
    /**
     * @brief Apre la finestra di dialogo per aggiungere un nuovo contatto.
     * 
     * @param event Evento di azione.
     * @pre La rubrica è inizializzata e il file `secondary.fxml` è valido.
     * @post Viene aperta una finestra di dialogo per aggiungere un nuovo contatto. La rubrica non subisce modifiche immediate.
     * 
     */
   @FXML
    private void handleAggiungiButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(InterfacciaUtente.class.getResource("secondary.fxml"));
            Parent root = loader.load();

            SecondaryController controller = loader.getController();
            controller.setPrimaryController(this);
        
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Aggiungi Contatto");
            stage.show();   
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Errore durante l'apertura della finestra di dialogo");
            alert.setContentText("Si è verificato un errore durante l'apertura della finestra di dialogo per aggiungere un contatto.");
            alert.showAndWait();
        }
    }
     /**
     * @brief Aggiunge un contatto alla tabella.
     * @param c Contatto da aggiungere.
     * 
     * @pre La rubrica è inizializzata e il contatto passato come parametro è valido
     * @post Il contatto viene aggiunto alla rubrica e alla tabella, se il numero non è duplicato. 
     * In caso contrario, viene mostrato un messaggio di errore e la rubrica non viene modificata.
     * 
     */
    public void addContactToTable(Contatto c) {
        if (rubrica != null) {
            if (rubrica.aggiungiContatto(c))  {
                aggiornaTabella();  // Aggiorna la TableView
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setHeaderText("Impossibile aggiungere il contatto");
                alert.setContentText("Il numero inserito è già presente nella rubrica.");
                alert.showAndWait();
            }
        }
    }
    
     /**
     * @brief Aggiorna la tabella con i dati attuali della rubrica.
     */
    public void aggiornaTabella() {
        if (rubrica != null) {
            ObservableList<Contatto> listaContatti = FXCollections.observableArrayList(rubrica.getContatti());
            tableView.setItems(listaContatti);
        }
    }
   
     /**
     * @brief Importa i contatti da un file selezionato dall'utente.
     * 
     * @pre La rubrica è inizializzata e l'istanza di `GestoreFile` è configurata.
     * @post I contatti validi presenti nel file vengono aggiunti alla rubrica e la `TableView` viene aggiornata.
     * In caso di errore, viene mostrato un messaggio e la rubrica rimane invariata.
     * @param event Evento di azione.
     */
    
    @FXML
    private void handleImportaButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona un file da importare");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di testo", "*.txt"));

        // Mostra la finestra di dialogo
        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            tableView.getItems().clear();
            try {
                if (gestioneFile.importaContatti(selectedFile, rubrica)) {
                    tableView.setItems(rubrica.getContatti());
                    /* Notifica avvenuta importazione */
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Importazione completata");
                    alert.setHeaderText("Importazione dei contatti completata con successo");
                    alert.setContentText("Sono stati importati " + rubrica.getContatti().size() + " contatti.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Errore durante l'importazione");
                    alert.setHeaderText("Errore durante l'importazione dei contatti"); 
                    alert.setContentText("La riga " + gestioneFile.getRigaErrore() + " è incompatibile.");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore durante l'importazione");
                alert.setHeaderText("Errore durante l'importazione dei contatti");
                alert.setContentText("Si è verificato un errore durante l'importazione dei contatti.");
                alert.showAndWait();   
            }
        }
    }
    
     /**
     * @brief Esporta i contatti della rubrica in un file.
     * 
     * @pre La rubrica è inizializzata e contiene contatti validi.
     * @post I contatti della rubrica vengono salvati nel file selezionato. In caso di errore, viene mostrato un messaggio e nessun dato viene esportato.
     */
    
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
            gestioneFile.esportaContatti(file, rubrica.getContatti());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Esportazione completata");
            alert.setHeaderText("Rubrica esportata con successo!");
            alert.setContentText("Il file è stato salvato correttamente.");
            alert.showAndWait();
        }
    }
    
     /**
     * @brief Gestisce l'evento del pulsante "Modifica".
     * 
     * Questo metodo apre una finestra di dialogo per modificare il contatto selezionato nella tabella.
     * Se nessun contatto è selezionato, viene mostrato un messaggio di errore.
     * 
     * @param event L'evento di tipo `ActionEvent` generato dal clic sul pulsante.
     * 
     * @pre Deve essere selezionato un contatto dalla tabella.
     * @post Viene aperta una finestra di dialogo per modificare il contatto selezionato
     *       oppure viene mostrato un messaggio di errore se nessun contatto è selezionato.
     */
    
    @FXML
    private void handleModificaButton(ActionEvent event) {
        Contatto selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            try {
                FXMLLoader loader = new FXMLLoader(InterfacciaUtente.class.getResource("secondary.fxml"));
                Parent root = loader.load();

                SecondaryController controller = loader.getController();
                controller.setPrimaryController(this);
                controller.setRubrica(rubrica); // Passa l'oggetto rubrica
                controller.setContattoDaModificare(selectedContact); // Passa il contatto selezionato
        
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Modifica Contatto");
                stage.show();   
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setHeaderText("Errore durante l'apertura della finestra di dialogo");
                alert.setContentText("Si è verificato un errore durante l'apertura della finestra di dialogo per modificare un contatto.");
                alert.showAndWait();
            }
        }
    }
    
    /**
    * @brief Imposta l'oggetto Rubrica associato al controller.
    * 
    * Questo metodo consente di associare un'implementazione di `OperazioniRubrica` al controller.
    * Inoltre, aggiorna la tabella per riflettere i dati contenuti nella rubrica.
    * 
    * @param rubrica L'istanza di `OperazioniRubrica` da associare al controller.
    * 
    * @pre Il parametro `rubrica` non deve essere null.
    * @post L'oggetto rubrica è associato al controller e i dati della tabella vengono aggiornati.
    */

    public void setRubrica(OperazioniRubrica rubrica) { 
        this.rubrica = rubrica; 
        tableView.setItems(rubrica.getContatti()); 
    }
    /**
     * @brief Gestisce l'eliminazione di un contatto selezionato dalla tabella.
     * 
     * Questo metodo consente di rimuovere il contatto selezionato nella `TableView`
     * sia dalla tabella stessa che dalla rubrica associata.
     * 
     * @param event L'evento `ActionEvent` generato dal clic sul pulsante "Elimina".
     * 
     * @pre Un contatto deve essere selezionato nella `TableView`.
     * @post Il contatto selezionato viene rimosso sia dalla rubrica che dalla tabella.
     * 
     */
    @FXML
    private void handleEliminaButton(ActionEvent event) {
        Contatto selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            rubrica.rimuoviContatto(selectedContact);
            tableView.getItems().remove(selectedContact);  // Rimuove dalla TableView
        }
    }
     /**
     * @brief Gestisce la ricerca dei contatti nella rubrica in base al testo inserito.
     * 
     * Questo metodo aggiorna la visualizzazione della `TableView` filtrando i contatti
     * in base al testo inserito nel campo di ricerca. Il filtro viene applicato su nome,
     * cognome, numeri di telefono ed email.
     * 
     * @param event L'evento `KeyEvent` generato dall'inserimento di testo nel campo di ricerca.
     * 
     * @pre La rubrica deve essere inizializzata e popolata con dei contatti.
     * @post La `TableView` mostra solo i contatti che soddisfano i criteri di ricerca.
     * 
     */

    @FXML
    private void handleSearch(KeyEvent event) {
        String query = searchField.getText().toLowerCase();
        ObservableList<Contatto> filteredList = FXCollections.observableArrayList();
        for (Contatto c : rubrica.getContatti()) {
            if (c.getNome().toLowerCase().contains(query) ||
                c.getCognome().toLowerCase().contains(query) ||
                c.getNumTel().toString().contains(query) ||
                c.getEmail().toString().contains(query)) {
                filteredList.add(c);
            }
        }
        tableView.setItems(filteredList);
    }
    
    /**
     * @brief Restituisce la `TableView` associata alla rubrica.
     * 
     * Questo metodo fornisce l'accesso alla `TableView` utilizzata per visualizzare e gestire 
     * i contatti della rubrica. Può essere utilizzato per manipolare o aggiornare la tabella 
     * programmaticamente.
     * 
     * @return tableView Utilizzata per visualizzare i contatti.
     * 
     * @pre La `TableView` deve essere inizializzata.
     * @post Nessun cambiamento allo stato interno dell'oggetto.
     */
    public TableView<Contatto> getTableView() {
        return tableView;
    }
}
