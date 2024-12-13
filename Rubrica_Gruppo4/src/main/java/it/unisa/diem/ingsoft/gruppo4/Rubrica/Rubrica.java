package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @file Rubrica.java
 * @brief La classe Rubrica rappresenta una rubrica composta da una lista di contatti.
 * 
 * Questa classe fornisce l'implementazione dei seguenti metodi:
 * - aggiungi contatto
 * - rimuovi contatto
 * - modifica contatto
 * - ricerca contatto
 * - conferma delle modifiche
 * - controllo numero duplicato
 * - clona contatto
 * 
 * @author Gruppo 4
 */

public class Rubrica {

    private ObservableList<Contatto> contatti;

    // Comparatore come attributo di classe
    private Comparator<Contatto> comparatore = new Comparator<Contatto>() {
      
    };
    
     public Rubrica() {
      
    }

    
    
     public boolean aggiungiContatto(Contatto c) {
       
    }

    
    public void rimuoviContatto(Contatto c) {
          
    }

    
    public void modificaContatto(Contatto contattoPrec, Contatto contattoMod) {
       

    }

    
    public List<Contatto> ricercaContatto(String str) {
    }
    

    
    public boolean numeroDuplicato(ArrayList<String> num) {
        
    }
    
   public ObservableList<Contatto> getContatti() {
        
    }
    
}