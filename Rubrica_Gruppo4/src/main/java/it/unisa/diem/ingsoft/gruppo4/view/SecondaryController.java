package it.unisa.diem.ingsoft.gruppo4.view;

import it.unisa.diem.ingsoft.gruppo4.Rubrica.*; // Importa la classe Contatto
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

    /**
    * @file SecondaryController.java
    * @brief Controller per la gestione della finestra di dialogo per l'aggiunta o la modifica dei contatti.
    * 
    * I metodi principali includono:
    * -handleConfermaButton
    * -handleAnnullaButton
    * -setContattoDaModificare
    * 
    * @author Gruppo 4
    */
public class SecondaryController {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCognome;
    @FXML
    private TextField txtTelefono1;
    @FXML
    private TextField txtTelefono2;
    @FXML
    private TextField txtTelefono3;
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
    
    private OperazioniRubrica rubrica;
    private PrimaryController primaryController;
    private Contatto contattoDaModificare;
    private boolean isModifica;    
    
 /**
 * @brief Imposta la rubrica da utilizzare per il controller.
 * 
 * @param rubrica L'istanza di `OperazioniRubrica` da associare al controller.
 * 
 * @pre La rubrica passata come parametro non deve essere null.
 * @post La rubrica viene associata al controller per gestire i contatti.
 */

    public void setRubrica(OperazioniRubrica rubrica) {
        this.rubrica = rubrica;
    }
     /**
     * @brief Imposta il controller principale.
     * 
     * @param primaryController Il controller principale.
     */
    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }
    
    /**
    * @brief Inizializza il controller e configura l'interfaccia utente.
    * 
    * 
    * @pre I componenti annotati con `@FXML` devono essere inizializzati correttamente.
    * @post I campi di input sono pronti per l'inserimento dei dati e il pulsante "Conferma"
    * viene abilitato o disabilitato in base alla validità dei dati inseriti.
    */ 
    
    @FXML
    public void initialize() {
        conferma.setDisable(true);
        txtNome.textProperty().addListener((observable, oldValue, newValue) -> checkConfirmButton());
        txtCognome.textProperty().addListener((observable, oldValue, newValue) -> checkConfirmButton());
    }
     /**
     * @brief Controlla se il pulsante di conferma deve essere abilitato.
     * 
     * Il pulsante viene abilitato solo se almeno uno tra nome e cognome è stato compilato.
     * @pre I campi `txtNome` e `txtCognome` sono stati inizializzati correttamente.
     * @post Il pulsante "Conferma" viene abilitato se almeno uno dei due campi contiene
     * un valore non vuoto, altrimenti viene disabilitato.
     */
    private void checkConfirmButton() {
        boolean canConfirm = !txtNome.getText().isEmpty() || !txtCognome.getText().isEmpty();
        conferma.setDisable(!canConfirm);
    }
    
     /**
     * @brief Imposta il contatto da modificare e popola i campi di input con i dati esistenti.
     * 
     * @param contatto Contatto da modificare.
     * 
     * @pre I campi di input della finestra sono stati inizializzati correttamente.
     * @post La modalità di modifica (`isModifica`) viene impostata su true
     */
    public void setContattoDaModificare(Contatto contatto) {
        this.contattoDaModificare = contatto;
        if (contatto != null) {
            txtNome.setText(contatto.getNome());
            txtCognome.setText(contatto.getCognome());
            // Popola i numeri di telefono
            List<String> numeriTelefono = contatto.getNumTel();
            if (numeriTelefono.size() > 0) txtTelefono1.setText(numeriTelefono.get(0));
            if (numeriTelefono.size() > 1) txtTelefono2.setText(numeriTelefono.get(1));
            if (numeriTelefono.size() > 2) txtTelefono3.setText(numeriTelefono.get(2));
            // Popola le email
            List<String> email = contatto.getEmail();
            if (email.size() > 0) txtEmail1.setText(email.get(0));
            if (email.size() > 1) txtEmail2.setText(email.get(1));
            if (email.size() > 2) txtEmail3.setText(email.get(2));
        }
        setModalitaModifica(true);
    }
     /**
     * @brief Imposta la modalità di modifica.
     * 
     * @param isModifica True se l'operazione è una modifica, false altrimenti.
     * 
     * @post La variabile `isModifica` viene impostata al valore del parametro. 
     */
    public void setModalitaModifica(boolean isModifica) {
        this.isModifica = isModifica;
    }
    
     /**
     * @brief Gestisce l'evento di clic sul pulsante "Annulla".
     * 
     * Chiude la finestra senza salvare le modifiche.
     * 
     * @param event L'evento associato al clic sul pulsante.
     */
    
    @FXML
    private void handleAnnullaButton(ActionEvent event) {
        Stage stage = (Stage) annulla.getScene().getWindow();
        stage.close();
    }
       /**
     * @brief Gestisce l'evento di clic sul pulsante "Conferma".
     * 
     * Valida i dati inseriti e li salva come nuovo contatto o modifica un contatto esistente.
     * 
     * @param event L'evento associato al clic sul pulsante.
     * @pre I campi di input e i pulsanti nella finestra di dialogo sono stati inizializzati correttamente.
     * @pre L'istanza di `OperazioniRubrica` è configurata e valida.
     * @pre Il riferimento al `PrimaryController` è stato inizializzato.
     * 
     * @post Un nuovo contatto viene aggiunto alla rubrica oppure un contatto esistente viene aggiornato. 
     *       In caso di errore, viene mostrato un messaggio di errore e nessuna modifica viene applicata.
     * @post La finestra di dialogo viene chiusa al termine dell'operazione.
     */
    
   @FXML
    private void handleConfermaButton(ActionEvent event) {
        // Ottieni i valori dai TextField
        String nome = txtNome.getText();
        String cognome = txtCognome.getText();
    
        // Raccogli numeri di telefono ed email
        ArrayList<String> numeriTelefono = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
    
        String[] campiTelefono = {txtTelefono1.getText(), txtTelefono2.getText(), txtTelefono3.getText()};
        String[] campiEmail = {txtEmail1.getText(), txtEmail2.getText(), txtEmail3.getText()};

        for (int i = 0; i < 3; i++) {
            if (!campiTelefono[i].isEmpty() && isValidNumTel(campiTelefono[i])) {
                numeriTelefono.add(campiTelefono[i]);
            } else if (!campiTelefono[i].isEmpty())  {
                mostraErrore("Numero di telefono non valido", "Il " + (i + 1) + "° numero non è valido.");
            }

            if (!campiEmail[i].isEmpty() && isValidEmail(campiEmail[i])) {
                email.add(campiEmail[i]);
            } else if (!campiEmail[i].isEmpty()) {
                mostraErrore("Email non valida", "La " + (i + 1) + "° email non è valida.");
            }
        }
  
        Contatto contatto = new Contatto();
        contatto.setNome(nome);
        contatto.setCognome(cognome);
        contatto.setNumTel(numeriTelefono);
        contatto.setEmail(email);
        
        if (isModifica && contattoDaModificare != null) {
            // Modifica il contatto esistente
            if (rubrica.modificaContatto(contattoDaModificare, contatto)) {
            // Aggiorna la tabella
            primaryController.aggiornaTabella(); // Assicurati di avere un metodo per aggiornare la tabella
            primaryController.getTableView().refresh(); // Forza l'aggiornamento della TableView
            } else {
                mostraErrore("Modifica non valida","Il numero di telefono inserito è già presente nella rubrica.");
            }
        }  
        if  (!isModifica && (!nome.isEmpty() || !cognome.isEmpty())) {
            // Crea il contatto solo se almeno un campo è compilato
            // Aggiungi il contatto alla rubrica
            primaryController.addContactToTable(contatto);
        }
        Stage stage = (Stage) conferma.getScene().getWindow();
        stage.close();
    }
     /**
     * @brief Valida un numero di telefono.
     * 
     * @param numTel Numero di telefono da validare.
     * @return True se il numero è valido, false altrimenti.
     */
    public boolean isValidNumTel (String numTel) {
        return numTel.matches("^(\\+)?[0-9]{1,3}( )?[0-9]{3,14}$");
    }
    
      /**
     * @brief Valida un indirizzo email.
     * 
     * @param email Indirizzo email da validare.
     * @return True se l'email è valida, false altrimenti.
     */
    public boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
    
     /**
     * @brief Mostra un messaggio di errore.
     * 
     * @param titolo Titolo della finestra di errore.
     * @param messaggio Contenuto del messaggio di errore.
     */
    private void mostraErrore(String titolo, String messaggio) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(titolo);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
    
}   
