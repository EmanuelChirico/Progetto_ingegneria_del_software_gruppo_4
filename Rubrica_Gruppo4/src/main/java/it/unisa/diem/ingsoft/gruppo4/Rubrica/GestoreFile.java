package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import java.util.Set;
import javafx.collections.ObservableList;

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
    }

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
public void importaContatti(File file, Rubrica rubrica) {
   
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
            

}
 public int getRigaErrore() {
        
    }