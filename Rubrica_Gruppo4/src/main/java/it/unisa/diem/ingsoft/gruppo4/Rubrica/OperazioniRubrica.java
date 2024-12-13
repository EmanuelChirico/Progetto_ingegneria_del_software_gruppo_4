package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.util.List;
import javafx.collections.ObservableList;

/**
 * @file OperazioniRubrica.java
 * @brief Interfaccia che definisce le operazioni principali per la gestione di una rubrica.
 * @author Gruppo4
 */
public interface OperazioniRubrica {
    boolean aggiungiContatto(Contatto c);
    void rimuoviContatto(Contatto c);
    boolean modificaContatto(Contatto contattoPrec, Contatto contattoMod);
    List<Contatto> ricercaContatto(String str);
    ObservableList<Contatto> getContatti();
    void svuotaRubrica();
}

