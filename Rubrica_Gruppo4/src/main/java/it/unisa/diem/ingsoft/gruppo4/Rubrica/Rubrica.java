package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
public class Rubrica implements OperazioniRubrica {

    private GestoreRubrica gestore;
    // Comparatore come attributo di classe
    public Rubrica() {
        this.gestore = new GestoreRubrica();
    }

    /**
     * @brief Il metodo aggiungiContatto() aggiunge un nuovo contatto alla lista.
     * 
     * @pre Il contatto passato come parametro è valido; la lista di contatti è stata inizializzata correttamente.
     * @post Il contatto viene aggiunto alla lista contatti, che viene aggiornata e riordinata.
     * @invariant Gli altri attributi già presenti nella lista non devono essere modificati. 
     * 
     * @param[in] c Contatto da aggiungere.
     * @see confermaModifiche()
     * @see numeroDuplicato()
     */
    @Override
     public boolean aggiungiContatto(Contatto c) {
       return gestore.aggiungiContatto(c);
    }

    /**
     * @brief Il metodo rimuoviContatto() rimuove un contatto dalla lista.
     * 
     * @pre Il contatto passato come parametro è presente nella lista.
     * @post Il contatto viene rimosso dalla lista contatti, che viene aggiornata e riordinata.
     * @invariant Gli altri attributi già presenti nella lista non devono essere modificati. 
     * 
     * @param[in] c Contatto da rimuovere.
     * @see confermaModifiche()
     */
     @Override
    public void rimuoviContatto(Contatto c) {
        gestore.rimuoviContatto(c);
    }
    
    /**
     * @brief Il metodo modificaContatto() modifica un contatto della lista.
     * 
     * @pre Il contatto passato come parametro è presente nella lista.
     * @post Il contatto viene modificato correttamente; la lista di contatti viene aggiornata e riordinata.
     * @invariant Gli altri attributi già presenti nella lista non devono essere modificati. 
     * 
     * @param[in] c Contatto da modificare.
     * @see aggiungiContatto()
     * @see rimuoviContatto()
     * @see confermaModifiche()
     * @see clona()
     */
    @Override
    public boolean modificaContatto(Contatto contattoPrec, Contatto contattoMod) {
        return gestore.modificaContatto(contattoPrec, contattoMod);
    }

    /**
     * @brief Il metodo ricercaContatto() cerca un contatto nella lista.
     * 
     * @pre La lista di contatti non è vuota.
     * @post Viene mostrate le corrispondenze della sottostringa inserita; se non ce ne sono, viene mostrato un elenco vuoto.
     * @invariant Lo stato della lista di contatti non deve essere modificato.
     * 
     * @param[in] str Sottostringa su cui effettuare la ricerca per cognome e nome.
     */
    @Override
    public List<Contatto> ricercaContatto(String str) {
        return gestore.ricercaContatto(str);
    }
    
    @Override
    public void svuotaRubrica() {
        gestore.svuotaRubrica();
    }
    
    @Override
    public ObservableList<Contatto> getContatti() {
        return gestore.getContatti();
    }
   
}