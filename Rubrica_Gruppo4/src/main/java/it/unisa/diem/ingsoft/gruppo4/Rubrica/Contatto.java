package it.unisa.diem.ingsoft.gruppo4.Rubrica;

import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.ListProperty;
import javafx.beans.property.StringProperty;

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

        public Contatto() {
            
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
        
    }

    /**
     * @brief Il metodo setNome() imposta il nome del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] nome il nome del contatto.
     */
    public void setNome(String nome) {
        
    }

    /**
     * @brief Il metodo setCognome() imposta il cognome del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] cognome Il cognome del contatto.
     */
    public void setCognome(String cognome) {
        
    }

    /**
     * @brief Il metodo setNumTel() imposta la lista dei numeri di telefono del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] numTel La lista dei numeri di telefono.
     */
    public void setNumTel(ArrayList<String> numTel) {
      
    }
    
       // Metodo per aggiungere un singolo numero di telefono (con limite massimo di 3)
    public void addTelefono(String telefono) {
        
    }

    /**
     * @brief Il metodo setEmail() imposta la lista delle email del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] email La lista delle email.
     */
    public void setEmail(ArrayList<String> email) {
       
    }
    
    // Metodo per aggiungere una singola email (con limite massimo di 3)
    public void addEmail(String email) {
       
    }

    /**
     * @brief Il metodo toString() restituisce una rappresentazione del contatto come stringa.
     * 
     * @return Una stringa che rappresenta il contatto.
     */
    public String toString() {
        return nome + "\\|" + cognome + "\\|" + numTel + "\\|" + email + "\\|";
      }

}