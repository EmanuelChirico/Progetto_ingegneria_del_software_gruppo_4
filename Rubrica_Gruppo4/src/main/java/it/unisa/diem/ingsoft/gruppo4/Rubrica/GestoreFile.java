package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 * @file GestioneFile.java
 * @brief La classe GestioneFile gestisce l'importazione della rubrica da un file e l'esportazione della stessa verso un file.
 * 
 * Questa classe fornisce l'implementazione dei seguenti metodi:
 * - importa contatti
 * - esporta contatti
 * 
 * @author Gruppo 4 
 */
public class GestoreFile {

    private Rubrica rubrica;
    private int rigaErrore = 0;

    /**
     * @brief Il metodo importaContatti() importa una rubrica da un file.
     * 
     * @pre Il file, il cui nome è passato come parametro, esiste.
     * @post La rubrica che era presente nel file viene salvata in una lista di contatti, se la struttura del file è coerente con quella della rubrica. 
     * @invariant Il file non viene modificato.
     * 
     * @param[in] nomeFile Il file da cui bisogna importare la rubrica
     * 
     */
    public boolean importaContatti(File file, OperazioniRubrica rubrica) {
    
        List<Contatto> contattiDaAggiungere = new ArrayList<>();
        boolean tutteRigheValide = true; // Flag per controllare la validità delle righe
        int numeroRiga = 1;
    
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
            
                if (line.trim().isEmpty()) {
                    numeroRiga++;
                    continue; // Salta righe vuote
                }
            
                String[] fields = line.split("\\|"); // Separatore "|"
            
                int separatorCount = line.length() - line.replace("|", "").length();
                if (separatorCount != 3) {
                    tutteRigheValide = false; // Imposta il flag a false se una riga non è valida
                    rigaErrore = numeroRiga; // Memorizza la riga che ha causato l'errore
                    continue;
                }
            
                // Controlla se nome e cognome sono entrambi vuoti
                if (fields[0].trim().isEmpty() && fields[1].trim().isEmpty()) {
                    tutteRigheValide = false; // Imposta il flag a false se nome e cognome sono vuoti
                    rigaErrore = numeroRiga; // Memorizza la riga che ha causato l'errore
                    continue;
                }
            
                String nome = fields.length > 0 ? fields[0].trim() : "";
                String cognome = fields.length > 1 ? fields[1].trim() : "";

                // Gestione dei numeri di telefono
                ArrayList<String> numeriTelefono = new ArrayList<>();
                if (fields.length > 2 && fields[2] != null && !fields[2].trim().isEmpty()) {
                    String[] numeri = fields[2].trim().split(",");
                    for (String numero : numeri) {
                        numero = numero.trim();
                        if (!numero.isEmpty()) { // Ignora numeri vuoti
                            numeriTelefono.add(numero);
                        }
                    }
                }

                // Gestione delle email
                ArrayList<String> email = new ArrayList<>();
                if (fields.length > 3 && fields[3] != null && !fields[3].trim().isEmpty()) {
                    String[] emails = fields[3].trim().split(",");
                    for (String e : emails) {
                        e = e.trim();
                        if (!e.isEmpty()) { // Ignora email vuote
                            email.add(e);
                        }
                    }
                }

                // Crea un nuovo contatto
                Contatto contatto = new Contatto();
                contatto.setNome(nome);
                contatto.setCognome(cognome);
                contatto.setNumTel(numeriTelefono);
                contatto.setEmail(email);

                // Aggiungi il contatto alla lista temporanea
                contattiDaAggiungere.add(contatto);
                numeroRiga++;
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore durante l'importazione");
            alert.setHeaderText("Si è verificato un errore durante l'importazione del file");
            alert.showAndWait();
            return false;
        }
        // Aggiungi i contatti alla rubrica solamente se tutte le righe sono valide
        if (tutteRigheValide) {
            rubrica.svuotaRubrica();
            for (Contatto contatto : contattiDaAggiungere) {
                rubrica.aggiungiContatto(contatto);
            }
            return true;
        } else return false;
    }

    public int getRigaErrore() {
        return rigaErrore;
    }

    /**
     * @brief Il metodo esportaContatti() esporta una rubrica su un file.
     * 
     * @post La lista di contatti viene salvata nel file scelto: se già esisteva un file con quel nome, viene sovrascritto. 
     * @invariant La lista di contatti non viene modificata.
     * 
     * @param[in] nomeFile Il file su cui bisogna esportare la rubrica.
     * 
     */
    public void esportaContatti(File file, ObservableList<Contatto> rubrica) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Contatto contatto : rubrica) {
                String line = String.join("|", contatto.getNome(), contatto.getCognome(), String.join(",", contatto.getNumTel()), String.join(",", contatto.getEmail()));
                writer.write(line);
                writer.newLine();
            }   
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore durante l'esportazione");
            alert.setHeaderText("Si è verificato un errore durante l'esportazione del file");
            alert.showAndWait();
        }
    }

}