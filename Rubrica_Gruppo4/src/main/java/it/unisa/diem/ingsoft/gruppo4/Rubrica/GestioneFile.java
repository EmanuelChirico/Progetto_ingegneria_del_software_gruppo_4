package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

public class GestioneFile {

    private Rubrica rubrica;

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
public void importaContatti(File file, ArrayList<Contatto> rubrica) {
    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split("\\|"); // Separatore "|"
            if (fields.length == 4) { // Controllo compatibilità
                String nome = fields[0].trim();
                String cognome = fields[1].trim();
                String numero = fields[2].trim();
                String email = fields[3].trim();

                // Crea un nuovo contatto e aggiungilo alla rubrica
                Contatto contatto = new Contatto(nome, cognome, numero, email);
                rubrica.add(contatto);
            } else {
                System.out.println("Riga incompatibile: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Errore durante la lettura del file.");
    }
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
    public void esportaContatti() {
    }

}