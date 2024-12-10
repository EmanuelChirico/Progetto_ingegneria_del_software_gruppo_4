package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    private List<Contatto> contatti;  
    private boolean conferma;
    
    //Comparatore come attributo di classe
    private Comparator<Contatto> comparatore = new Comparator<Contatto>() {
        @Override
        /* Implementazione comparatore prima per cognome e poi per nome */
        public int compare(Contatto c1, Contatto c2) {
            int cmp = c1.getCognome().compareTo(c2.getCognome());
            if (cmp == 0) {
                cmp = c1.getNome().compareTo(c2.getNome());
            }
            return cmp;
        }
    };
    
    public Rubrica () {
        this.contatti = new ArrayList<>();
        this.conferma = false; 
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
    public boolean aggiungiContatto(Contatto c) {
        if (!confermaModifiche()) {
            return false;
        }
        if (!numeroDuplicato(c.getNumTel())) {
            contatti.add(c);    
            Collections.sort(contatti, comparatore);
            return true;
        } else {
            return false;
        }
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
    public boolean rimuoviContatto(Contatto c) {
        if (!confermaModifiche()) {
            return false;
        }
        contatti.remove(c);
        Collections.sort(contatti, comparatore);
        return true;     
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
    public boolean modificaContatto(Contatto contattoPrec, Contatto contattoMod) {
        if (!confermaModifiche()) {
            return false;
        }
        contattoPrec.setNome(contattoMod.getNome());
        contattoPrec.setCognome(contattoMod.getCognome());
        contattoPrec.setNumTel(contattoMod.getNumTel());
        contattoPrec.setEmail(contattoMod.getEmail());
        Collections.sort(contatti, comparatore);
        return true;
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
    public List<Contatto> ricercaContatto(String str) {
        List<Contatto> corrispondenze = new ArrayList<>();
        
        for (Contatto contatto : contatti) {
            if (contatto.getCognome().toLowerCase().startsWith(str.toLowerCase()) || 
                contatto.getNome().toLowerCase().startsWith(str.toLowerCase())) {
                if (!corrispondenze.contains(contatto))
                    corrispondenze.add(contatto);
            }
        }
        return corrispondenze;
    }
    
     /**
     * @brief Il metodo confermaModifiche() conferma o meno le modifiche apportate sulla lista di contatti.
     * 
     * @pre Sono state effettuate delle modifiche sulla lista.
     * @post Il metodo che ha chiamato confermaModifiche() conferma o meno le operazioni effettuate.
     * 
     * @return conferma True se il bottone "Conferma" viene cliccato, false altrimenti.
     */
    public boolean confermaModifiche(){
        return this.conferma;
    }
    
    public void setConferma(boolean statoConferma) {
        this.conferma = statoConferma;
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
        for (String numero : num) {
            for (Contatto contatto : contatti) {
                if (contatto.getNumTel().equals(numero)) 
                    return true;
            }
        }
        return false;   //Solo se non c'è alcuna occorrenza in tutta la rubrica
    }
    
}
