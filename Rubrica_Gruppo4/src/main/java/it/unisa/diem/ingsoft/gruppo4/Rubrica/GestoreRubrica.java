package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @file GestoreRubrica.java
 * @brief La classe GestoreRubrica rappresenta una rubrica composta da una lista di contatti.
 * Questa classe implementa l'interfaccia OperazioniRubrica e fornisce metodi per
 * gestire una rubrica telefonica, tra cui aggiungere, rimuovere, modificare e cercare contatti.
 * Inoltre, offre funzionalità per verificare duplicati e svuotare la rubrica.
 * 
 * Questa classe fornisce l'implementazione dei seguenti metodi:
 * - aggiungi contatto
 * - rimuovi contatto
 * - modifica contatto
 * - ricerca contatto
 * - numero duplicato
 * - svuota
 * - getContatti
 * 
 * @author Gruppo 4
 */
public class GestoreRubrica implements OperazioniRubrica {

    private ObservableList<Contatto> contatti;
    // Comparatore come attributo di classe
    private final Comparator<Contatto> comparatore;
    
    /**
     * @brief Costruttore della classe GestoreRubrica
     * Inizializza una lista osservabile vuota di contatti e definisce un comparatore
     * per l'ordinamento dei contatti per cognome e nome.
     * 
     */
    
     public GestoreRubrica() {
        this.comparatore = new Comparator<Contatto>() {
            @Override
            public int compare(Contatto c1, Contatto c2) {
                int cmp = c1.getCognome().compareTo(c2.getCognome());
                if (cmp == 0) {
                    cmp = c1.getNome().compareTo(c2.getNome());
                }
                return cmp;
            }
        };
        this.contatti = FXCollections.observableArrayList();
    }

    
    /**
     * @brief Il metodo aggiungiContatto() aggiunge un nuovo contatto alla lista.
     * 
     * @pre Il contatto passato come parametro è valido; la lista di contatti è stata inizializzata correttamente.
     * @post Il contatto viene aggiunto alla lista contatti, che viene aggiornata e riordinata.
     * @invariant Gli altri attributi già presenti nella lista non devono essere modificati. 
     * 
     * @param c Contatto da aggiungere.
     * @return `true` se il contatto è stato aggiunto correttamente, `false` se ci sono duplicati.
     */
     
     @Override
     public boolean aggiungiContatto(Contatto c) {
        if (!numeroDuplicato(c.getNumTel())) {
            contatti.add(c);
            FXCollections.sort(contatti, comparatore); // Ordina l'ObservableList
            return true;
        } else return false;
     }

    /**
     * @brief Il metodo rimuoviContatto() rimuove un contatto dalla lista.
     * 
     * @post Il contatto viene rimosso dalla lista contatti, che viene aggiornata e riordinata.
     * @invariant Gli altri attributi già presenti nella lista non devono essere modificati. 
     * 
     * @param c Contatto da rimuovere.
     * @see remove()
     */
     @Override
    public void rimuoviContatto(Contatto c) {
        contatti.remove(c);
        FXCollections.sort(contatti, comparatore);  
    }

    /**
     * @brief Il metodo modificaContatto() modifica un contatto della lista.
     * 
     * @pre Il contatto passato come parametro è presente nella lista.
     * @post Il contatto viene modificato correttamente; la lista di contatti viene aggiornata e riordinata.
     * @invariant Gli altri attributi già presenti nella lista non devono essere modificati. 
     * 
     * @param contattoPrec Il contatto da modificare
     * @param contattoMod I nuovi dati del contatto
     * @return `true` se la modifica è avvenuta con successo, `false` se ci sono numeri duplicati.
     */
    @Override
    public boolean modificaContatto(Contatto contattoPrec, Contatto contattoMod) {
        // Controlla se ci sono numeri duplicati nel contatto che stai cercando di modificare
        for (String numero : contattoMod.getNumTel()) {
            for (Contatto contatto : contatti) {
                // Non confrontare con il contatto che stai modificando
                if ((!contatto.equals(contattoPrec) && contatto.getNumTel().contains(numero)) || (contattoMod.getNumTel().indexOf(numero) != contattoMod.getNumTel().lastIndexOf(numero))) {
                    return false;
                }    
            }
        }
        contattoPrec.setNome(contattoMod.getNome());
        contattoPrec.setCognome(contattoMod.getCognome());
        contattoPrec.setNumTel(contattoMod.getNumTel());
        contattoPrec.setEmail(contattoMod.getEmail());
        FXCollections.sort(contatti, comparatore);
        return true;
    }

    /**
     * @brief Il metodo ricercaContatto() cerca un contatto nella lista.
     * 
     * @pre La lista di contatti non è vuota.
     * @post Viene mostrate le corrispondenze della sottostringa inserita; se non ce ne sono, viene mostrato un elenco vuoto.
     * @invariant Lo stato della lista di contatti non deve essere modificato.
     * 
     * @param str Sottostringa su cui effettuare la ricerca per cognome e nome.
     * @return Una lista di contatti che corrispodono alla ricerca
     */
    @Override
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
     * @brief Il metodo numeroDuplicato() verifica se è già presente un contatto avente lo stesso numero.
     * 
     * @pre La lista di numeri passata come parametro è non vuota.
     * @post Restituisce una conferma sulla validità del contatto o meno.
     * 
     * @param num ArrayList dei numeri di telefono da verificare
     * @return True se almeno uno dei numeri è duplicato, false altrimenti.
     */
    public boolean numeroDuplicato(ArrayList<String> num) {
        for (String numero : num) {
            for (Contatto contatto : contatti) {
                if (contatto.getNumTel().contains(numero)) 
                    return true;
            }
        }
        return false;   //Solo se non c'è alcuna occorrenza in tutta la rubrica
    }
    /**
     * @brief Svuota completamente la rubrica
     * @post Rimuove tutti i contatti dalla lista
     */
    @Override
    public void svuotaRubrica() {
        if (contatti != null)
            contatti.clear();
    }
    /**
     * @brief Restituisce la lista osservabile di contatti.
     * @return  La lista osservabile di contatti.
     */
    
    @Override
    public ObservableList<Contatto> getContatti() {
        return contatti;
    }
    
}
