package it.unisa.diem.ingsoft.gruppo4.view;

import it.unisa.diem.ingsoft.gruppo4.Rubrica.GestoreFile;
import it.unisa.diem.ingsoft.gruppo4.Rubrica.Rubrica;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import static javafx.application.Application.launch;

/**
 * @file InterfacciaUtente.java
 * @brief La classe InterfacciaUtente gestisce un'interfaccia grafica per interagire con l'utente.
 * 
 * Questa classe include le seguenti funzionalità:
 * - init
 * - stop
 * - start
 * - Carica contatti da file
 * - Salva contatti da file 
 * 
 * 
 * @author Gruppo 4
 */
public class InterfacciaUtente extends Application {

    private Rubrica contatti;
    private GestoreFile gestioneFile;

    /**
     * @brief Metodo init() per inizializzare la rubrica e caricare i dati salvati.
     *
     * 
     * Questo metodo viene chiamato all'avvio dell'applicazione per inizializzare 
     * la rubrica e il gestore file. Se esiste un file di backup, i contatti vengono caricati.
     *
     * @pre Le interfacce grafiche devono essere correttamente configurate.
     * @post La rubrica viene inizializzata e popolata con i contatti salvati, se presenti.
     */
    @Override
    public void init() {
        
        contatti = new Rubrica();
        gestioneFile = new GestoreFile();
        caricaContattiDaFile();
    }

     /**
     * @brief Metodo stop() per salvare lo stato corrente della rubrica.
     *
     * Questo metodo viene chiamato quando l'applicazione viene chiusa. Salva i contatti 
     * della rubrica in un file di backup per consentire il recupero dei dati alla successiva esecuzione.
     *
     * @pre L'applicazione deve essere in esecuzione.
     * @post Tutte le risorse vengono rilasciate e i contatti vengono salvati su file.
     */
    @Override
    public void stop() {
        salvaContattiSuFile();
    }

     /**
     * @brief Metodo start() per avviare l'interfaccia grafica.
     * 
     * Questo metodo configura e visualizza la scena principale dell'applicazione.
     * Inizializza il `PrimaryController` con la rubrica corrente per gestire le operazioni sugli oggetti.
     *
     * @param stage Finestra principale dell'applicazione
     * @throws Exception Se si verifica un errore durante il caricamento dell'interfaccia.
     * @post L'interfaccia grafica viene visualizzata e pronta per l'interazione con l'utente.
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();

        // Passa la rubrica al controller
        PrimaryController controller = loader.getController();
        controller.setRubrica(contatti);

        Scene scene = new Scene(root);
        stage.setTitle("Rubrica gruppo 4");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
     /**
     * @brief Metodo  per caricare i contatti da un file.
     * 
     * @pre Il file `backup.txt` deve essere leggibile se esiste.
     * @post I contatti vengono caricati nella rubrica, se il file è valido.
     *
     */

    private void caricaContattiDaFile() {
        File file = new File("backup.txt");
        if (file.exists()) {
            gestioneFile.importaContatti(file, contatti);
        }
    }
    
    /**
     * @brief Metodo privato per salvare i contatti in un file.
     * Utilizza il `GestoreFile` per esportare i contatti correnti della rubrica in un file di backup.
     * 
     * @post Tutti i contatti vengono salvati nel file di backup.
     * 
     */


    private void salvaContattiSuFile() {
        File file = new File( "backup.txt");
        gestioneFile.esportaContatti(file, contatti.getContatti());
    }

     /**
     * @brief Metodo main() per avviare l'applicazione.
     *
     * Punto di ingresso principale dell'applicazione. Chiama il metodo `launch` di JavaFX 
     * per avviare il ciclo di vita dell'applicazione.
     *
     * @param args Argomenti della riga di comando.
     * @post L'applicazione viene avviata.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
