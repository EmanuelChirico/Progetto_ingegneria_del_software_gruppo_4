package it.diem.unisa.ingsoft.gruppoiv.rubrica;

import java.util.List;

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
 * @author Gruppo IV 
 */

public class Rubrica {

    private List<Contatto> contatti;
    
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
    public void aggiungiContatto(Contatto c) {
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
    public void rimuoviContatto(Contatto c) {
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
    public void modificaContatto() {
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
    public void ricercaContatto(String str) {
    }
    
     /**
     * @brief Il metodo confermaModifiche() conferma o meno le modifiche apportate sulla lista di contatti.
     * 
     * @pre Sono state effettuate delle modifiche sulla lista.
     * @post Le modifiche apportate vengono confermate o annullate.
     */
    public void confermaModifiche(){
    }
    
    /**
     * @brief Il metodo numeroDuplicato() verifica se è già presente un contatto avente lo stesso numero.
     * 
     * @pre La lista di numeri passata come parametro è non vuota.
     * @post Restituisce una conferma sulla validità del contatto o meno.
     * 
     * @param[in] num Lista dei numeri di telefono da confrontare.
     * @return True se almeno uno dei numeri è duplicato, false altrimenti.
     */
    public boolean numeroDuplicato(List<String> num) {
        return true;
    }
    
    /**
     * @brief Il metodo clona() clona il contatto passato come parametro.
     * 
     * @pre Il contatto passato come parametro è valido.
     * @post Restituisce un clone del contatto passato come parametro.
     * @invariant Il contatto passato come parametro non viene modificato.
     * 
     * @param[in] c Contatto da clonare.
     * @return Il clone del contatto.
     */
    public Contatto clona(Contatto c){
        return null;
    }
}
