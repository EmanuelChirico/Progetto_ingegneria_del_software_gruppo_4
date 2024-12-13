package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.ListProperty;
import javafx.collections.FXCollections;
import java.util.ArrayList;

/**
 * @file Contatto.java
 * @brief La classe Contatto rappresenta un contatto con informazioni personali.
 * 
 * Questa classe include le seguenti informazioni:
 * -nome
 * -cognome
 * -numeri di telefono 
 * -email
 * 
 * @author Gruppo 4
 */
public class Contatto {

    private StringProperty nome;
    private StringProperty cognome;
    private ListProperty<String> numTel;
    private ListProperty<String> email;
    private final int MAX_CONTACTS = 3;  // Limite massimo di numeri e email
    /**
     * @brief Costruttore della classe Contatto
     */
    public Contatto() {
        this.nome = new SimpleStringProperty("");
        this.cognome = new SimpleStringProperty("");
        this.numTel = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.email = new SimpleListProperty<>(FXCollections.observableArrayList());
    }
    
    /**
     * @brief Il metodo getNome() restituisce il nome del contatto.
     * 
     * @post Restituisce il valore corrente dell'attributo associato.
     * @invariant Lo stato dell'oggetto non deve essere modificato.
     * 
     * @return Il nome del contatto.
     */
    public String getNome() {
        return nome.get();
    }

    /**
     * @brief Il metodo getCognome() restituisce il cognome del contatto.
     * 
     * @post Restituisce il valore corrente dell'attributo associato.
     * @invariant Lo stato dell'oggetto non deve essere modificato.
     * 
     * @return Il cognome del contatto.
     */
    public String getCognome() {
        return cognome.get();
    }

    /**
     * @brief Il metodo getNumTel() restituisce la lista dei numeri di telefono del contatto.
     * 
     * @post Restituisce il valore corrente dell'attributo associato.
     * @invariant Lo stato dell'oggetto non deve essere modificato.
     * 
     * @return La lista dei numeri di telefono.
     */
    public ArrayList<String> getNumTel() {
        return new ArrayList<>(numTel.get());
    }

    /**
     * @brief Il metodo getEmail() restituisce la lista delle email del contatto.
     * 
     * @post Restituisce il valore corrente dell'attributo associato.
     * @invariant Lo stato dell'oggetto non deve essere modificato.
     * 
     * @return La lista delle email.
     */
    public ArrayList<String> getEmail() {
        return new ArrayList<>(email.get());
    }

    /**
     * @brief Il metodo setNome() imposta il nome del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param nome Il nuovo valore del nome del contatto.
     */
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            this.nome.set("");  // Se il parametro è null o vuoto, assegna una stringa vuota
        } else {
            this.nome.set(nome);  // Altrimenti, assegna il valore passato
        }
    }

    /**
     * @brief Il metodo setCognome() imposta il cognome del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param cognome Il nuovo valore del cognome del contatto.
     */
    public void setCognome(String cognome) {
        if (cognome == null || cognome.isEmpty()) {
            this.cognome.set("");  // Se il parametro è null o vuoto, assegna una stringa vuota
        } else {
            this.cognome.set(cognome);  // Altrimenti, assegna il valore passato
        }
    }

    /**
     * @brief Il metodo setNumTel() imposta la lista dei numeri di telefono del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param numTel La lista dei numeri di telefono.
     */
    public void setNumTel(ArrayList<String> numTel) {
        if (numTel != null) {
            ArrayList<String> listaSenzaDuplicati = new ArrayList<>();
            for (String numero : numTel) {
                if (!listaSenzaDuplicati.contains(numero)) {
                    listaSenzaDuplicati.add(numero);
                }
            }
            // Mantieni solo i primi 3 numeri
            this.numTel.set(FXCollections.observableArrayList(listaSenzaDuplicati.subList(0, Math.min(listaSenzaDuplicati.size(), MAX_CONTACTS))));
        } else {
            this.numTel.set(FXCollections.observableArrayList());
        }
    }

    /**
     * @brief Il metodo setEmail() imposta la lista delle email del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param email La lista delle email.
     */
    public void setEmail(ArrayList<String> email) {
        if (email != null) {
            // Mantieni solo le prime 3 email
            this.email.set(FXCollections.observableArrayList(email.subList(0, Math.min(email.size(), MAX_CONTACTS))));
        } else {
            this.email.set(FXCollections.observableArrayList());
        }
    }

    /**
     * @brief Il metodo toString() restituisce una rappresentazione del contatto come stringa.
     * 
     * @return Una stringa che rappresenta il contatto.
     */
    
    @Override
        public String toString() {
        String numeriAsString = String.join(", ", numTel);
        String emailsAsString = String.join(", ", email);
        return nome.get() + "|" + cognome.get() + "|" + numeriAsString + "|" + emailsAsString;
}

    /** 
    * @brief Questo metodo consente di accedere alla proprietà nome del contatto come un oggetto di tipo StringProperty
    * @return La proprietà "nome" del contatto
    *
    */
    public StringProperty nomeProperty() {
        return nome;
    }
    /**
     * @brief Questo metodo consente di accedere alla proprietà cognome del contatto come un oggetto di tipo StringProperty
     * 
     * @return La proprietà cognome del contatto
     */
    public StringProperty cognomeProperty() {
        return cognome;
    }
    
    /**
     * @brief Questo metodo consente di accedere alla lista dei numero di telefono del contatto come un oggetto di tipo ListProperty<String> 
     * 
     * @return La proprietà lista dei numeri di telefono del contatto
     */

    // Proprietà per numeri di telefono ed email
    public ListProperty<String> numTelProperty() {
        return numTel;
    }
    /**
     * @brief Questo metodo consente di accedere alla lista delle email del contatto come un oggeto di tipo ListProperty<String>
     *  
     * @return La proprietà lista delle email del contatto
     */

    public ListProperty<String> emailProperty() {
        return email;
    }
}